package com.roche.infinity.actionlistener;

import java.awt.event.ActionEvent;
import com.install4j.api.context.Context;
import com.install4j.api.context.InstallerContext;
import com.roche.infinity.action.*;
import com.roche.infinity.installer.install4j.utils.LoggerManager;

/**
 * 
 * @author Jordi Arenas
 * @date May 2018
 * 
 */
public class NextButtonActionListener extends AbstractActionListener {		
	
	/**
	 * 
	 * @param context
	 */
	public NextButtonActionListener(Context context) {
		super(context);		
	}

	/**
	 * @param ActionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		NextButtonAction ac = new NextButtonAction();
		try {
			ac.install((InstallerContext)this.getContext());
		} catch (Exception ex) {
			LoggerManager.getInstance(NextButtonActionListener.class).error(NextButtonActionListener.class.getSimpleName(), ex.getLocalizedMessage(), ex);
		}
	}
}
