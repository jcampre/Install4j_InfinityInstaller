package com.roche.infinity.actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.install4j.api.context.Context;

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
