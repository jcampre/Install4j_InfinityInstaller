package com.roche.infinity.install4j.components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JProgressBar;
import javax.swing.UIManager;

import com.install4j.api.Util;
import com.roche.infinity.screen.component.ui.button.RocheProgressBarUI;

public class RocheProgressBar extends JProgressBar {

	private static final long serialVersionUID = 1L;
	private static final int progessBarWidth = 200;
	private static final int progessBarHeigh = 14;

	private int width = progessBarWidth;
	private int height = progessBarHeigh;
	private Color background;
	private int value;

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(this.width, this.height);
	}

	/**
	 * Default constructor
	 */
	public RocheProgressBar() {
		super();
		this.setPreferredSize(getPreferredSize());
		setDefaultButtonValues();
	}

	/**
	 * Overloaded constructor
	 * 
	 * @param width
	 * @param height
	 */
	public RocheProgressBar(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		setDefaultButtonValues();
	}

	/**
	 * Overloaded constructor
	 * 
	 * @param width
	 * @param height
	 * @param background
	 */
	public RocheProgressBar(int width, int height, Color background) {
		super();
		this.width = width;
		this.height = height;

		this.background = background;

		setDefaultButtonValues();
	}

	/**
	 * Overloaded constructor
	 * 
	 * @param width
	 * @param height
	 * @param background
	 */
	public RocheProgressBar(int width, int height, Color background, int value) {
		super();
		this.width = width;
		this.height = height;

		Util.showMessage(
				"amplada " + width + " y alçada " + height + " background " + background + " y value " + value);
		this.background = background;
		setValue(value);

		setDefaultButtonValues();
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Set default values for a style button
	 */
	private void setDefaultButtonValues() {
		this.setUI(new RocheProgressBarUI());
		UIManager.put("ProgressBarUi", RocheProgressBarUI.class.getName());
		UIManager.put("ProgressBar.background", background);

		return;
	}
}
