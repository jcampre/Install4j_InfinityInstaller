package com.roche.infinity.install4j.installation.action;

import com.install4j.api.Util;
import com.install4j.api.actions.AbstractInstallAction;
import com.install4j.api.context.InstallerContext;
import com.install4j.api.context.UserCanceledException;

/**
 * 
 * @author Jordi Campreciós
 * @date May 2018 Define the installation action
 */
public class InstallationAction extends AbstractInstallAction {

	private static final long serialVersionUID = 1L;
	private InstallerContext context = null;

	public InstallationAction(InstallerContext context) {
		if (context != null) {
			this.context = context;
		}		
	}

	/**
	 * 
	 */
	@Override
	public boolean install(InstallerContext context) throws UserCanceledException {

		return false;
	}

	/**
	*
	*/
	public void rollback(InstallerContext context) {
		Util.showMessage("In rollback");
	}
}
