package com.roche.infinity.actionlistener;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import com.install4j.api.context.Context;
import com.install4j.api.context.InstallerContext;
import com.roche.infinity.install4j.installation.action.InstallationAction;

/**
 * 
 * @author Jordi Arenas
 * @date May 2018
 * 
 */
public class FinishActionListener extends AbstractActionListener {	
	
	public FinishActionListener(Context context) {
		super(context);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);		
	}
}
