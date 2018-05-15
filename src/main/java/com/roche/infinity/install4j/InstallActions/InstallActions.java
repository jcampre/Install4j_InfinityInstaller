package com.roche.infinity.install4j.InstallActions;

import com.install4j.api.Util;
import com.install4j.api.actions.AbstractInstallAction;
import com.install4j.api.context.InstallerContext;
import com.install4j.api.context.UserCanceledException;

public class InstallActions extends AbstractInstallAction{

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
	public void rollback(InstallerContext context)
	{
		Util.showMessage("In rollback");
		
	}
}
