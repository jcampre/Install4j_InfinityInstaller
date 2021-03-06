package com.roche.infinity.installer.install4j.actionlistener;

import java.awt.event.ActionEvent;
import com.install4j.api.context.Context;
import com.install4j.api.context.InstallerContext;
import com.roche.infinity.installer.install4j.action.ForwardToAction;
import com.roche.infinity.installer.install4j.utils.LoggerManager;

/**
 * 
 * @author Jordi Arenas
 * 
 */
public class ForwardToScreenButtonActionListener extends AbstractActionListener {	
	
	private String toScreen;
	
	/**
	 * 
	 * @param context -  the install4j context
	 * @param toScreen - the screen to forward
	 */
	public ForwardToScreenButtonActionListener(Context context, String toScreen) {
		super(context);		
		this.toScreen = toScreen;
	}

	/**
	 * @param actionEvent the ActionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		ForwardToAction ac = new ForwardToAction();
		try {
			ac.install((InstallerContext)this.getContext(), this.toScreen);
		} catch (Exception ex) {
			LoggerManager.getInstance(ForwardToScreenButtonActionListener.class).error(ForwardToScreenButtonActionListener.class.getSimpleName(), ex.getLocalizedMessage(), ex);
		}
	}
}
