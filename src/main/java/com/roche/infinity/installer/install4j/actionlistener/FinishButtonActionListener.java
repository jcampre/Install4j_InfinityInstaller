package com.roche.infinity.installer.install4j.actionlistener;

import java.awt.event.ActionEvent;
import com.install4j.api.context.Context;
import com.install4j.api.context.InstallerContext;
import com.roche.infinity.installer.install4j.action.FinishButtonAction;
import com.roche.infinity.installer.install4j.utils.LoggerManager;

/**
 * 
 * @author Jordi Arenas
 * 
 */
public class FinishButtonActionListener extends AbstractActionListener {	
	/**
	 * 
	 * @param context - the install4j context
	 */
	public FinishButtonActionListener(Context context) {
		super(context);
	}

	/**
	 * @param actionEvent -  the AcvionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		FinishButtonAction ac = new FinishButtonAction();
		try {
			ac.install((InstallerContext)this.getContext());
		} catch (Exception ex) {
			LoggerManager.getInstance(FinishButtonActionListener.class).error(FinishButtonActionListener.class.getSimpleName(), ex.getLocalizedMessage(), ex);
		}
	}
}
