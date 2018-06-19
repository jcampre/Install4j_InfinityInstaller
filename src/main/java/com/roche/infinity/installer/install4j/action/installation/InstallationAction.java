package com.roche.infinity.installer.install4j.action.installation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.install4j.api.Util;
import com.install4j.api.actions.AbstractInstallAction;
import com.install4j.api.context.Context;
import com.install4j.api.context.InstallerContext;
import com.install4j.api.context.UserCanceledException;
import com.install4j.api.screens.Screen;
import com.roche.infinity.action.FinishButtonAction;
import com.roche.infinity.installer.install4j.report.ComponentList;
import com.roche.infinity.installer.install4j.report.ReportWriter;
import com.roche.infinity.installer.install4j.utils.LoggerManager;
import com.roche.infinity.installer.install4j.utils.Utils;

/**
 * 
 * @author Jordi Campreciós
 * @date May 2018 Define the installation action
 */
public class InstallationAction extends AbstractInstallAction {

	private static final long serialVersionUID = 1L;

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
		Util.showMessage("Rollback InstallationAction");
		
		// This is first executed and then the default rollback (the one from install4j)
		if ((String) context.getVariable("directoryInstallation") != null) {
			// change status bar
			Utils.updateProgressBar(context, "screen_installationScreen", "installationProgressBarAction",
					context.getMessage(
							"screen.screen_InstallationScreen.installationProgressBarAction.text.cancelling"),
					context.getMessage(
							"screen.screen_InstallationScreen.installationProgressBarAction.text.cancelling"),
					null, false, null, null);

			File f = new File((String) context.getVariable("directoryInstallation"));
			if (f.exists()) {
				LoggerManager.getInstance(InstallationAction.class).info(InstallationAction.class.getSimpleName(),
						"Deleting files");
				Utils.delete(f);
			} else {
				LoggerManager.getInstance(InstallationAction.class).info(InstallationAction.class.getSimpleName(),
						"Nothing to delete");
			}
		}
	}

	/**
	 * @param context
	 */
	public void canceled(InstallerContext context) {
		// redirect to Error screen
		Screen errorScreen = context.getScreenById("screen_error");
		context.gotoScreen(errorScreen);

		// copy log file
		Utils.copyLogFile(context);
	}

	/**
	 * 
	 * @param context
	 */
	public void finish(Context context) {
		try {
			ReportWriter.writeJSON(ComponentList.getInstance(),
					new FileWriter(new StringBuffer((String) context.getVariable("directoryInstallation"))
							.append(Utils.getFormattedCurrentDate()).append(".json").toString()));

			// copy log file
			Utils.copyLogFile(context);
			// exit app
			context.finish(0);
		} catch (IOException e) {
			LoggerManager.getInstance(FinishButtonAction.class).error(FinishButtonAction.class.getSimpleName(),
					"Error when  trying to save the installation report: " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public boolean install(InstallerContext arg0) throws UserCanceledException {
		// TODO Auto-generated method stub
		return false;
	}
}
