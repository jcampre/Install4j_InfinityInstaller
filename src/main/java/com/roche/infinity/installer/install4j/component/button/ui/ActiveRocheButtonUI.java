package com.roche.infinity.installer.install4j.component.button.ui;

import javax.swing.JComponent;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ComponentUI;
import com.roche.infinity.installer.install4j.style.utilities.ButtonActiveColors;

/**
 * 
 * @author Jordi Camprecios i Jordi Arenas
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

	@Override
	protected void setDefaultColors() {
		setBackgroundDefault(ButtonActiveColors.ACTIVE_DEFAULT_BUTTON_BACKGROUND_COLOR.getColor());
		setBackgroundPressed(ButtonActiveColors.ACTIVE_PRESSED_BUTTON_BACKGROUND_COLOR.getColor());
		setBackgroundHover(ButtonActiveColors.ACTIVE_HOVER_BUTTON_BACKGROUND_COLOR.getColor());
		setBackgroundDisable(ButtonActiveColors.ACTIVE_DISABLE_BUTTON_BACKGROUND_COLOR.getColor());
		setForegroundDefault(ButtonActiveColors.ACTIVE_DEFAULT_BUTTON_FOREGROUND_COLOR.getColor());
		setForegroundPressed(ButtonActiveColors.ACTIVE_PRESSED_BUTTON_FOREGROUND_COLOR.getColor());
		setForegroundHover(ButtonActiveColors.ACTIVE_HOVER_BUTTON_FOREGROUND_COLOR.getColor());
		setForegroundDisable(ButtonActiveColors.ACTIVE_DISABLE_BUTTON_FOREGROUND_COLOR.getColor());
		setBorderDefault(new LineBorder(ButtonActiveColors.ACTIVE_DEFAULT_BUTTON_BORDER_COLOR.getColor()));
		setBorderPressed(new LineBorder(ButtonActiveColors.ACTIVE_PRESSED_BUTTON_BORDER_COLOR.getColor()));
		setBorderHover(new LineBorder(ButtonActiveColors.ACTIVE_HOVER_BUTTON_BORDER_COLOR.getColor()));
		setBorderDisable(new LineBorder(ButtonActiveColors.ACTIVE_DISABLE_BUTTON_BORDER_COLOR.getColor()));
	}

}