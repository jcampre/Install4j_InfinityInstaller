package com.roche.infinity.test.Buttons;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicButtonUI;

import com.roche.infinity.installer.install4j.component.button.ui.RocheButtonUI;
import com.roche.infinity.installer.install4j.style.utilities.ButtonFonts;
import com.roche.infinity.installer.install4j.style.utilities.ButtonNormalColors;


public class SimpleButtonUI extends BasicButtonUI implements java.io.Serializable, MouseListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static RocheButtonUI m_buttonUI = new RocheButtonUI();

	protected Border m_borderRaised = UIManager.getBorder("Button.border");

	protected Border m_borderLowered = UIManager.getBorder("Button.borderPressed");

	protected Color m_backgroundNormal = UIManager.getColor("Button.background");

	protected Color m_backgroundPressed = UIManager.getColor("Button.pressedBackground");

	protected Color m_foregroundNormal = UIManager.getColor("Button.foreground");

	protected Color m_foregroundActive = UIManager.getColor("Button.activeForeground");

	protected Color m_focusBorder = UIManager.getColor("Button.focusBorder");

	public static ComponentUI createUI(JComponent c) {
		return m_buttonUI;
	}

	public void installUI(JComponent c) {
		super.installUI(c);

		c.addMouseListener(this);
//		c.addKeyListener(this);
	}

	public void uninstallUI(JComponent c) {
		super.uninstallUI(c);
		c.removeMouseListener(this);
//		c.removeKeyListener(this);
	}

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

	public Dimension getPreferredSize(JComponent c) {
		Dimension d = super.getPreferredSize(c);
		if (m_borderRaised != null) {
			Insets ins = m_borderRaised.getBorderInsets(c);
			d.setSize(d.width + ins.left + ins.right, d.height + ins.top + ins.bottom);
		}
		return d;
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		JComponent c = (JComponent) e.getComponent();
		c.setBorder(new LineBorder(ButtonNormalColors.NORMAL_PRESSED_BUTTON_BORDER_COLOR.getColor(), 3, true));
		c.setForeground(ButtonNormalColors.NORMAL_PRESSED_BUTTON_FOREGROUND_COLOR.getColor());
		c.setBackground(ButtonNormalColors.NORMAL_PRESSED_BUTTON_BACKGROUND_COLOR.getColor());
	}

	public void mouseReleased(MouseEvent e) {
		JComponent c = (JComponent) e.getComponent();
		// c.setBorder(m_borderRaised);
		c.setBorder(new LineBorder(ButtonNormalColors.NORMAL_DEFAULT_BUTTON_BORDER_COLOR.getColor(), 3, true));
		c.setForeground(ButtonNormalColors.NORMAL_DEFAULT_BUTTON_FOREGROUND_COLOR.getColor());
		c.setBackground(ButtonNormalColors.NORMAL_DEFAULT_BUTTON_BACKGROUND_COLOR.getColor());
	}

	public void mouseEntered(MouseEvent e) {
		JComponent c = (JComponent) e.getComponent();
		c.setBorder(new LineBorder(ButtonNormalColors.NORMAL_HOVER_BUTTON_BORDER_COLOR.getColor(), 3, true));
		c.setForeground(ButtonNormalColors.NORMAL_HOVER_BUTTON_FOREGROUND_COLOR.getColor());
		c.setBackground(ButtonNormalColors.NORMAL_HOVER_BUTTON_BACKGROUND_COLOR.getColor());
		c.repaint();
	}

	public void mouseExited(MouseEvent e) {
		JComponent c = (JComponent) e.getComponent();
		c.setBorder(new LineBorder(ButtonNormalColors.NORMAL_DEFAULT_BUTTON_BORDER_COLOR.getColor(), 3, true));
		c.setForeground(ButtonNormalColors.NORMAL_DEFAULT_BUTTON_FOREGROUND_COLOR.getColor());
		c.setBackground(ButtonNormalColors.NORMAL_DEFAULT_BUTTON_BACKGROUND_COLOR.getColor());
		c.repaint();
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_ENTER || code == KeyEvent.VK_SPACE) {
			JComponent c = (JComponent) e.getComponent();
			c.setBorder(m_borderLowered);
			c.setBackground(m_backgroundPressed);
		}
	}

	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_ENTER || code == KeyEvent.VK_SPACE) {
			JComponent c = (JComponent) e.getComponent();
			c.setBorder(m_borderRaised);
			c.setBackground(m_backgroundNormal);
		}
	}

	public static void main(String argv[]) {
		JFrame f = new JFrame();
		f.setSize(1100, 500);
		f.getContentPane().setLayout(new FlowLayout());

		JPanel p = new JPanel();
		p.setBorder(BorderFactory.createEmptyBorder(1,30,1,1));


		p.setPreferredSize(new Dimension(1100, 500));
		JButton bt1 = new JButton("Click Me");
		bt1.setPreferredSize(new Dimension(200, 54));
		bt1.setUI(m_buttonUI);
		bt1.setFont(ButtonFonts.BUTTON_FONT.getFont());

		p.add(bt1);
		f.getContentPane().add(p);
		WindowListener wndCloser = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		f.addWindowListener(wndCloser);
		f.setVisible(true);
	}
}