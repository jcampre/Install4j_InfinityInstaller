package com.roche.infinity.actionlistener;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import com.install4j.api.context.Context;

/**
 * 
 * @author Jordi Arenas
 * @date May 2018
 * 
 */
public class NextActionListener extends AbstractActionListener {		
	
	public NextActionListener(Context context) {
		super(context);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.getContext().goForward(1, true, true);		
	}
}
