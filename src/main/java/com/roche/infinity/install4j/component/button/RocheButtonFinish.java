package com.roche.infinity.install4j.component.button;

import javax.swing.JComponent;

import com.roche.infinity.actionlistener.FinishActionListener;
import com.roche.infinity.install4j.wrapper.button.RocheButtonWrapper;
import com.roche.infinity.screen.component.button.RocheButton;


/**
 * 
 * @author Jordi Campreciós
 * @date May 2018
 * Define the roche button finish
 */
public class RocheButtonFinish extends RocheButtonWrapper {
	
	/**
	 * default constructor
	 */
	public RocheButtonFinish() {
		super();
	}
	
	/**
	 * Creates the button
	 */
	@Override
	public JComponent createCenterComponent() {
		
		rocheButton = new RocheButton(
				this.getWidth(), this.getHeight(), 
				this.getTextLabel(), this.getTextToolTip(), null, 
				this.getButtonIconFile(), this.isHide());
		
		rocheButton.addActionListener(new FinishActionListener(this.getContext()));
		
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
