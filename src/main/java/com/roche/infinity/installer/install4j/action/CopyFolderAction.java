package com.roche.infinity.installer.install4j.action;

import java.io.File;
import java.io.IOException;
import com.install4j.api.context.Context;
import com.install4j.api.context.InstallerContext;
import com.roche.infinity.installer.install4j.utils.FileUtils;
import com.roche.infinity.installer.install4j.utils.LoggerManager;

/**
 *  * @author grebonfe
 *
 */
public class CopyFolderAction extends AbstractRocheAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void reportFailure(Context context, Exception e) {	
	}

	/**
	 * 
	 * @param context
	 */
	private boolean copyFolder(File sourceFolder, File destinationFolder) {
		try {
			FileUtils.copyFolder(sourceFolder, destinationFolder);
			return true;
		}
		catch(IOException ioe) {
			LoggerManager.getInstance(CopyFolderAction.class).info(CopyFolderAction.class.getSimpleName(), "Error copying folder " + sourceFolder.getName() + " to " + destinationFolder.getName()+ ". Error:"+ioe.getLocalizedMessage());
			return false;
		}
		catch (Exception e) {
			LoggerManager.getInstance(CopyFolderAction.class).info(CopyFolderAction.class.getSimpleName(), "Error copying folder " + sourceFolder.getName() + " to " + destinationFolder.getName()+ ". Error:"+e.getLocalizedMessage());
			return false;
		}		
	}
	
	@Override
	public boolean execute(Context context) throws Exception {
		File sourceFolder = null;
		File destinationFolder = null;
		return copyFolder(sourceFolder, destinationFolder);
	}

	@Override
	public boolean execute(Context context, String toScreen) throws Exception {	
		return false;
	}

	@Override
	public void rollback(InstallerContext context) {		
	}
	
	@Override
	public boolean preaction(Context context) {		
		return false;
	}

	@Override
	public boolean postaction(Context context) {		
		return false;
	}

}
