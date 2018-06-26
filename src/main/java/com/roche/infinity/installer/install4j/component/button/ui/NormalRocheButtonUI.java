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
public class NormalRocheButtonUI extends RocheButtonUI {

	private static final long serialVersionUID = 1L;
	
	private static final NormalRocheButtonUI buttonUI = new NormalRocheButtonUI();

	public NormalRocheButtonUI() {
		super();
		
		setDefaultColors();
	}

	public static ComponentUI createUI(JComponent component) {
		return buttonUI;
	}	
	
	private void setDefaultColors() {
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