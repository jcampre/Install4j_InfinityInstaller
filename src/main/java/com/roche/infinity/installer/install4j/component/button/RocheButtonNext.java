package com.roche.infinity.installer.install4j.component.button;

import java.awt.Dimension;
import javax.swing.JComponent;
import com.roche.infinity.installer.install4j.actionlistener.NextButtonActionListener;
import com.roche.infinity.installer.install4j.screen.component.button.RocheButton;
import com.roche.infinity.installer.install4j.style.utilities.Utilities.StyleProperties.ButtonTypes;
import com.roche.infinity.installer.install4j.wrapper.button.RocheButtonWrapper;

/**
 * 
 * @author Jordi Camprecios
 * Define the roche button cancel
 */
public class RocheButtonNext extends RocheButtonWrapper {	
	
	/**
	 * Default constructor
	 */
	public RocheButtonNext() {
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
	
		rocheButton.addActionListener(new NextButtonActionListener(getContext())); 

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
			getContext().setVariable("next_button", this);
	}
}
