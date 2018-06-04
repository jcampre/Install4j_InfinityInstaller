package com.roche.infinity.screen.component.button;

import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.roche.infinity.install4j.utils.Utilidades.StyleProperties;

/**
 * 
 * @author Jordi Campreciós
 * @date May 2018
 * Define the button properties
 */
public class RocheButton extends JButton {
	
	private static final long serialVersionUID = 1L;
	
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
	public RocheButton(int width, int height, String textLabel) {
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
	public RocheButton(int width, int height, String textLabel, String textToolTip, 
			Font buttonFont, File buttonImage, boolean hide) {
		
		super(textLabel);
		
//		Util.showMessage("amplada " + this.getWidth() + " y alçada " + height + " getTextLabel " + textLabel);
		
//		if (buttonImage != null)
//			this.setIcon(new ImageIcon(buttonImage.getAbsolutePath()));
		this.setIcon(null);
		
		this.setToolTipText(textToolTip);
		this.setPreferredSize(new Dimension(width, height));
		this.setFont(buttonFont);
		this.setVisible(!hide);
		this.setBackground(StyleProperties.NORMAL_BUTTON_BACKGROUND_COLOR);
		this.setForeground(StyleProperties.NORMAL_BUTTON_FOREGROUND_COLOR);

	}
}