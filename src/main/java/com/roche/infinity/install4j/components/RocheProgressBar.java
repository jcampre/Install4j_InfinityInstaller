package com.roche.infinity.install4j.components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JProgressBar;
import javax.swing.UIManager;

import com.install4j.api.Util;
import com.roche.infinity.screen.component.ui.button.RocheProgressBarUI;

public class RocheProgressBar extends JProgressBar {

	private static final long serialVersionUID = 1L;

	
	private Color background;
	private int value;

//	@Override
//	public Dimension getPreferredSize() {
//		return new Dimension(PROGRESSBAR_WIDTH, PROGRESSBAR_HEIGHT);
//	}

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
		this.setPreferredSize(new Dimension(width, height));
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
		this.setPreferredSize(new Dimension(width, height));

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
//		Util.showMessage("amplada " + width + " y alçada " + height + " background " + background + " y value " + value );
		this.setPreferredSize(new Dimension(width, height));
		this.background = background;
		setValue(value);
				
		setDefaultButtonValues();
	}

	/**
	 * Set default values for a style button
	 */
	private void setDefaultButtonValues() {
		UIManager.put("ProgressBarUi", RocheProgressBarUI.class.getName());
		UIManager.put("ProgressBar.background", background);

		return;
	}
}
