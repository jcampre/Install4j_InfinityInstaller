package com.roche.infinity.install4j.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.install4j.api.Util;
import com.roche.infinity.install4j.utils.StyleUtils.StyleProperties;

public class StyleUtils {

	private StyleUtils() {

	}

	public static class FrameUtils {

		public JFrame quitTitleFrame(JFrame frame) {
			Util.showMessage("prova");
			frame.setTitle("NoTitle");
			frame.setSize(720, 540);
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			frame.setUndecorated(true);
			frame.setResizable(false);
			frame.setVisible(true); // move setVisible to the end

			return frame;
		}

		public static void showAlert() {
			Util.showMessage("prova");
		}
	}

	public static class StyleProperties {
		// Buttons normal colors
		public static final Color NORMAL_DEFAULT_BUTTON_BACKGROUND_COLOR = Color.decode("#FAFAFA");
		public static final Color NORMAL_DEFAULT_BUTTON_BORDER_COLOR = Color.decode("#BABABA");
		public static final Color NORMAL_DEFAULT_BUTTON_FOREGROUND_COLOR = Color.decode("#000000");
		public static final Color NORMAL_PRESSED_BUTTON_BACKGROUND_COLOR = Color.decode("#E8E8E8");
		public static final Color NORMAL_PRESSED_BUTTON_BORDER_COLOR = Color.decode("#A7A7A7");
		public static final Color NORMAL_PRESSED_BUTTON_FOREGROUND_COLOR = Color.decode("#000000");
		public static final Color NORMAL_HOVER_BUTTON_BACKGROUND_COLOR = Color.decode("#0066CC");
		public static final Color NORMAL_HOVER_BUTTON_BORDER_COLOR = Color.decode("#0066CC");
		public static final Color NORMAL_HOVER_BUTTON_FOREGROUND_COLOR = Color.decode("#FFFFFF");
		public static final Color NORMAL_DISABLE_BUTTON_BACKGROUND_COLOR = Color.decode("#FAFAFA");
		public static final Color NORMAL_DISABLE_BUTTON_BORDER_COLOR = Color.decode("#EFEFEF");
		public static final Color NORMAL_DISABLE_BUTTON_FOREGROUND_COLOR = Color.decode("#BABABA");
		
		// Buttons Active colors
		public static final Color ACTIVE_DEFAULT_BUTTON_BACKGROUND_COLOR = Color.decode("#0066CC");
		public static final Color ACTIVE_DEFAULT_BUTTON_BORDER_COLOR = Color.decode("#0066CC");
		public static final Color ACTIVE_DEFAULT_BUTTON_FOREGROUND_COLOR = Color.decode("#FFFFFF");
		public static final Color ACTIVE_PRESSED_BUTTON_BACKGROUND_COLOR = Color.decode("#638EB9");
		public static final Color ACTIVE_PRESSED_BUTTON_BORDER_COLOR = Color.decode("#638EB9");
		public static final Color ACTIVE_PRESSED_BUTTON_FOREGROUND_COLOR = Color.decode("#FFFFFF");
		public static final Color ACTIVE_HOVER_BUTTON_BACKGROUND_COLOR = Color.decode("#0066CC");
		public static final Color ACTIVE_HOVER_BUTTON_BORDER_COLOR = Color.decode("#FFFFFF");
		public static final Color ACTIVE_HOVER_BUTTON_FOREGROUND_COLOR = Color.decode("#FFFFFF");
		public static final Color ACTIVE_DISABLE_BUTTON_BACKGROUND_COLOR = Color.decode("#D3D3D3");
		public static final Color ACTIVE_DISABLE_BUTTON_BORDER_COLOR = Color.decode("#D3D3D3");
		public static final Color ACTIVE_DISABLE_BUTTON_FOREGROUND_COLOR = Color.decode("#EFEFEF");
		

		public static final Font BUTTON_FONT = new Font("Roboto Medium", Font.PLAIN, 34);
		public static final Font PARAGRAPH_FONT = new Font("Roboto", Font.PLAIN, 14);

		public static final int BUTTON_WIDTH_SMALL_SIZE = 88;
		public static final int BUTTON_HEIGHT_SMALL_SIZE = 36;
		public static final int BUTTON_WIDTH_MEDIUM_SIZE = 112;
		public static final int BUTTON_HEIGHT_MEDIUM_SIZE = 36;
		public static final int BUTTON_WIDTH_LARGE_SIZE = 160;
		public static final int BUTTON_HEIGHT_LARGE_SIZE = 36;

		public static Hashtable<String, Dimension> buttonSizesList = new Hashtable<>();

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
		
		public enum ButtonSizes {
			SMALL("Small"), MEDIUM("Medium"), LARGE("Large");

			private String name;

			private ButtonSizes(String s) {
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

		// Progress Bar colors
		public static final Color PROGRESSBAR_OUTLINE_COLOR = Color.decode("#A7A7A7");
		public static final Color PROGRESSBAR_COLOR = Color.decode("#0066CC");
		public static final int PROGRESSBAR_WIDTH = 200;
		public static final int PROGRESSBAR_HEIGHT = 141;

		private StyleProperties() {

		}

		public static void setDefaultButtonSizes() {
			// add elements in the hashtable
			buttonSizesList.put(ButtonSizes.SMALL.name.toUpperCase(),
					new Dimension(BUTTON_WIDTH_SMALL_SIZE, BUTTON_HEIGHT_SMALL_SIZE));
			buttonSizesList.put(ButtonSizes.MEDIUM.name.toUpperCase(),
					new Dimension(BUTTON_WIDTH_MEDIUM_SIZE, BUTTON_HEIGHT_SMALL_SIZE));
			buttonSizesList.put(ButtonSizes.LARGE.name.toUpperCase(),
					new Dimension(BUTTON_WIDTH_LARGE_SIZE, BUTTON_HEIGHT_SMALL_SIZE));
		}
	}
}
