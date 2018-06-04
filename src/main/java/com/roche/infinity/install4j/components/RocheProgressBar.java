package com.roche.infinity.install4j.components;

import java.awt.Color;
import java.awt.Dimension;
import java.beans.Visibility;

import javax.swing.JProgressBar;
import javax.swing.UIManager;

import com.install4j.api.Util;
import com.roche.infinity.install4j.utils.Utilidades.StyleProperties;
import com.roche.infinity.screen.component.ui.button.RocheProgressBarUI;

public class RocheProgressBar extends JProgressBar {

	private static final long serialVersionUID = 1L;
	
	private int width = StyleProperties.PROGRESSBAR_WIDTH;
	private int height = StyleProperties.PROGRESSBAR_HEIGHT;
	
	private Color background;
	private int value;
	private boolean hideInitially;
	
	private RocheProgressBarUI rocheProgressBarUI = new RocheProgressBarUI();

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * @return the hideInitially
	 */
	public boolean isHideInitially() {
		return hideInitially;
	}
	
	public void setHideInitially(boolean hideInitially) {
		this.hideInitially = hideInitially;
		setVisible(hideInitially);
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

//		Util.showMessage(
//				"amplada " + width + " y alçada " + height + " background " + background + " y value " + value);
		
		setBackground(background);
		setValue(value);

		setDefaultButtonValues();
	}

	/**
	 * Set default values for a style button
	 */
	private void setDefaultButtonValues() {
		this.setUI(rocheProgressBarUI);
		return;
	}

}
