package com.roche.infinity.action;

import com.install4j.api.context.Context;
import com.install4j.api.context.InstallerContext;
import com.roche.infinity.installer.install4j.action.installation.InstallationAction;

/**
 * 
 * @author Jordi Campreciós
 * @date May 2018 Define the installation action
 */
public class FinishButtonAction extends AbstractRocheAction  {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Default constructor
	 */
	public FinishButtonAction() {
		super();		
	}
	
	/**
	 * 
	 * @param context
	 */
	private void finish(Context context) {
		InstallationAction installAc = new InstallationAction();
    	installAc.finish((InstallerContext)context);
	}
	
	/**
	 * 
	 */
	@Override
	public boolean execute(Context context) throws Exception {
		finish(context);
		return true;
	}

	/**
	 * 
	 */
	@Override
	public boolean execute(Context context, String toScreen) throws Exception {
		// TODO Auto-generated method stub
		return false;
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
