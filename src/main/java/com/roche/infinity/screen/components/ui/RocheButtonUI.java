package com.roche.infinity.screen.components.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 * 
 * @author Jordi Campreciós
 * @date May 2018
 * Define the button actions and the style
 */
public class RocheButtonUI extends BasicButtonUI implements java.io.Serializable, MouseListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private static final RocheButtonUI buttonUI = new RocheButtonUI();
	protected transient Border borderRaised = UIManager.getBorder("Button.border");
	protected transient Border borderLowered = UIManager.getBorder("Button.borderPressed");
	protected Color backgroundNormal = UIManager.getColor("Button.background");
	protected Color backgroundPressed = UIManager.getColor("Button.pressedBackground");
	protected Color foregroundNormal = UIManager.getColor("Button.foreground");
	protected Color foregroundActive = UIManager.getColor("Button.activeForeground");
	protected Color focusBorder = UIManager.getColor("Button.focusBorder");

	public static ComponentUI createUI(JComponent c) {
		return buttonUI;
	}

	/**
	 * 
	 */
	@Override
	public void installUI(JComponent c) {
		super.installUI(c);
		c.addMouseListener(this);
		c.addKeyListener(this);
	}

	/**
	 * 
	 */
	@Override
	public void uninstallUI(JComponent c) {
		super.uninstallUI(c);
		c.removeMouseListener(this);
		c.removeKeyListener(this);
	}

	/**
	 * 
	 */
	@Override
	public void paint(Graphics g, JComponent c) {
		AbstractButton b = (AbstractButton) c;
		Dimension d = b.getSize();

		g.setFont(c.getFont());
		FontMetrics fm = g.getFontMetrics();

		g.setColor(b.getForeground());
		String caption = b.getText();
		int x = (d.width - fm.stringWidth(caption)) / 2;
		int y = (d.height + fm.getAscent()) / 2;
		g.drawString(caption, x, y);
	}

	/**
	 * 
	 */
	@Override
	public Dimension getPreferredSize(JComponent c) {
		Dimension d = super.getPreferredSize(c);
		if (borderRaised != null) {
			Insets ins = borderRaised.getBorderInsets(c);
			d.setSize(d.width + ins.left + ins.right, d.height + ins.top + ins.bottom);
		}
		return d;
	}

	/**
	 * 
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	/**
	 * 
	 */
	public void mousePressed(MouseEvent e) {
		JComponent c = (JComponent) e.getComponent();
		c.setBorder(borderLowered);
		c.setBackground(backgroundPressed);
	}

	/**
	 * 
	 */
	public void mouseReleased(MouseEvent e) {
		JComponent c = (JComponent) e.getComponent();
		c.setBorder(borderRaised);
		c.setBackground(backgroundNormal);
	}

	/**
	 * 
	 */
	public void mouseEntered(MouseEvent e) {
		JComponent c = (JComponent) e.getComponent();
		c.setForeground(foregroundActive);
		c.repaint();
	}

	/**
	 * 
	 */
	public void mouseExited(MouseEvent e) {
		JComponent c = (JComponent) e.getComponent();
		c.setForeground(foregroundNormal);
		c.repaint();
	}

	/**
	 * 
	 */	
	public void keyTyped(KeyEvent e) {
	}

	/**
	 * 
	 */
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_ENTER || code == KeyEvent.VK_SPACE) {
			JComponent c = (JComponent) e.getComponent();
			c.setBorder(borderLowered);
			c.setBackground(backgroundPressed);
		}
	}

	/**
	 * 
	 */
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_ENTER || code == KeyEvent.VK_SPACE) {
			JComponent c = (JComponent) e.getComponent();
			c.setBorder(borderRaised);
			c.setBackground(backgroundNormal);
		}
	}
}