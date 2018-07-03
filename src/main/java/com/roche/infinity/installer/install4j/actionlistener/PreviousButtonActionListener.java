package com.roche.infinity.installer.install4j.actionlistener;

import java.awt.event.ActionEvent;
import com.install4j.api.context.Context;
import com.install4j.api.context.InstallerContext;
import com.roche.infinity.installer.install4j.action.PreviousButtonAction;
import com.roche.infinity.installer.install4j.utils.LoggerManager;

/**
 * 
 * @author Jordi Arenas
 * 
 */
public class PreviousButtonActionListener extends AbstractActionListener {
	/**
	 * 
	 * @param context -  the install4j context
	 */
	public PreviousButtonActionListener(Context context) {
		super(context);		
	}

	/**
	 * @param actionEvent - the ActionEvent
	 */
	@Override	
	public void actionPerformed(ActionEvent actionEvent) {		
		PreviousButtonAction ac = new PreviousButtonAction();
		try {
			ac.install((InstallerContext)this.getContext());
		} catch (Exception ex) {
			LoggerManager.getInstance(PreviousButtonActionListener.class).error(PreviousButtonActionListener.class.getSimpleName(), ex.getLocalizedMessage(), ex);
		}
	}
}
