/**
 * 
 */
package com.roche.infinity.installer.install4j.style.utilities;

import java.awt.Font;

/**
 * @author grebonfe
 *
 */
public enum ButtonFonts {

	BUTTON_FONT(new Font("Roboto Medium", Font.PLAIN, 14));
	
	private Font font;
	 
	ButtonFonts(Font font) {
	    this.font = font;
	}
	 
	public Font getFont() {
	    return font;
	}
}
