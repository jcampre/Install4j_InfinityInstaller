package com.roche.infinity.installer.install4j.actionlistener;

import java.awt.event.ActionEvent;
import com.install4j.api.context.Context;
import com.install4j.api.context.InstallerContext;
import com.roche.infinity.installer.install4j.action.NextButtonAction;
import com.roche.infinity.installer.install4j.utils.LoggerManager;

/**
 * 
 * @author Jordi Arenas
 * 
 */
public class NextButtonActionListener extends AbstractActionListener {		
	
	/**
	 * 
	 * @param context - the install4j context
	 */
	public NextButtonActionListener(Context context) {
		super(context);		
	}

	/**
	 * @param actionEvent  - the ActionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		NextButtonAction ac = new NextButtonAction();
		try {
			ac.install((InstallerContext)this.getContext());
		} catch (Exception ex) {
			LoggerManager.getInstance(NextButtonActionListener.class).error(NextButtonActionListener.class.getSimpleName(), ex.getLocalizedMessage(), ex);
		}
	}
}
