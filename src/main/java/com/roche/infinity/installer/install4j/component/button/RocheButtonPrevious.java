package com.roche.infinity.installer.install4j.component.button;

import java.awt.Dimension;
import javax.swing.JComponent;
import com.roche.infinity.installer.install4j.actionlistener.PreviousButtonActionListener;
import com.roche.infinity.installer.install4j.screen.component.button.RocheButton;
import com.roche.infinity.installer.install4j.style.utilities.Utilities.StyleProperties.ButtonTypes;
import com.roche.infinity.installer.install4j.wrapper.button.RocheButtonWrapper;

/**
 * 
 * @author Jordi Camprecios
 * Define the roche button cancel
 */
public class RocheButtonPrevious extends RocheButtonWrapper {	
	
	/**
	 * Default constructor
	 */
	public RocheButtonPrevious() {
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
		
		rocheButton.addActionListener(new PreviousButtonActionListener(getContext()));
		
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
	 * 
	 */
	@Override
    public void initialize() {
        super.initialize();
    }
	
	/**
	 * Create a variable to handle the button
	 * 
	 */
	@Override
	public void formWillActivate() {
		if (getContext() != null)
			getContext().setVariable("previous_button", this);
	}
}
