package com.roche.infinity.installer.install4j.component.button;

import java.awt.Dimension;
import javax.swing.JComponent;

import com.roche.infinity.installer.install4j.actionlistener.ForwardToScreenButtonActionListener;
import com.roche.infinity.installer.install4j.screen.component.button.RocheButton;
import com.roche.infinity.installer.install4j.style.utilities.Utilities.StyleProperties.ButtonTypes;
import com.roche.infinity.installer.install4j.wrapper.button.RocheButtonWrapper;

/**
 * 
 * @author Jordi Camprecios
 * Define the roche button finish
 */
public class RocheButtonSkip extends RocheButtonWrapper {
		
	private String toScreen;
	
	/**
	 * Default constructor
	 */
	public RocheButtonSkip() {
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
		rocheButton = new RocheButton(ButtonTypes.NORMAL, d, this.getTextLabel(), this.getTextToolTip(), this.getFont(), 
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
	
	/**
	 * Create a variable to handle the button
	 * 
	 */
	@Override
	public void formWillActivate() {
		if (getContext() != null)
			getContext().setVariable("skip_button", this);
	}
}
