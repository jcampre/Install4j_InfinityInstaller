package com.roche.infinity.action;

import com.install4j.api.context.Context;
import com.install4j.api.context.ControlButtonType;

/**
 * 
 * @author Jordi Campreciós
 * @date May 2018 Define the installation action
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
