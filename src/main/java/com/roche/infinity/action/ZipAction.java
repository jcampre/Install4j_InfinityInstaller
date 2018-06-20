package com.roche.infinity.action;

import java.io.File;
import java.io.IOException;

import com.install4j.api.Util;
import com.install4j.api.context.Context;
import com.install4j.api.context.InstallerContext;
import com.roche.infinity.installer.install4j.utils.LoggerManager;
import com.roche.infinity.installer.install4j.utils.Utils;
import com.roche.infinity.installer.install4j.utils.ZipUtils;

public class ZipAction extends AbstractRocheAction {

	ZipUtils appZip = null;

	private File sourceFolder;
	private File destinationZipFile;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public File getSourceFolder() {
		// call replaceVariables to resolve installer variables
		return sourceFolder;
	}

	public void setSourceFolder(File sourceFolder) {
		this.sourceFolder = sourceFolder;
	}
	
	public File getDestinationZipFile() {
		// call replaceVariables to resolve installer variables
		return destinationZipFile;
	}

	public void setDestinationZipFile(File destinationZipFile) {
		this.destinationZipFile = destinationZipFile;
	}

	@Override
	protected boolean execute(Context context) throws Exception {
		Util.showMessage("Execute ZipAction");
		appZip = new ZipUtils();
		Util.logInfo(null, "appZip = new ZipUtils();");
		
//		Util.showMessage((String) context.getVariable("directoryInstallation"));
		appZip.generateFileList(sourceFolder);
		Util.showMessage("appZip.generateFileList");
		
		appZip.zipIt(appZip.getOutputZipFile());
		Util.logInfo(null, "appZip = new ZipUtils();");
		
		return true;
	}

	@Override
	protected boolean execute(Context context, String toScreen) throws Exception {
		Util.showMessage("Execute ZipAction");
		appZip = new ZipUtils();
		appZip.generateFileList(new File((String) context.getVariable("directoryInstallation")));
		Util.showMessage("Execute ZipAction en fitxer: " + appZip.getOutputZipFile());
		appZip.zipIt(appZip.getOutputZipFile());

		return true;
	}

	@Override
	protected boolean preaction(Context context) {

		return true;
	}

	@Override
	protected boolean postaction(Context context) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void rollback(InstallerContext context) {
		try {
			Utils.deleteFile(appZip.getOutputZipFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(),
					"Failed to delete file: " + appZip.getOutputZipFile());
		}
	}

	@Override
	protected void reportFailure(Context context, Exception exception) {
		// TODO Auto-generated method stub

	}
}
