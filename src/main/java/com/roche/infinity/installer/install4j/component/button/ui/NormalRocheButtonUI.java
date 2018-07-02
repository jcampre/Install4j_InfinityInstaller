package com.roche.infinity.installer.install4j.component.button.ui;

import javax.swing.JComponent;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ComponentUI;
import com.roche.infinity.installer.install4j.style.utilities.ButtonNormalColors;

/**
 * 
 * @author Jordi Camprecios i Jordi Arenas
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
	
	@Override
	protected void setDefaultColors() {
		setBackgroundDefault(ButtonNormalColors.NORMAL_DEFAULT_BUTTON_BACKGROUND_COLOR.getColor());
		setBackgroundPressed(ButtonNormalColors.NORMAL_PRESSED_BUTTON_BACKGROUND_COLOR.getColor());
		setBackgroundHover(ButtonNormalColors.NORMAL_HOVER_BUTTON_BACKGROUND_COLOR.getColor());
		setBackgroundDisable(ButtonNormalColors.NORMAL_DISABLE_BUTTON_BACKGROUND_COLOR.getColor());
		setForegroundDefault(ButtonNormalColors.NORMAL_DEFAULT_BUTTON_FOREGROUND_COLOR.getColor());
		setForegroundPressed(ButtonNormalColors.NORMAL_PRESSED_BUTTON_FOREGROUND_COLOR.getColor());
		setForegroundHover(ButtonNormalColors.NORMAL_HOVER_BUTTON_FOREGROUND_COLOR.getColor());
		setForegroundDisable(ButtonNormalColors.NORMAL_DISABLE_BUTTON_FOREGROUND_COLOR.getColor());
		setBorderDefault(new LineBorder(ButtonNormalColors.NORMAL_DEFAULT_BUTTON_BORDER_COLOR.getColor()));
		setBorderPressed(new LineBorder(ButtonNormalColors.NORMAL_PRESSED_BUTTON_BORDER_COLOR.getColor()));
		setBorderHover(new LineBorder(ButtonNormalColors.NORMAL_HOVER_BUTTON_BORDER_COLOR.getColor()));
		setBorderDisable(new LineBorder(ButtonNormalColors.NORMAL_DISABLE_BUTTON_BORDER_COLOR.getColor()));
	}		
	
	
}