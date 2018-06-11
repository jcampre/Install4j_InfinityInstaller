package com.roche.infinity.screen.component.ui.button;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
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
 * @date May/juny 2018 Define the button actions and the style
 */
public class NormalRocheButtonUI extends RocheButtonUI {

	private static final long serialVersionUID = 1L;
	
	private static final ActiveRocheButtonUI buttonUI = new ActiveRocheButtonUI();
	
	public NormalRocheButtonUI() {
		super();
		
		setBackgroundDefault(StyleProperties.NORMAL_DEFAULT_BUTTON_BACKGROUND_COLOR);
		setBackgroundPressed(StyleProperties.NORMAL_PRESSED_BUTTON_BACKGROUND_COLOR);
		setBackgroundHover(StyleProperties.NORMAL_HOVER_BUTTON_BACKGROUND_COLOR);
		setForegroundDefault(StyleProperties.NORMAL_DEFAULT_BUTTON_FOREGROUND_COLOR);
		setForegroundPressed(StyleProperties.NORMAL_PRESSED_BUTTON_FOREGROUND_COLOR);
		setForegroundHover(StyleProperties.NORMAL_HOVER_BUTTON_FOREGROUND_COLOR);
		setBorderDefault(new LineBorder(StyleProperties.NORMAL_DEFAULT_BUTTON_BORDER_COLOR));
		setBorderPressed(new LineBorder(StyleProperties.NORMAL_PRESSED_BUTTON_BORDER_COLOR));
		setBorderHover(new LineBorder(StyleProperties.NORMAL_HOVER_BUTTON_BORDER_COLOR));
	}
	
	public static ComponentUI createUI(JComponent component) {
		System.out.println("Component en NormalRocheButtonUI");
		
		component.updateUI();
		component.repaint();
		
		return buttonUI;
	}
}