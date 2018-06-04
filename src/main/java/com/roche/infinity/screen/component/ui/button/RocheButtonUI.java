package com.roche.infinity.screen.component.ui.button;

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
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicButtonUI;

import com.roche.infinity.install4j.utils.Utilidades.StyleProperties;

/**
 * 
 * @author Jordi Campreciós i Jordi Arenas
 * @date May/juny 2018
 * Define the button actions and the style
 */
public class RocheButtonUI extends BasicButtonUI implements java.io.Serializable, MouseListener, KeyListener {

	private static final long serialVersionUID = 1L;
	
	private static final RocheButtonUI buttonUI = new RocheButtonUI();
	
//	protected transient Border borderRaised = new LineBorder(StyleProperties.normalButtonBorderColor);
//	protected transient Border borderLowered = new LineBorder(StyleProperties.pressedButtonBorderColor);
	
	protected transient Color backgroundNormal = StyleProperties.NORMAL_BUTTON_BACKGROUND_COLOR;
	protected transient Color backgroundPressed = StyleProperties.PRESSED_BUTTON_BACKGROUND_COLOR;
	protected transient Color backgroundActive = StyleProperties.ACTIVE_BUTTON_BACKGROUND_COLOR;
	protected transient Color foregroundNormal = StyleProperties.NORMAL_BUTTON_FOREGROUND_COLOR;
	protected transient Color foregroundPressed = StyleProperties.PRESSED_BUTTON_FOREGROUND_COLOR;
	protected transient Color foregroundActive = StyleProperties.ACTIVE_BUTTON_FOREGROUND_COLOR;
	protected transient Border borderNormal = new LineBorder(StyleProperties.NORMAL_BUTTON_BORDER_COLOR);
	protected transient Border borderPressed = new LineBorder(StyleProperties.PRESSED_BUTTON_BORDER_COLOR);
	protected transient Border borderActive = new LineBorder(StyleProperties.ACTIVE_BUTTON_BORDER_COLOR);

	public static ComponentUI createUI(JComponent component) {
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
		int xIcon=0;
		if (imageIcon != null)
		{
			g.drawImage(imageIcon.getImage(), 5, ((int)d.getHeight()/2) - (imageIcon.getIconHeight()/2), null);
			xIcon = imageIcon.getIconWidth() + 5 ;
		}
		int x = xIcon + (d.width - fm.stringWidth(caption)) / 2;
		int y = (d.height + fm.getAscent()) / 2;
		g.drawString(caption, x, y);
	}

	/**
	 * Define the preferred size
	 */
	@Override
	public Dimension getPreferredSize(JComponent c) {
		Dimension d = super.getPreferredSize(c);
		if (borderNormal != null) {
			Insets ins = borderNormal.getBorderInsets(c);
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
		c.setBorder(borderPressed);
		c.setBackground(backgroundPressed);
		c.setForeground(foregroundPressed);
	}

	/**
	 * Define the mouse released action
	 */
	public void mouseReleased(MouseEvent e) {
		JComponent c = (JComponent) e.getComponent();
		c.setBorder(borderActive);
		c.setBackground(backgroundActive);
		c.setForeground(foregroundActive);
	}

	/**
	 * Define the mouse entered action
	 */
	public void mouseEntered(MouseEvent e) {
		JComponent c = (JComponent) e.getComponent();
		c.setBorder(borderActive);
		c.setBackground(backgroundActive);
		c.setForeground(foregroundActive);
		c.repaint();
	}

	/**
	 * Define the mouse exited action
	 */
	public void mouseExited(MouseEvent e) {
		JComponent c = (JComponent) e.getComponent();
		c.setBorder(borderNormal);
		c.setBackground(backgroundNormal);
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
			c.setBorder(borderPressed);
			c.setBackground(backgroundPressed);
			c.setForeground(Color.BLACK);
		}
	}

	/**
	 * Define the key released action
	 */
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_ENTER || code == KeyEvent.VK_SPACE) {
			JComponent c = (JComponent) e.getComponent();
			c.setBorder(borderNormal);
			c.setBackground(backgroundNormal);
//			c.setForeground(foregroundNormal);
		}
	}
}