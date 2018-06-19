package com.roche.infinity.actionlistener;

import java.awt.event.ActionEvent;

import com.install4j.api.context.Context;
import com.install4j.api.context.InstallerContext;
import com.roche.infinity.action.FinishButtonAction;
import com.roche.infinity.installer.install4j.utils.LoggerManager;


/**
 * 
 * @author Jordi Arenas
 * @date May 2018
 * 
 */
public class FinishButtonActionListener extends AbstractActionListener {	
	/**
	 * 
	 * @param context
	 */
	public FinishButtonActionListener(Context context) {
		super(context);
	}

	/**
	 * @param ActionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		FinishButtonAction ac = new FinishButtonAction();
		try {
			ac.install((InstallerContext)this.getContext());
		} catch (Exception ex) {
			LoggerManager.getInstance(FinishButtonActionListener.class).error(FinishButtonActionListener.class.getSimpleName(), ex.getLocalizedMessage(), ex);
		}
	}
}
