package com.roche.infinity.installer.install4j.component.button;

import java.awt.Dimension;
import javax.swing.JComponent;

import com.roche.infinity.installer.install4j.actionlistener.FinishButtonActionListener;
import com.roche.infinity.installer.install4j.screen.component.button.RocheButton;
import com.roche.infinity.installer.install4j.style.utilities.Utilities.StyleProperties.ButtonTypes;
import com.roche.infinity.installer.install4j.wrapper.button.RocheButtonWrapper;

/**
 * 
 * @author Jordi Campreciós
 * @date May 2018
 * Define the roche button finish
 */
public class RocheButtonFinish extends RocheButtonWrapper {

	/**
	 * Default constructor
	 */
	public RocheButtonFinish() {
		super();
	}
	
	/**
	 * Creates the button
	 */
	@Override
	public JComponent createCenterComponent() {
		
		Dimension d = new Dimension(this.getWidth(), this.getHeight());
		rocheButton = new RocheButton(ButtonTypes.NORMAL, d, this.getTextLabel(), this.getTextToolTip(), this.getFont(), 
				this.getButtonIconFile(), this.isHide(), this.isDisable());
		
		rocheButton.addActionListener(new FinishButtonActionListener(getContext()));
		
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
