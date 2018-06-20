package com.roche.infinity.install4j.component.button;

import java.awt.Dimension;
import javax.swing.JComponent;

import com.roche.infinity.actionlistener.CancelButtonActionListener;
import com.roche.infinity.actionlistener.PreviousButtonActionListener;
import com.roche.infinity.install4j.utils.StyleUtils.StyleProperties.ButtonTypes;
import com.roche.infinity.install4j.wrapper.button.RocheButtonWrapper;
import com.roche.infinity.screen.component.button.RocheButton;
import com.roche.infinity.screen.component.ui.button.RocheButtonUI;


/**
 * 
 * @author Jordi Campreciós
 * @date May 2018
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
}
