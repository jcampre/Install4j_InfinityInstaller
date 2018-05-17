package com.roche.infinity.screen.component.ui;

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
import javax.swing.ImageIcon;
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
	 * Paint the button
	 */
	@Override
	public void paint(Graphics g, JComponent c) {
		AbstractButton b = (AbstractButton) c;
		Dimension d = b.getSize();

		g.setFont(c.getFont());
		FontMetrics fm = g.getFontMetrics();

		g.setColor(b.getForeground());
		String caption = b.getText();
		
		ImageIcon  imageIcon = (ImageIcon) b.getIcon();
		int x_icon=0;
		if (imageIcon != null)
		{
			g.drawImage(imageIcon.getImage(), 0, 0, null);
			x_icon = imageIcon.getIconWidth();
		}
		int x = x_icon + (d.width - fm.stringWidth(caption)) / 2;
		int y = (d.height + fm.getAscent()) / 2;
		g.drawString(caption, x, y);
	}

	/**
	 * Define the preferred size
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
	 * Define the mouse clicked action
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	/**
	 * Define the mouse pressed action
	 */
	public void mousePressed(MouseEvent e) {
		JComponent c = (JComponent) e.getComponent();
		c.setBorder(borderLowered);
		c.setBackground(backgroundPressed);
	}

	/**
	 * Define the mouse released action
	 */
	public void mouseReleased(MouseEvent e) {
		JComponent c = (JComponent) e.getComponent();
		c.setBorder(borderRaised);
		c.setBackground(backgroundNormal);
	}

	/**
	 * Define the mouse entered action
	 */
	public void mouseEntered(MouseEvent e) {
		JComponent c = (JComponent) e.getComponent();
		c.setForeground(foregroundActive);
		c.repaint();
	}

	/**
	 * Define the mouse exited action
	 */
	public void mouseExited(MouseEvent e) {
		JComponent c = (JComponent) e.getComponent();
		c.setForeground(foregroundNormal);
		c.repaint();
	}

	/**
	 * Define the key typed action
	 */	
	public void keyTyped(KeyEvent e) {
	}

	/**
	 * Define the key pressed action
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
	 * Define the key released action
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