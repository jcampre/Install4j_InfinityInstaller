package com.roche.infinity.install4j.component.button;

import javax.swing.*;

import com.install4j.api.Util;
import com.roche.infinity.actionlistener.CancelActionListener;
import com.roche.infinity.screen.component.button.RocheButton;
import com.roche.infinity.screen.component.ui.button.RocheButtonUI;
import com.roche.infinity.install4j.wrapper.button.RocheButtonWrapper;

/**
 * 
 * @author Jordi Campreciós
 * @date May 2018
 * Define the roche button cancel
 */
public class RocheButtonCancel extends RocheButtonWrapper {
	
	private final static RocheButtonUI m_buttonUI = new RocheButtonUI();
	
	/**
	 * Creates the button
	 */
	@Override
	public JComponent createCenterComponent() {
//		Util.showMessage("amplada " + this.getWidth() + " y alçada " + this.getHeight() + " getTextLabel " + this.getTextLabel());
		
		rocheButton = new RocheButton(this.getWidth(), this.getHeight(), 
				this.getTextLabel(), this.getTextToolTip(), this.getFont(), 
				this.getButtonIconFile(), this.isHide());		
		
		rocheButton.setUI(m_buttonUI);
		//rocheButton.addActionListener(new CancelActionListener(this.getContext())); 
		return rocheButton;
	}

	/**
	 * 
	 */
	@Override
	public boolean isFillCenterHorizontal() {		
		return false;
	}
}
