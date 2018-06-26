package com.roche.infinity.installer.install4j.screen.component.button;

import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.roche.infinity.installer.install4j.component.button.ui.ActiveRocheButtonUI;
import com.roche.infinity.installer.install4j.component.button.ui.NormalRocheButtonUI;
import com.roche.infinity.installer.install4j.component.button.ui.RocheButtonUI;
import com.roche.infinity.installer.install4j.style.utilities.Utilities.StyleProperties.ButtonTypes;

/**
 * 
 * @author Jordi Campreciós
 * @date May 2018
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
	 * @param width
	 * @param height
	 * @param textLabel
	 * @param textToolTip
	 * @param buttonFont
	 * @param buttonImage
	 * @param hide
	 */
	public RocheButton(ButtonTypes type, Dimension d, String textLabel, String textToolTip, 
			Font buttonFont, File buttonImage, boolean hide, boolean disabled) {
		
		super(textLabel);
		
		if (buttonImage != null)
			this.setIcon(new ImageIcon(buttonImage.getAbsolutePath()));
		
		this.setToolTipText(textToolTip);
		this.setPreferredSize(d);
		this.setFont(buttonFont);
		this.setVisible(!hide);
		
		this.setType(type);		
		this.setEnabled(!disabled);
		
		switch (this.getType()) {
			case NORMAL:
				buttonUI = new NormalRocheButtonUI();	
				break;
			case ACTIVE:
				buttonUI = new ActiveRocheButtonUI();
				break;
		}
		
		setDefaultColors(buttonUI, disabled);
		setUI(buttonUI);
	}
	
	/**
	 * Sets the default button colors
	 * @param buttonUI
	 */
	public void setDefaultColors(RocheButtonUI buttonUI, boolean disabled) {
		if (disabled) {
			this.setBorder(buttonUI.getBorderDisable());
			this.setBackground(buttonUI.getBackgroundDisable());
			this.setForeground(buttonUI.getForegroundDisable());
			//disable events on button
			buttonUI.disableButton(this);
		}
		else {
			this.setBorder(buttonUI.getBorderDefault());
			this.setBackground(buttonUI.getBackgroundDefault());
			this.setForeground(buttonUI.getForegroundDefault());
		}
		this.repaint();
	}
}