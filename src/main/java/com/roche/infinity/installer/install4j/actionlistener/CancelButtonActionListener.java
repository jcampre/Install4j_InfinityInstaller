package com.roche.infinity.installer.install4j.actionlistener;

import java.awt.event.ActionEvent;
import com.install4j.api.context.Context;
import com.install4j.api.context.InstallerContext;
import com.roche.infinity.installer.install4j.action.CancelButtonAction;
import com.roche.infinity.installer.install4j.utils.LoggerManager;

/**
 * 
 * @author Jordi Arenas
 * 
 */
public class CancelButtonActionListener extends AbstractActionListener {
		
	public CancelButtonActionListener(Context context) {
		super(context);	
	}
	

	/**
	 * @param actionEvent - the action event
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		CancelButtonAction ac = new CancelButtonAction();
		try {
			ac.install((InstallerContext)this.getContext());
		} catch (Exception ex) {
			LoggerManager.getInstance(CancelButtonActionListener.class).error(CancelButtonActionListener.class.getSimpleName(), ex.getLocalizedMessage(), ex);
		}
	}
}
