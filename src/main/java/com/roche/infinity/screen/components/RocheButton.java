package com.roche.infinity.screen.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.Border;


/**
 * @author jcamprec
 *
 */
public class RocheButton extends JButton{
	
	private static final long serialVersionUID = 1L;
	private Border m_borderRaised;
	private Border m_borderLowered;
	private Color m_backgroundNormal;
	private Color m_backgroundPressed;
	private Color m_foregroundNormal;
	private Color m_foregroundActive;
	private Color m_focusBorder;
	
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
	 
	public RocheButton(int width, int height, String textLabel)
	{
		super(textLabel);
		
		this.setSize(new Dimension(width, height));
		setDefaultButtonValues();
			
	}

	/**
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
			ImageIcon buttonImage)
	{
		
		super(textLabel, buttonImage);
		
		this.setToolTipText(textToolTip);
		this.setSize(new Dimension(width, height));
		this.setFont(buttonFont);	
		
		this.m_borderRaised=borderRaised;
		this.m_borderLowered=borderPressed;
		this.m_backgroundNormal=background;
		this.m_backgroundPressed=pressedBackground;
		this.m_foregroundNormal=foreground;
		this.m_foregroundActive=activeForeground;
		this.m_focusBorder=focusBorder;
		
		setDefaultButtonValues();
	}
	
	private void setDefaultButtonValues()
	{
		UIManager.put("Button.border", m_borderRaised);
		UIManager.put("Button.borderPressed", m_borderLowered);
		UIManager.put("Button.background", m_backgroundNormal);
		UIManager.put("Button.pressedBackground", m_backgroundPressed);
		UIManager.put("Button.foreground", m_foregroundNormal);
		UIManager.put("Button.activeForeground", m_foregroundActive);
		UIManager.put("Button.focusBorder", m_focusBorder);

	}
}
