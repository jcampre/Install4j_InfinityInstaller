package com.roche.infinity.installer.install4j.screen.component.button;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.roche.infinity.installer.install4j.component.button.ui.ActiveRocheButtonUI;
import com.roche.infinity.installer.install4j.component.button.ui.NormalRocheButtonUI;
import com.roche.infinity.installer.install4j.component.button.ui.RocheButtonUI;
import com.roche.infinity.installer.install4j.style.utilities.Utilities.StyleProperties.ButtonTypes;

/**
 * 
 * @author Jordi Camprecios
 * Define the button properties
 */
public class RocheButton extends JButton {
	
	private ButtonTypes type; 
	private RocheButtonUI buttonUI;
	
	private static final long serialVersionUID = 1L;
		
	/**
	 * @return the type
	 */
	public ButtonTypes getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(ButtonTypes type) {
		this.type = type;
	}		

	/**
	 * Overloaded constructor
	 * 
	 * @param type -  the button type
	 * @param dimension - the button dimension
	 * @param textLabel - the text label
	 * @param textToolTip -  the text tool tip
	 * @param buttonFont - the button font
	 * @param buttonImage - the button image
	 * @param hide - is hide?
	 * @param disabled - is disabled?
	 */
	public RocheButton(ButtonTypes type, Dimension dimension, String textLabel, String textToolTip, 
			Font buttonFont, File buttonImage, boolean hide, boolean disabled) {
		
		super(textLabel);
		
		if (buttonImage != null)
			this.setIcon(new ImageIcon(buttonImage.getAbsolutePath()));

		this.setToolTipText(textToolTip);
		this.setPreferredSize(dimension);
		this.setFont(buttonFont);
		this.setVisible(!hide);

		this.setType(type);
		
		switch (this.getType()) {
		case NORMAL:
			buttonUI = new NormalRocheButtonUI();
			break;
		case ACTIVE:
			buttonUI = new ActiveRocheButtonUI();
			break;
		}

		setUI(buttonUI);

		this.setEnabled(!disabled);
	}
	
	/**
	 * Sets the default button colors
	 * @param buttonUI  - the RocheButtonUI
	 * @param disabled - is disabled?
	 */
	public void setDefaultColors(RocheButtonUI buttonUI, boolean disabled) {
		if (disabled) {
			this.setBorder(buttonUI.getBorderDisable());
			this.setBackground(buttonUI.getBackgroundDisable());
			this.setForeground(buttonUI.getForegroundDisable());
			
			// disable events on button
			buttonUI.disableButton(this);
		} else {
			this.setBorder(buttonUI.getBorderDefault());
			this.setBackground(buttonUI.getBackgroundDefault());
			this.setForeground(buttonUI.getForegroundDefault());
			// enable events on button
			buttonUI.enableButton(this);
		}
		this.repaint();
	}

	@Override
	public void setEnabled(boolean b) {
		setDefaultColors(buttonUI, !b);
	}
	
}