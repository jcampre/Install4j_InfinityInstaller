package com.roche.infinity.action;

import com.install4j.api.context.Context;
import com.roche.infinity.installer.install4j.utils.Utils;

/**
 * Create Folder action
 * @author jcamprec
 * @Date June 2018
 */
public class CreateFolderAction extends AbstractRocheAction {

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
	
	public void createFolder(Context context) {
		//create folder
		Utils.createFolder((String)context.getVariable("backupFolder"));
	}
	
	/**
	 * 
	 */
	@Override
	public boolean execute(Context context) throws Exception {
		createFolder(context);
		return true;
	}

	/**
	 * 
	 */
	@Override
	public boolean execute(Context context, String toScreen) throws Exception {		
		createFolder(context);
		return true;
	}

	@Override
	public void reportFailure(Context context, Exception e) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean preaction(Context context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean postaction(Context context) {
		// TODO Auto-generated method stub
		return false;
	}
}
