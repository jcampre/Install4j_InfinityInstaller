package com.roche.infinity.installer.install4j.action;

import com.install4j.api.actions.AbstractInstallOrUninstallAction;
import com.install4j.api.context.Context;
import com.install4j.api.context.InstallerContext;
import com.install4j.api.context.UninstallerContext;
import com.install4j.api.context.UserCanceledException;

/**
 * 
 * @author Jordi Campreciós
 * @date May 2018 Define the installation action
 */
public abstract class AbstractRocheAction extends AbstractInstallOrUninstallAction {

	private static final long serialVersionUID = 1L;	
	protected boolean reportFailure = true;
	
	/**
	 * Default constructor
	 */
	public AbstractRocheAction() {
		super();
	}
	
	/**
	 * 
	 * @param context
	 * @param e
	 */
	protected abstract void reportFailure(final Context context, final Exception e);

	/**
	 * 
	 */
	@Override
	public boolean install(final InstallerContext context) throws UserCanceledException {
		try {
			return execute(context);
		} catch (Exception e) {
			reportFailure(context, e);
			return false;
		}
	}
	
	/**
	 * 
	 * @param context
	 * @param toScreen
	 * @return
	 * @throws UserCanceledException
	 */
	public boolean install(final InstallerContext context, final String toScreen) throws UserCanceledException {
		try {
			return execute(context, toScreen);
		} catch (Exception e) {
			reportFailure(context, e);
			return false;
		}
	}
	
	/**
	 * 
	 */
	@Override
	public boolean uninstall(final UninstallerContext context) throws UserCanceledException {
		try {
			return execute(context);
		} catch (Exception e) {
			reportFailure(context, e);
			return false;
		}
	}
	
	/**
	 * 
	 * @param context
	 * @return
	 * @throws Exception
	 */
	protected abstract boolean execute(Context context) throws Exception;
	
	/**
	 * 
	 * @param context
	 * @param toScreen
	 * @return
	 * @throws Exception
	 */
	protected abstract boolean execute(Context context, String toScreen) throws Exception;

	/**
	 * What to do before executing action
	 * @param context
	 */
	protected abstract boolean preaction(final Context context);
	
	/**
	 * What to do after executing action
	 * @param context
	 */
	protected abstract boolean postaction(final Context context);
}
