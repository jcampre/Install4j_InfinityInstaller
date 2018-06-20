package com.roche.infinity.screen.component.ui.button;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.KeyEvent;
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
public class ActiveRocheButtonUI extends RocheButtonUI {

	private static final long serialVersionUID = 1L;

	private static final NormalRocheButtonUI buttonUI = new NormalRocheButtonUI();
	
	public ActiveRocheButtonUI() {
		super();
		
		setBackgroundDefault(StyleProperties.ACTIVE_DEFAULT_BUTTON_BACKGROUND_COLOR);
		setBackgroundPressed(StyleProperties.ACTIVE_PRESSED_BUTTON_BACKGROUND_COLOR);
		setBackgroundHover(StyleProperties.ACTIVE_HOVER_BUTTON_BACKGROUND_COLOR);
		setForegroundDefault(StyleProperties.ACTIVE_DEFAULT_BUTTON_FOREGROUND_COLOR);
		setForegroundPressed(StyleProperties.ACTIVE_PRESSED_BUTTON_FOREGROUND_COLOR);
		setForegroundHover(StyleProperties.ACTIVE_HOVER_BUTTON_FOREGROUND_COLOR);
		setBorderDefault(new LineBorder(StyleProperties.ACTIVE_DEFAULT_BUTTON_BORDER_COLOR));
		setBorderPressed(new LineBorder(StyleProperties.ACTIVE_PRESSED_BUTTON_BORDER_COLOR));
		setBorderHover(new LineBorder(StyleProperties.ACTIVE_HOVER_BUTTON_BORDER_COLOR));
	}
	
	public static ComponentUI createUI(JComponent component) {
		System.out.println("Component en ActiveRocheButtonUI");
		
		component.updateUI();
		component.repaint();
		return buttonUI;
	}

}

