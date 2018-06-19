package com.roche.infinity.action;

import com.install4j.api.context.Context;
import com.install4j.api.context.ControlButtonType;

/**
 * 
 * @author Jordi Campreciós
 * @date May 2018 Define the installation action
 */
public class PreviousButtonAction extends AbstractRocheAction {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Default constructor
	 */
	public PreviousButtonAction() {
		super();		
	}
	
	/**
	 * 
	 * @param context
	 */
	private void previous(Context context) {
		context.getWizardContext().pressControlButton(ControlButtonType.PREVIOUS);
	}
	
	@Override
	public boolean execute(Context context) throws Exception {
		previous(context);
		return true;
	}

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
