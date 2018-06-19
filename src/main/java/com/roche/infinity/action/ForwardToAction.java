package com.roche.infinity.action;

import com.install4j.api.context.Context;
import com.install4j.api.screens.Screen;

/**
 * 
 * @author Jordi Campreciós
 * @date May 2018 Define the installation action
 */
public class ForwardToAction extends AbstractRocheAction {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Default constructor
	 */
	public ForwardToAction() {
		super();		
	}
	
	/**
	 * 
	 * @param context
	 */
	private void forwardTo(Context context, String toScreen) {
		Screen screen = context.getScreenById(toScreen);
		context.gotoScreen(screen);
	}
	
	public boolean execute(Context context, String screen) throws Exception {
		forwardTo(context, screen);
		return true;
	}

	@Override
	public boolean execute(Context context) throws Exception {
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
