package com.roche.infinity.installer.install4j.action;

import com.install4j.api.context.Context;
import com.install4j.api.screens.Screen;

/**
 * 
 * @author Jordi Camprecios
 * Define the installation action
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
