package com.roche.infinity.screen.component.ui.button;

import java.awt.Color;

import java.awt.Dimension;

import java.awt.GradientPaint;

import java.awt.Graphics;

import java.awt.Graphics2D;

import java.awt.Insets;

import java.awt.Point;

import java.awt.RadialGradientPaint;

import javax.swing.AbstractButton;

import javax.swing.BorderFactory;

import javax.swing.JComponent;
import javax.swing.border.Border;

import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicButtonUI;

import com.roche.infinity.install4j.components.RoundedBorder;

/**
 * 
 * UI for default button.
 * 
 * Can be used with:
 * 
 * UIManager.put("ButtonUI", DefaultButtonUI.class.getName());
 * 
 * Or:
 * 
 * myButton.setUI(new DefaultButtonUI());
 * 
 */

public class DefaultButtonUI extends BasicButtonUI {

	public static final int BUTTON_WIDTH = 80;
	public static final int BUTTON_HEIGHT = 24;

	private static final DefaultButtonUI INSTANCE = new DefaultButtonUI();
	private static final int MARGIN_VALUE = 30;
	private static final Insets BUTTON_MARGIN = new Insets(MARGIN_VALUE, 0, MARGIN_VALUE, 0);
	private static final Border BUTTON_BORDER = BorderFactory.createLineBorder(Color.GRAY);

	public static ComponentUI createUI(JComponent b) {
		return INSTANCE;
	}

	@Override
	public void paint(Graphics g, JComponent c) {
		AbstractButton button = (AbstractButton) c;

		Graphics2D g2d = (Graphics2D) g;

		if (button.isOpaque()) {
			button.setRolloverEnabled(true);
			button.setMargin(BUTTON_MARGIN);
			button.setForeground(Color.white);
			// button.setBorder(BUTTON_BORDER);
			button.setBorder(new RoundedBorder(50));

			final int buttonWidth = button.getWidth();
			if (button.getModel().isRollover()) {
				// Rollover
				RadialGradientPaint gp = new RadialGradientPaint(new Point(buttonWidth / 2, BUTTON_HEIGHT / 2),
						buttonWidth, new float[] { 0.2f, 0.8f }, new Color[] { Color.BLUE, Color.DARK_GRAY });
				g2d.setPaint(gp);
			} else if (button.isEnabled()) {
				// Enabled
				GradientPaint gp = new GradientPaint(0, 0, Color.GRAY, 0, BUTTON_HEIGHT * 0.6f, Color.DARK_GRAY, true);
				g2d.setPaint(gp);
			} else {
				// Disabled
				GradientPaint gp = new GradientPaint(0, 0, Color.LIGHT_GRAY, 0, BUTTON_HEIGHT * 0.6f, Color.GRAY, true);
				g2d.setPaint(gp);
			}
			g2d.fillRect(0, 0, buttonWidth, BUTTON_HEIGHT);
		}
		super.paint(g, button);
	}

	@Override
	public Dimension getPreferredSize(JComponent c) {
		AbstractButton button = (AbstractButton) c;
		int width = Math.max(button.getWidth(), BUTTON_WIDTH);
		int height = Math.max(button.getHeight(), BUTTON_HEIGHT);
		return new Dimension(width, height);
	}

}