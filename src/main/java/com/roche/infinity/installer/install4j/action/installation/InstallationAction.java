package com.roche.infinity.installer.install4j.action.installation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import com.install4j.api.actions.AbstractInstallAction;
import com.install4j.api.context.Context;
import com.install4j.api.context.InstallerContext;
import com.install4j.api.context.NotSupportedInElevationException;
import com.install4j.api.context.UserCanceledException;
import com.install4j.api.screens.Screen;
import com.roche.infinity.installer.install4j.action.FinishButtonAction;
import com.roche.infinity.installer.install4j.report.ComponentList;
import com.roche.infinity.installer.install4j.report.ReportWriter;
import com.roche.infinity.installer.install4j.utils.FileUtils;
import com.roche.infinity.installer.install4j.utils.LoggerManager;
import com.roche.infinity.installer.install4j.utils.ProgressBarUtils;
import com.roche.infinity.installer.install4j.utils.Utils;

/**
 * 
 * @author Jordi Campreciós
 * @date May 2018 Define the installation action
 */
public class InstallationAction extends AbstractInstallAction{

	private static final long serialVersionUID = 1L;
	
	private static final String BIN_FOLDER = "bin";
	private static final String REPORT_EXT = ".json";
	private static final String DIRECTORY_INSTALLATION = "directoryInstallation";		
	private static final String TOMCAT_SERVICENAME = "TOMCAT_SERVICENAME";
	private static final String TOMCAT_DIRECTORY = "tomcat_directory";
	private static final String LINE_SEPARATOR = "\\";
	private static final String INSTALLATION_START = "installationStart";
	/**
	 * 
	 */
	public InstallationAction() {
		super();
	}

	/**
	 * @param context
	 */
	@Override
	public void rollback(InstallerContext context) {
		//This is first executed and then the default rollback (the one from install4j)
		if ((Boolean)context.getVariable(INSTALLATION_START)) {
			//change status bar
			ProgressBarUtils.updateProgressBar(context, "screen_installationScreen", "installationProgressBarAction", context.getMessage("screen.screen_InstallationScreen.installationProgressBarAction.text.cancelling"),
					context.getMessage("screen.screen_InstallationScreen.installationProgressBarAction.text.cancelling"), null, false, null, null);
				
			handleServices(context);

			File f = new File((String)context.getVariable(DIRECTORY_INSTALLATION));			
			if (f.exists()) {
				LoggerManager.getInstance(InstallationAction.class).info(InstallationAction.class.getSimpleName(), "Deleting files");
				FileUtils.delete(f);
			} else {
				LoggerManager.getInstance(InstallationAction.class).info(InstallationAction.class.getSimpleName(), "Nothing to delete");
			}
		} 
	}
	
	/**
	 * 
	 * @param context
	 */
	private void handleServices(Context context) {		
		//stop tomcat service
		String serviceName=(String)context.getCompilerVariable(TOMCAT_SERVICENAME);			
		int tomcatStatus=Utils.checkService(serviceName);			
		String tomcatPath=(String)context.getVariable(TOMCAT_DIRECTORY) + LINE_SEPARATOR + BIN_FOLDER+LINE_SEPARATOR;
		LoggerManager.getInstance(InstallationAction.class).info(InstallationAction.class.getSimpleName(), "tomcat status: " + tomcatStatus);
		LoggerManager.getInstance(InstallationAction.class).info(InstallationAction.class.getSimpleName(), "tomcat serviceName: " + serviceName);
		LoggerManager.getInstance(InstallationAction.class).info(InstallationAction.class.getSimpleName(), "tomcat tomcatPath: " + tomcatPath);
		
		try {		
			
			switch (tomcatStatus) {
			case 0:
				//not installed
				break;
			case 1:
				//installed but stopped
				//uninstall
				((com.install4j.api.actions.InstallAction)context.getActionById("uninstall_tomcat_service")).install((InstallerContext) context);				
				break;
			case 2:
				//running
				//stop					
				((com.install4j.api.actions.InstallAction)context.getActionById("stop_tomcat_service")).install((InstallerContext) context);				
				//uninstall				
				((com.install4j.api.actions.InstallAction)context.getActionById("uninstall_tomcat_service")).install((InstallerContext) context);				
				break;
			default:				
				break;
			}
		} 
		catch (NotSupportedInElevationException e) {			// 
			LoggerManager.getInstance(InstallationAction.class).error(InstallationAction.class.getSimpleName(), "NotSupportedInElevationException error " +e.getLocalizedMessage(), e);
			e.printStackTrace();
		} 
		catch (UserCanceledException e) {
			LoggerManager.getInstance(InstallationAction.class).error(InstallationAction.class.getSimpleName(), "UserCanceledException error " +e.getLocalizedMessage(), e);		
		} 
		catch (Exception e) {
			LoggerManager.getInstance(InstallationAction.class).error(InstallationAction.class.getSimpleName(), "Exception error " +e.getLocalizedMessage(), e);
		}		
	}

	/**
	 * @param context
	 */	
	public void canceled(InstallerContext context) {		
		//redirect to Error screen
		Screen errorScreen = context.getScreenById("screen_error");
		context.gotoScreen(errorScreen);
		
		//copy log file
		FileUtils.copyLogFile(context);
	}	

	/**
	 * 
	 * @param context
	 */
	public void finish(Context context) {
		try {
			ReportWriter.writeJSON(ComponentList.getInstance(), 
					new FileWriter(new StringBuffer((String)context.getVariable(DIRECTORY_INSTALLATION)).
				    append(Utils.getFormattedCurrentDate()).append(REPORT_EXT).toString()));
						
			//copy log file
			FileUtils.copyLogFile(context);
			//exit app			
			context.finish(0);
		} catch (IOException e) {
			LoggerManager.getInstance(FinishButtonAction.class).error(FinishButtonAction.class.getSimpleName(), "Error when  trying to save the installation report: " + e.getLocalizedMessage(), e);					
		}
	}
	
	@Override
	public boolean install(InstallerContext arg0) throws UserCanceledException {
		// TODO Auto-generated method stub
		return false;
	}
}
