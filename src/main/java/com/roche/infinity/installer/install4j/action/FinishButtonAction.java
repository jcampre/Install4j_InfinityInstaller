package com.roche.infinity.installer.install4j.action;

import com.install4j.api.context.Context;
import com.install4j.api.context.InstallerContext;
import com.roche.infinity.installer.install4j.action.installation.InstallationAction;

/**
 * 
 * @author Jordi Camprecios
 * Define the installation action
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
		return false;
	}

	@Override
	public void reportFailure(Context context, Exception e) {		
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
