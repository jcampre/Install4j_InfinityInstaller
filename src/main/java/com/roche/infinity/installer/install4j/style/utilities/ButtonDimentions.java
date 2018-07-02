/**
 * 
 */
package com.roche.infinity.installer.install4j.style.utilities;
/**
 * @author grebonfe
 *
 */
public enum ButtonDimentions {

	BUTTON_WIDTH_SMALL_SIZE(88),
	BUTTON_HEIGHT_SMALL_SIZE(36),
	BUTTON_WIDTH_MEDIUM_SIZE(112),
	BUTTON_HEIGHT_MEDIUM_SIZE(36),
	BUTTON_WIDTH_LARGE_SIZE(160),
	BUTTON_HEIGHT_LARGE_SIZE(36);
	
	private int dimention;
	 
	ButtonDimentions(int dimention) {
	    this.dimention = dimention;
	}
	 
	public int getDimention() {
	    return dimention;
	}
}
