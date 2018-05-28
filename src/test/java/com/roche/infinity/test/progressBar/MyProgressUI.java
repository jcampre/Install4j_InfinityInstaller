package com.roche.infinity.test.progressBar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicProgressBarUI;

public class MyProgressUI extends BasicProgressBarUI {
	Rectangle r = new Rectangle(300, 10);

	@Override
	protected void paintIndeterminate(Graphics g, JComponent c) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		r = getBox(r);
		g.setColor(Color.green);
		g.fillOval(r.x, r.y, r.width, r.height);
	}
}