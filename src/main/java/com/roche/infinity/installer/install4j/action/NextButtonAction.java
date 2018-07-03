package com.roche.infinity.installer.install4j.action;

import com.install4j.api.context.Context;
import com.install4j.api.context.ControlButtonType;

/**
 * 
 * @author Jordi Camprecios
 * Define the installation action
 */
public class NextButtonAction extends AbstractRocheAction {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Default constructor
	 */
	public NextButtonAction() {
		super();		
	}
	
	/**
	 * 
	 * @param context
	 */
	private void next(Context context) {
		context.getWizardContext().pressControlButton(ControlButtonType.NEXT);
	}
	
	@Override
	public boolean execute(Context context) throws Exception {
		next(context);
		return true;
	}

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
