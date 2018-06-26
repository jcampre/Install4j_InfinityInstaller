/**
 * 
 */
package com.roche.infinity.installer.install4j.style.utilities;

import java.awt.Font;

/**
 * @author grebonfe
 *
 */
public enum ParagraphFonts {

	PARAGRAPH_FONT(new Font("Roboto", Font.PLAIN, 14));

	private Font font;
	 
	ParagraphFonts(Font font) {
	    this.font = font;
	}
	 
	public Font getFont() {
	    return font;
	}	
}
