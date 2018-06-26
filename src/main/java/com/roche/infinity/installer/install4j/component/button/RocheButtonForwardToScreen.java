package com.roche.infinity.installer.install4j.component.button;

import java.awt.Dimension;
import javax.swing.JComponent;

import com.roche.infinity.installer.install4j.actionlistener.ForwardToScreenButtonActionListener;
import com.roche.infinity.installer.install4j.screen.component.button.RocheButton;
import com.roche.infinity.installer.install4j.style.utilities.Utilities.StyleProperties.ButtonTypes;
import com.roche.infinity.installer.install4j.wrapper.button.RocheButtonWrapper;

/**
 * 
 * @author Jordi Campreciós
 * @date May 2018
 * Define the roche button cancel
 */
public class RocheButtonForwardToScreen extends RocheButtonWrapper {

	private String toScreen;
	/**
	 * Default constructor
	 */
	public RocheButtonForwardToScreen() {
		super();
	}
	
	/**
	 * @return the toScreen
	 */
	public String getToScreen() {
		return toScreen;
	}

	/**
	 * @param toScreen the toScreen to set
	 */
	public void setToScreen(String toScreen) {
		this.toScreen = toScreen;
	}
	
	/**
	 * Creates the button
	 */
	@Override
	public JComponent createCenterComponent() {
		
		Dimension d = new Dimension(this.getWidth(), this.getHeight());
		rocheButton = new RocheButton(ButtonTypes.ACTIVE, d, this.getTextLabel(), this.getTextToolTip(), this.getFont(), 
				this.getButtonIconFile(), this.isHide(), this.isDisable());
	
		rocheButton.addActionListener(new ForwardToScreenButtonActionListener(getContext(), this.toScreen)); 

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
