package com.roche.infinity.screen.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;


/**
 * @author jcamprec
 *
 */
public class RocheButton extends JButton{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public RocheButton()
	{
		super();
		
		setDefaultButtonValues();
	}
	
	/**
	 * 
	 * @param text
	 */
	public RocheButton(String text)
	{
		super(text);
		
		setDefaultButtonValues();
	}
	
	/**
	 * 
	 * @param text
	 * @param buttonImage
	 */
	public RocheButton(String text, ImageIcon buttonImage)
	{
		super(text, buttonImage);
		
		setDefaultButtonValues();
	}
	
	/**
	 * 
	 * @param width
	 * @param height
	 * @param text
	 */
	 
	public RocheButton(int width, int height, String text)
	{
		super(text);
		
		this.setSize(new Dimension(width, height));
		setDefaultButtonValues();
			
	}

	/**
	 * 
	 * @param width
	 * @param height
	 * @param text
	 * @param buttonFont
	 * @param buttonColor
	 */
	public RocheButton(int width, int height, String text, Font buttonFont, Color buttonColor, ImageIcon buttonImage)
	{
		super(text, buttonImage);
		
		this.setSize(new Dimension(width, height));
		this.setFont(buttonFont);
		this.setBackground(buttonColor);
		setDefaultButtonValues();
	}
	
	private void setDefaultButtonValues()
	{
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setMargin(new Insets(0,0,0,0));
	}
}
