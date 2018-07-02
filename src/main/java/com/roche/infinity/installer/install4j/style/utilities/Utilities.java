package com.roche.infinity.installer.install4j.style.utilities;

import java.awt.Dimension;
import java.util.Hashtable;

/**
 * Defines properties for style 
 * @author Jordi Arenas
 *
 */
public class Utilities {

	/**
	 * Default constructor
	 */
	private Utilities() {

	}

	/**
	 * Inner class
	 * @author jcamprec
	 *
	 */
	public static class StyleProperties {	
	
		public static Hashtable<String, Dimension> buttonSizesList = new Hashtable<>();
	
		public static int PROGRESSBAR_WIDTH = 220;
		public static int PROGRESSBAR_HEIGHT = 36;
		
		/**
		 * enum for Button Type
		 * @author jcamprec
		 *
		 */
		public static enum ButtonTypes {
			NORMAL("Normal"), ACTIVE("Active");

			private String name;

			private ButtonTypes(String s) {
				this.name = s;
			}

			public boolean equalsName(String otherName) {

				return name.equals(otherName);
			}

			@Override
			public String toString() {
				return this.name;
			}
		};
		
		/**
		 * Define enum for Button size
		 * @author jcamprec
		 *
		 */
		public static enum ButtonSizes {
			SMALL("Small"), MEDIUM("Medium"), LARGE("Large");

			private String name;

			/**
			 * 
			 * @param s -  the size of the button
			 */
			private ButtonSizes(String s) {
				this.name = s;
			}

			/**
			 * 
			 * @param otherName - other name
			 * @return -  the result of the operation
			 */
			public boolean equalsName(String otherName) {
				return name.equals(otherName);
			}

			/**
			 * 
			 */
			@Override
			public String toString() {
				return this.name;
			}
		};

		/**
		 * Default constructor
		 */
		private StyleProperties() {

		}
		
		/**
		 * 
		 */
		public static void setDefaultButtonSizes() {
			// add elements in the hashtable
			buttonSizesList.put(ButtonSizes.SMALL.name.toUpperCase(),
					new Dimension(ButtonDimentions.BUTTON_WIDTH_SMALL_SIZE.getDimention(), ButtonDimentions.BUTTON_HEIGHT_SMALL_SIZE.getDimention()));
			buttonSizesList.put(ButtonSizes.MEDIUM.name.toUpperCase(),
					new Dimension(ButtonDimentions.BUTTON_WIDTH_MEDIUM_SIZE.getDimention(), ButtonDimentions.BUTTON_HEIGHT_SMALL_SIZE.getDimention()));
			buttonSizesList.put(ButtonSizes.LARGE.name.toUpperCase(),
					new Dimension(ButtonDimentions.BUTTON_WIDTH_LARGE_SIZE.getDimention(), ButtonDimentions.BUTTON_HEIGHT_SMALL_SIZE.getDimention()));
		}
	}
}
