package com.roche.infinity.installer.install4j.component.button.ui;

import javax.swing.JComponent;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ComponentUI;

import com.roche.infinity.installer.install4j.style.utilities.Utilities.StyleProperties;

/**
 * 
 * @author Jordi Campreciós i Jordi Arenas
 * @date May/juny 2018
 * Define the button actions and the style
 */
public class ActiveRocheButtonUI extends RocheButtonUI {

	private static final long serialVersionUID = 1L;
	
	private static final ActiveRocheButtonUI buttonUI = new ActiveRocheButtonUI();


	public ActiveRocheButtonUI() {
		super();
		setDefaultColors();
	}
	
	public static ComponentUI createUI(JComponent component) {
		return buttonUI;
	}
	
	private void setDefaultColors() {
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
	
	/**
	 * 
	 * @param c
	 */
	@Override
	public void enableButton(JComponent c) {
		this.setDefaultColors();
		c.addMouseListener(this);
		c.addKeyListener(this);
	}
}