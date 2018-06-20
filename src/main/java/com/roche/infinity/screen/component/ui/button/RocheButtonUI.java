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

import com.roche.infinity.install4j.utils.StyleUtils.StyleProperties;

/**
 * 
 * @author Jordi Campreciós i Jordi Arenas
 * @date May/juny 2018 Define the button actions and the style
 */
public class RocheButtonUI extends BasicButtonUI implements java.io.Serializable, MouseListener, KeyListener {

	private static final long serialVersionUID = 1L;

	private static final RocheButtonUI buttonUI = new RocheButtonUI();

	private transient Color backgroundDefault = StyleProperties.NORMAL_DEFAULT_BUTTON_BACKGROUND_COLOR;
	private transient Color backgroundPressed = StyleProperties.NORMAL_PRESSED_BUTTON_BACKGROUND_COLOR;
	private transient Color backgroundHover = StyleProperties.NORMAL_HOVER_BUTTON_BACKGROUND_COLOR;
	private transient Color backgroundDisable = StyleProperties.NORMAL_DISABLE_BUTTON_BACKGROUND_COLOR;
	private transient Color foregroundDefault = StyleProperties.NORMAL_DEFAULT_BUTTON_FOREGROUND_COLOR;
	private transient Color foregroundPressed = StyleProperties.NORMAL_PRESSED_BUTTON_FOREGROUND_COLOR;
	private transient Color foregroundHover = StyleProperties.NORMAL_HOVER_BUTTON_FOREGROUND_COLOR;
	private transient Color foregroundDisable = StyleProperties.NORMAL_DISABLE_BUTTON_FOREGROUND_COLOR;
	private transient Border borderDefault = new LineBorder(StyleProperties.NORMAL_DEFAULT_BUTTON_BORDER_COLOR);
	private transient Border borderPressed = new LineBorder(StyleProperties.NORMAL_PRESSED_BUTTON_BORDER_COLOR);
	private transient Border borderHover = new LineBorder(StyleProperties.NORMAL_HOVER_BUTTON_BORDER_COLOR);
	private transient Border borderDisable = new LineBorder(StyleProperties.NORMAL_DISABLE_BUTTON_BORDER_COLOR);

	/**
	 * @return the backgroundDefault
	 */
	public Color getBackgroundDefault() {
		return backgroundDefault;
	}

	/**
	 * @param backgroundDefault
	 *            the backgroundDefault to set
	 */
	public void setBackgroundDefault(Color backgroundDefault) {
		this.backgroundDefault = backgroundDefault;
	}

	/**
	 * @return the backgroundPressed
	 */
	public Color getBackgroundPressed() {
		return backgroundPressed;
	}

	/**
	 * @param backgroundPressed
	 *            the backgroundPressed to set
	 */
	public void setBackgroundPressed(Color backgroundPressed) {
		this.backgroundPressed = backgroundPressed;
	}

	/**
	 * @return the backgroundHover
	 */
	public Color getBackgroundHover() {
		return backgroundHover;
	}

	/**
	 * @param backgroundHover
	 *            the backgroundHover to set
	 */
	public void setBackgroundHover(Color backgroundHover) {
		this.backgroundHover = backgroundHover;
	}

	/**
	 * @return the backgroundDisable
	 */
	public Color getBackgroundDisable() {
		return backgroundDisable;
	}

	/**
	 * @param backgroundDisable
	 *            the backgroundDisable to set
	 */
	public void setBackgroundDisable(Color backgroundDisable) {
		this.backgroundDisable = backgroundDisable;
	}

	/**
	 * @return the foregroundDefault
	 */
	public Color getForegroundDefault() {
		return foregroundDefault;
	}

	/**
	 * @param foregroundDefault
	 *            the foregroundDefault to set
	 */
	public void setForegroundDefault(Color foregroundDefault) {
		this.foregroundDefault = foregroundDefault;
	}

	/**
	 * @return the foregroundPressed
	 */
	public Color getForegroundPressed() {
		return foregroundPressed;
	}

	/**
	 * @param foregroundPressed
	 *            the foregroundPressed to set
	 */
	public void setForegroundPressed(Color foregroundPressed) {
		this.foregroundPressed = foregroundPressed;
	}

	/**
	 * @return the foregroundHover
	 */
	public Color getForegroundHover() {
		return foregroundHover;
	}

	/**
	 * @param foregroundHover
	 *            the foregroundHover to set
	 */
	public void setForegroundHover(Color foregroundHover) {
		this.foregroundHover = foregroundHover;
	}

	/**
	 * @return the foregroundDisable
	 */
	public Color getForegroundDisable() {
		return foregroundDisable;
	}

	/**
	 * @param foregroundDisable
	 *            the foregroundDisable to set
	 */
	public void setForegroundDisable(Color foregroundDisable) {
		this.foregroundDisable = foregroundDisable;
	}

	/**
	 * @return the borderDefault
	 */
	public Border getBorderDefault() {
		return borderDefault;
	}

	/**
	 * @param borderDefault
	 *            the borderDefault to set
	 */
	public void setBorderDefault(Border borderDefault) {
		this.borderDefault = borderDefault;
	}

	/**
	 * @return the borderPressed
	 */
	public Border getBorderPressed() {
		return borderPressed;
	}

	/**
	 * @param borderPressed
	 *            the borderPressed to set
	 */
	public void setBorderPressed(Border borderPressed) {
		this.borderPressed = borderPressed;
	}

	/**
	 * @return the borderHover
	 */
	public Border getBorderHover() {
		return borderHover;
	}

	/**
	 * @param borderHover
	 *            the borderHover to set
	 */
	public void setBorderHover(Border borderHover) {
		this.borderHover = borderHover;
	}

	/**
	 * @return the borderDisable
	 */
	public Border getBorderDisable() {
		return borderDisable;
	}

	/**
	 * @param borderDisable
	 *            the borderDisable to set
	 */
	public void setBorderDisable(Border borderDisable) {
		this.borderDisable = borderDisable;
	}

	public static ComponentUI createUI(JComponent component) {
		return buttonUI;
	}

	/**
	 * 
	 * @param c
	 */
	public void disableButton(JComponent c) {
		c.removeMouseListener(this);
		c.removeKeyListener(this);
	}

	/**
	 * 
	 * @param c
	 */
	public void enableButton(JComponent c) {
		c.addMouseListener(this);
		c.addKeyListener(this);
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

		ImageIcon imageIcon = (ImageIcon) b.getIcon();
		int xIcon = 0;
		if (imageIcon != null) {
			g.drawImage(imageIcon.getImage(), 5, ((int) d.getHeight() / 2) - (imageIcon.getIconHeight() / 2), null);
			xIcon = imageIcon.getIconWidth() + 5;
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
		if (getBorderDefault() != null) {
			Insets ins = getBorderDefault().getBorderInsets(c);
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
		c.repaint();
	}

	/**
	 * Define the mouse released action
	 */
	public void mouseReleased(MouseEvent e) {
		JComponent c = (JComponent) e.getComponent();
		c.setBorder(borderHover);
		c.setBackground(backgroundHover);
		c.setForeground(foregroundHover);
		c.repaint();
	}

	/**
	 * Define the mouse entered action
	 */
	public void mouseEntered(MouseEvent e) {
		JComponent c = (JComponent) e.getComponent();
		c.setBorder(borderHover);
		c.setBackground(backgroundHover);
		c.setForeground(foregroundHover);
		c.repaint();
	}

	/**
	 * Define the mouse exited action
	 */
	public void mouseExited(MouseEvent e) {
		JComponent c = (JComponent) e.getComponent();
		c.setBorder(getBorderDefault());
		c.setBackground(getBackgroundDefault());
		c.setForeground(getForegroundDefault());
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
			c.setForeground(foregroundPressed);
		}
	}

	/**
	 * Define the key released action
	 */
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_ENTER || code == KeyEvent.VK_SPACE) {
			JComponent c = (JComponent) e.getComponent();
			c.setBorder(getBorderDefault());
			c.setBackground(getBackgroundDefault());
			c.setForeground(getForegroundDefault());
		}
	}
}