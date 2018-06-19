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
public class ForwardToScreenButtonActionListener extends AbstractActionListener {		
	private String toScreen;
	/**
	 * 
	 * @param context
	 */
	public ForwardToScreenButtonActionListener(Context context, String toScreen) {
		super(context);		
		this.toScreen = toScreen;
	}

	/**
	 * @param ActionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		ForwardToAction ac = new ForwardToAction();
		try {
			ac.install((InstallerContext)this.getContext(), this.toScreen);
		} catch (Exception ex) {
			LoggerManager.getInstance(ForwardToScreenButtonActionListener.class).error(ForwardToScreenButtonActionListener.class.getSimpleName(), ex.getLocalizedMessage(), ex);
		}
	}
}
