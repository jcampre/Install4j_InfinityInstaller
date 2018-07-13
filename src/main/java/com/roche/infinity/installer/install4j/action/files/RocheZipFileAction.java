package com.roche.infinity.installer.install4j.action.files;

import java.io.File;

import com.install4j.api.Util;
import com.install4j.api.context.Context;
import com.install4j.api.context.InstallerContext;
import com.install4j.api.context.UserCanceledException;
import com.install4j.runtime.beans.actions.files.AbstractZipFileAction;
import com.roche.infinity.installer.install4j.action.AbstractRocheAction;
import com.roche.infinity.installer.install4j.action.CreateFolderAction;
import com.roche.infinity.installer.install4j.utils.FileUtils;

/**
 * Zip file action
 * 
 * @author jarenas
 */
public class RocheZipFileAction extends AbstractZipFileAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public RocheZipFileAction() {
		super();
	}

	@Override
	protected File getTargetDirectory(Context arg0)
	{
		// TODO Auto-generated method stub
		Util.showMessage("getTargetDirectory");

		return FileUtils.createFolder2("C:/temp");
		// folAct.install((InstallerContext) arg0);
	}

	@Override
	protected boolean passesFileFilter(String arg0, Context arg1) {
		// TODO Auto-generated method stub
		Util.showMessage("passesFileFilter");
		return true;
	}

	// @Override
	// protected File getZipFile() {
	// // TODO Auto-generated method stub
	// Util.showMessage("getZipFile");
	// return new File("");
	// }

}
