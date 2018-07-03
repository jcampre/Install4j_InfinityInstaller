package com.roche.infinity.installer.install4j.action;

import java.io.File;

import com.install4j.api.Util;
import com.install4j.api.context.Context;
import com.install4j.api.context.InstallerContext;
import com.roche.infinity.installer.install4j.utils.FileUtils;

/**
 * Create Folder action
 * @author jcamprec
 */
public class CreateFolderAction extends AbstractRocheAction {

	private boolean preaction=true;
	private String folder;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public CreateFolderAction() {
		super();
	}
	
	/**
	 * @return the folder
	 */
	public String getFolder() {		
		return replaceVariables(folder);
	}

	/**
	 * @param folder the folder to set
	 */
	public void setFolder(String folder) {		
		this.folder = folder;		
	}

	private boolean createFolder(Context context) {
		//create folder		
		return FileUtils.createFolder(getFolder());
	}
	/**
	 * 
	 */
	@Override
	public boolean execute(Context context) throws Exception {
		if (preaction)
			return createFolder(context);
			
		return false;
	}

	/**
	 * 
	 */
	@Override
	public boolean execute(Context context, String toScreen) throws Exception {		
		return true;
	}

	@Override
	public void reportFailure(Context context, Exception e) {
	}
	
	/**
	 * atomic rollback
	 * @param context - install4j installer context
	 */
	@Override
	public void rollback(InstallerContext context) {
		File folder = new File(this.folder);
		if (folder.exists())
			FileUtils.delete(folder);
	}

	@Override
	public boolean preaction(Context context) { 
		//if error on preaction, change preaction to false
		return preaction;		
	}

	@Override
	public boolean postaction(Context context) {	
		return false;		
	}
}
