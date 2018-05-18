package com.roche.infinity.actionlistener;

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
	
	private Context context;

	/**
	 * @return the context
	 */
	public Context getContext() {
		return context;
	}

	/**
	 * @param context the context to set
	 */
	public void setContext(Context context) {
		this.context = context;
	}

	public AbstractActionListener(Context context) {		
		this.setContext(context);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
