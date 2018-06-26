package com.roche.infinity.installer.install4j.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.install4j.api.context.Context;

/**
 * 
 * @author Jordi Arenas
 * @date May 2018
 * 
 */
public abstract class AbstractActionListener implements ActionListener {
	
	private final Context context;

	/**
	 * @return the context
	 */
	public Context getContext() {
		return context;
	}

	/**
	 * 
	 * @param context
	 */
	public AbstractActionListener(Context context) {		
		this.context=context;
	}

	/**
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
