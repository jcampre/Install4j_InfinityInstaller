package com.roche.infinity.install4j.components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JProgressBar;
import javax.swing.UIManager;

import com.roche.infinity.screen.component.ui.button.DefaultButtonUI;
import com.roche.infinity.screen.component.ui.button.RocheProgressBarUI;

public class RocheProgressBar extends JProgressBar {

	private static final long serialVersionUID = 1L;

	private static final int PROGRESSBAR_WIDTH = 300;
	private static final int PROGRESSBAR_HEIGHT = 34;

	private Color background;

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(PROGRESSBAR_WIDTH, PROGRESSBAR_HEIGHT);
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
	 * Set default values for a style button
	 */
	private void setDefaultButtonValues() {
		UIManager.put("ProgressBarUi", RocheProgressBarUI.class.getName());
		UIManager.put("ProgressBar.background", background);
		return;
	}
}
