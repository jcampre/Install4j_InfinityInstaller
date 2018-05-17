package com.roche.infinity.install4j.installation.action;

import com.install4j.api.Util;
import com.install4j.api.actions.AbstractInstallAction;
import com.install4j.api.context.InstallerContext;
import com.install4j.api.context.UserCanceledException;

/**
 * 
 * @author Jordi Campreciós
 * @date May 2018
 *
 */
public class InstallationAction extends AbstractInstallAction{

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@Override
	public boolean install(InstallerContext arg0) throws UserCanceledException {	
		return false;
	}
	
	/**
	 * 
	 */
	@Override
	public void rollback(InstallerContext context) {
		Util.showMessage("In rollback");		
	}
}
