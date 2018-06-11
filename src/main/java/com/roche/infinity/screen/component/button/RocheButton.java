package com.roche.infinity.screen.component.button;

import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.roche.infinity.install4j.utils.Utilidades.StyleProperties.ButtonTypes;
import com.roche.infinity.screen.component.ui.button.ActiveRocheButtonUI;
import com.roche.infinity.screen.component.ui.button.NormalRocheButtonUI;
import com.roche.infinity.screen.component.ui.button.RocheButtonUI;

/**
 * 
 * @author Jordi Campreciós
 * @date May 2018
 * Define the button properties
 */
public class RocheButton extends JButton {
	
	private static final long serialVersionUID = 1L;
	
	private RocheButtonUI buttonUI;
	
	/**
	 * @return the buttonUI
	 */
	public RocheButtonUI getButtonUI() {
		return buttonUI;
	}

	/**
	 * @param buttonUI the buttonUI to set
	 */
	public void setButtonUI(RocheButtonUI buttonUI) {
		this.buttonUI = buttonUI;
	}

	private ButtonTypes type; 
	private Boolean disable; 
	
	/**
	 * @return the disable
	 */
	public Boolean getDisable() {
		return disable;
	}

	/**
	 * @param disable the disable to set
	 */
	public void setDisable(Boolean disable) {
		this.disable = disable;
		
		this.getButtonUI().setDisable(this, disable);
	}

	public ButtonTypes getType() {
		return type;
	}

	public void setType(ButtonTypes type) {
		this.type = type;
	}
	
	/**
	 * Default constructor
	 */
	public RocheButton() {
		super();
	}
	
	/**
	 * Overloaded constructor
	 * 
	 * @param text
	 */
	public RocheButton(String text) {
		super(text);
	}

	/**
	 * Overloaded constructor
	 * 
	 * @param text
	 * @param buttonImage
	 */
	public RocheButton(String text, ImageIcon buttonImage) {
		super(text, buttonImage);		
	}
	
	/**
	 * Overloaded constructor
	 * 
	 * @param width
	 * @param height
	 * @param text
	 */	 
	public RocheButton(ButtonTypes type, int width, int height, String textLabel) {
		super(textLabel);		
		this.setPreferredSize(new Dimension(width, height));			
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
	 * @param bgcolor
	 * @param fgcolor
	 * @param font
	 */
	public RocheButton(ButtonTypes type, int width, int height, String textLabel, String textToolTip, 
			Font buttonFont, File buttonImage, boolean hide, boolean disable) {
		
		super(textLabel);
		
//		Util.showMessage("amplada " + this.getWidth() + " y alçada " + height + " getTextLabel " + textLabel);
		
//		if (buttonImage != null)
//			this.setIcon(new ImageIcon(buttonImage.getAbsolutePath()));
		
		this.setIcon(null);
		
		this.setToolTipText(textToolTip);
		this.setPreferredSize(new Dimension(width, height));
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
		SetDefaultColors(buttonUI);
		this.setDisable(disable);
		
		
//		this.setBackground(StyleProperties.NORMAL_DEFAULT_BUTTON_BACKGROUND_COLOR);
//		this.setForeground(StyleProperties.NORMAL_DEFAULT_BUTTON_FOREGROUND_COLOR);

	}
	

	public void SetDefaultColors(RocheButtonUI buttonUI) {
		this.setBorder(buttonUI.getBorderDefault());
		this.setBackground(buttonUI.getBackgroundDefault());
		this.setForeground(buttonUI.getForegroundDefault());
		this.repaint();
	}
}