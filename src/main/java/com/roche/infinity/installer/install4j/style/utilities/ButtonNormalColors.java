package com.roche.infinity.installer.install4j.style.utilities;

import java.awt.Color;

/**
 * 
 * @author grebonfe
 *
 */
public enum ButtonNormalColors
{
	NORMAL_DEFAULT_BUTTON_BACKGROUND_COLOR(Color.decode("#FAFAFA")),
	NORMAL_DEFAULT_BUTTON_BORDER_COLOR(Color.decode("#BABABA")),
	NORMAL_DEFAULT_BUTTON_FOREGROUND_COLOR(Color.decode("#000000")),
	NORMAL_PRESSED_BUTTON_BACKGROUND_COLOR(Color.decode("#E8E8E8")),
	NORMAL_PRESSED_BUTTON_BORDER_COLOR(Color.decode("#A7A7A7")),
	NORMAL_PRESSED_BUTTON_FOREGROUND_COLOR(Color.decode("#000000")),
	NORMAL_HOVER_BUTTON_BACKGROUND_COLOR(Color.decode("#0066CC")),
	NORMAL_HOVER_BUTTON_BORDER_COLOR(Color.decode("#0066CC")),
	NORMAL_HOVER_BUTTON_FOREGROUND_COLOR(Color.decode("#FFFFFF")),
	NORMAL_DISABLE_BUTTON_BACKGROUND_COLOR(Color.decode("#FAFAFA")),
	NORMAL_DISABLE_BUTTON_BORDER_COLOR(Color.decode("#EFEFEF")),
	NORMAL_DISABLE_BUTTON_FOREGROUND_COLOR(Color.decode("#BABABA"));
	
	private Color color;
	 
	ButtonNormalColors(Color color) {
	    this.color = color;
	}
	 
	public Color getColor() {
	    return color;
	}
}