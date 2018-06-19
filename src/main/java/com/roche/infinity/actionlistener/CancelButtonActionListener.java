package com.roche.infinity.actionlistener;

import java.awt.event.ActionEvent;
import com.install4j.api.context.Context;
import com.install4j.api.context.InstallerContext;
import com.roche.infinity.action.CancelButtonAction;
import com.roche.infinity.installer.install4j.utils.LoggerManager;

/**
 * 
 * @author Jordi Arenas
 * @date May 2018
 * 
 */
public class CancelButtonActionListener extends AbstractActionListener {
		
	public CancelButtonActionListener(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * @param ActionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		CancelButtonAction ac = new CancelButtonAction();
		try {
			ac.install((InstallerContext)this.getContext());
		} catch (Exception ex) {
			LoggerManager.getInstance(CancelButtonActionListener.class).error(CancelButtonActionListener.class.getSimpleName(), ex.getLocalizedMessage(), ex);
		}
	}
}
