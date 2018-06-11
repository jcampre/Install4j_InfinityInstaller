package com.roche.infinity.install4j.component.button;

import javax.swing.JComponent;

import com.roche.infinity.actionlistener.NextActionListener;
import com.roche.infinity.install4j.wrapper.button.RocheButtonWrapper;
import com.roche.infinity.screen.component.button.RocheButton;

/**
 * 
 * @author Jordi Campreciós
 * @date May 2018
 * Define the roche button cancel
 */
public class RocheButtonNext extends RocheButtonWrapper {
		
	/**
	 * Creates the button
	 */
	@Override
	public JComponent createCenterComponent() {
		
		rocheButton = new RocheButton(this.getType(), this.getWidth(), this.getHeight(), this.getTextLabel(),
				this.getTextToolTip(), this.getFont(), this.getButtonIconFile(), this.isHide(), this.isDisable());

	
		rocheButton.addActionListener(new NextActionListener(this.getContext())); 

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
