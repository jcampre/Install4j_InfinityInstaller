package com.roche.infinity.action;

import java.io.File;
import java.io.IOException;

import com.install4j.api.context.Context;
import com.install4j.api.context.InstallerContext;
import com.install4j.api.context.ProgressInterface;
import com.install4j.api.context.UserCanceledException;
import com.roche.infinity.installer.install4j.action.installation.InstallationAction;
import com.roche.infinity.installer.install4j.utils.LoggerManager;
import com.roche.infinity.installer.install4j.utils.Utils;
import com.roche.infinity.installer.install4j.utils.ZipUtils;

public class ZipAction extends AbstractRocheAction {

	ZipUtils appZip = null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean install(InstallerContext arg0) throws UserCanceledException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void reportFailure(Context context, Exception exception) {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean execute(Context context) throws Exception {
		appZip.generateFileList(new File((String) context.getVariable("directoryInstallation")));
		appZip.zipIt(appZip.getOutputZipFile());

		return true;
	}

	@Override
	protected boolean execute(Context context, String toScreen) throws Exception {
		appZip.generateFileList(new File((String) context.getVariable("directoryInstallation")));
		appZip.zipIt(appZip.getOutputZipFile());

		return false;
	}

	@Override
	protected boolean preaction(Context context) {
		appZip = new ZipUtils();

		return true;
	}

	@Override
	protected boolean postaction(Context context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void rollback(InstallerContext context) {
		try {
			Utils.deleteFile(appZip.getOutputZipFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//	e.printStackTrace();
			LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), "Failed to delete file: " + appZip.getOutputZipFile());
		}
	}
}
