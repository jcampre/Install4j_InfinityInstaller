package com.roche.infinity.installer.install4j.actionlistener;

import java.awt.event.ActionEvent;
import com.install4j.api.context.Context;
import com.install4j.api.context.InstallerContext;
import com.roche.infinity.installer.install4j.action.PreviousButtonAction;
import com.roche.infinity.installer.install4j.utils.LoggerManager;

/**
 * 
 * @author Jordi Arenas
 * @date May 2018
 * 
 */
public class PreviousButtonActionListener extends AbstractActionListener {
	/**
	 * 
	 * @param context
	 */
	public PreviousButtonActionListener(Context context) {
		super(context);		
	}

	/**
	 * @param ActionEvent
	 */
	@Override	
	public void actionPerformed(ActionEvent e) {		
		PreviousButtonAction ac = new PreviousButtonAction();
		try {
			ac.install((InstallerContext)this.getContext());
		} catch (Exception ex) {
			LoggerManager.getInstance(PreviousButtonActionListener.class).error(PreviousButtonActionListener.class.getSimpleName(), ex.getLocalizedMessage(), ex);
		}
	}
}
