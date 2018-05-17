package com.roche.infinity.screen.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.Border;

/**
 * 
 * @author Jordi Campreciós
 * @date May 2018
 * Define the button properties
 */
public class RocheButton extends JButton {
	
	private static final long serialVersionUID = 1L;
	private transient Border borderRaised;
	private transient Border borderLowered;
	private Color backgroundNormal;
	private Color backgroundPressed;
	private Color foregroundNormal;
	private Color foregroundActive;
	private Color focusBorder;
	
	/**
	 * Default constructor
	 */
	public RocheButton() {
		super();		
		setDefaultButtonValues();
	}
	
	/**
	 * Overloaded constructor
	 * 
	 * @param text
	 */
	public RocheButton(String text) {
		super(text);		
		setDefaultButtonValues();
	}
	
	/**
	 * Overloaded constructor
	 * 
	 * @param text
	 * @param buttonImage
	 */
	public RocheButton(String text, ImageIcon buttonImage) {
		super(text, buttonImage);		
		setDefaultButtonValues();
	}
	
	/**
	 * Overloaded constructor
	 * 
	 * @param width
	 * @param height
	 * @param text
	 */	 
	public RocheButton(int width, int height, String textLabel) {
		super(textLabel);		
		this.setSize(new Dimension(width, height));
		setDefaultButtonValues();
			
	}

	/**
	 * Overloaded constructor
	 * 
	 * @param width
	 * @param height
	 * @param textLabel
	 * @param textToolTip
	 * @param buttonFont
	 * @param borderRaised
	 * @param borderPressed
	 * @param background
	 * @param pressedBackground
	 * @param foreground
	 * @param activeForeground
	 * @param focusBorder
	 * @param buttonImage
	 */
	public RocheButton(int width, int height, String textLabel, String textToolTip, 
			Font buttonFont, Border borderRaised, Border borderPressed, Color background, 
			Color pressedBackground, Color foreground, Color activeForeground, Color focusBorder,
			File buttonImage) {
		
		super(textLabel);
		if (buttonImage != null)
			this.setIcon(new ImageIcon(buttonImage.getAbsolutePath()));
		
		this.setToolTipText(textToolTip);
		this.setSize(new Dimension(width, height));
		this.setFont(buttonFont);			
		this.borderRaised=borderRaised;
		this.borderLowered=borderPressed;
		this.backgroundNormal=background;
		this.backgroundPressed=pressedBackground;
		this.foregroundNormal=foreground;
		this.foregroundActive=activeForeground;
		this.focusBorder=focusBorder;
		
		setDefaultButtonValues();
	}
	
	/**
	 * Set default values for a style button
	 */
	private void setDefaultButtonValues() {
		UIManager.put("Button.border", borderRaised);
		UIManager.put("Button.borderPressed", borderLowered);
		UIManager.put("Button.background", backgroundNormal);
		UIManager.put("Button.pressedBackground", backgroundPressed);
		UIManager.put("Button.foreground", foregroundNormal);
		UIManager.put("Button.activeForeground", foregroundActive);
		UIManager.put("Button.focusBorder", focusBorder);
	}
}
