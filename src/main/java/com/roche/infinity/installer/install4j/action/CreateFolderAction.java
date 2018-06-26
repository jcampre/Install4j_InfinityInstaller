package com.roche.infinity.installer.install4j.action;

import java.io.File;
import com.install4j.api.context.Context;
import com.install4j.api.context.InstallerContext;
import com.roche.infinity.installer.install4j.utils.FileUtils;

/**
 * Create Folder action
 * @author jcamprec
 * @Date June 2018
 */
public class CreateFolderAction extends AbstractRocheAction {

	private static final String BACKUP_FOLDER = "backupFolder";
	private boolean preaction=true;
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
	
	private boolean createFolder(Context context) {
		//create folder
		return FileUtils.createFolder((String)context.getVariable(BACKUP_FOLDER));
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
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * atomic rollback
	 * @param context
	 */
	@Override
	public void rollback(InstallerContext context) {
		File folder = new File((String)context.getVariable(BACKUP_FOLDER));
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
