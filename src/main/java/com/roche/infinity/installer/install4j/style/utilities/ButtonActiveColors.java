/**
 * 
 */
package com.roche.infinity.installer.install4j.style.utilities;

import java.awt.Color;

/**
 * @author grebonfe
 *
 */
public enum ButtonActiveColors {

	ACTIVE_DEFAULT_BUTTON_BACKGROUND_COLOR(Color.decode("#0066CC")),
	ACTIVE_DEFAULT_BUTTON_BORDER_COLOR(Color.decode("#0066CC")),
	ACTIVE_DEFAULT_BUTTON_FOREGROUND_COLOR(Color.decode("#FFFFFF")),
	ACTIVE_PRESSED_BUTTON_BACKGROUND_COLOR(Color.decode("#638EB9")),
	ACTIVE_PRESSED_BUTTON_BORDER_COLOR(Color.decode("#638EB9")),
	ACTIVE_PRESSED_BUTTON_FOREGROUND_COLOR(Color.decode("#FFFFFF")),
	ACTIVE_HOVER_BUTTON_BACKGROUND_COLOR(Color.decode("#0066CC")),
	ACTIVE_HOVER_BUTTON_BORDER_COLOR(Color.decode("#FFFFFF")),
	ACTIVE_HOVER_BUTTON_FOREGROUND_COLOR(Color.decode("#FFFFFF")),
	ACTIVE_DISABLE_BUTTON_BACKGROUND_COLOR(Color.decode("#D3D3D3")),
	ACTIVE_DISABLE_BUTTON_BORDER_COLOR(Color.decode("#D3D3D3")),
	ACTIVE_DISABLE_BUTTON_FOREGROUND_COLOR(Color.decode("#EFEFEF"));
		
	private Color color;
	 
	ButtonActiveColors(Color color) {
	    this.color = color;
	}
	 
	public Color getColor() {
	    return color;
	}
}
