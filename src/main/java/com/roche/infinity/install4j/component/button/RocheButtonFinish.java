package com.roche.infinity.install4j.component.button;

import javax.swing.JComponent;
import com.roche.infinity.install4j.wrapper.button.RocheButtonWrapper;
import com.roche.infinity.screen.component.button.RocheButton;
import com.roche.infinity.screen.component.ui.button.RocheButtonUI;

/**
 * 
 * @author Jordi Campreciós
 * @date May 2018
 * Define the roche button finish
 */
public class RocheButtonFinish extends RocheButtonWrapper {
	
	/**
	 * Creates the button
	 */
	@Override
	public JComponent createCenterComponent() {
		rocheButton = new RocheButton(
				this.getWidth(), this.getHeight(), 
				this.getTextLabel(), this.getTextToolTip(), null, 
				this.getBorderRaised(), this.getBorderPressed(),
				this.getBackground(), this.getPressedBackground(), 
				this.getForeground(), this.getActiveForeground(), 
				this.getFocusBorder(),
				this.getButtonIconFile());
		
		rocheButton.setUI(new RocheButtonUI());
				
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
