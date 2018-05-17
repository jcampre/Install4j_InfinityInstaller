package com.roche.infinity.install4j.wrapper;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.Border;
import com.install4j.api.beans.ExternalFile;
import com.install4j.api.formcomponents.AbstractFormComponent;
import com.roche.infinity.screen.components.RocheButton;

/**
 * 
 * @author Jordi Campreciós
 * @date May 2018
 *
 */
public class RocheButtonWrapper extends AbstractFormComponent{

	protected RocheButton rocheButton;
	private String textLabel;
	private String textToolTip;
	private int width;
	private int height;
	private Border borderRaised;
	private Border borderPressed;
	private Color background;
	private Color pressedBackground;
	private Color foreground;
	private Color activeForeground;
	private Color focusBorder;
	private ExternalFile buttonIconFile;
	
	/**
	 * @return the rocheButton
	 */
	public RocheButton getRocheButton() {
		return rocheButton;
	}

	/**
	 * @param rocheButton the rocheButton to set
	 */
	public void setRocheButton(RocheButton rocheButton) {
		this.rocheButton = rocheButton;
	}

	/**
	 * @return the textLabel
	 */
	public String getTextLabel() {
		return textLabel;
	}

	/**
	 * @param textLabel the textLabel to set
	 */
	public void setTextLabel(String textLabel) {
		this.textLabel = textLabel;
	}

	/**
	 * @return the textToolTip
	 */
	public String getTextToolTip() {
		return textToolTip;
	}

	/**
	 * @param textToolTip the textToolTip to set
	 */
	public void setTextToolTip(String textToolTip) {
		this.textToolTip = textToolTip;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the borderRaised
	 */
	public Border getBorderRaised() {
		return borderRaised;
	}

	/**
	 * @param borderRaised the borderRaised to set
	 */
	public void setBorderRaised(Border borderRaised) {
		this.borderRaised = borderRaised;
	}

	/**
	 * @return the borderPressed
	 */
	public Border getBorderPressed() {
		return borderPressed;
	}

	/**
	 * @param borderPressed the borderPressed to set
	 */
	public void setBorderPressed(Border borderPressed) {
		this.borderPressed = borderPressed;
	}

	/**
	 * @return the background
	 */
	public Color getBackground() {
		return background;
	}

	/**
	 * @param background the background to set
	 */
	public void setBackground(Color background) {
		this.background = background;
	}

	/**
	 * @return the pressedBackground
	 */
	public Color getPressedBackground() {
		return pressedBackground;
	}

	/**
	 * @param pressedBackground the pressedBackground to set
	 */
	public void setPressedBackground(Color pressedBackground) {
		this.pressedBackground = pressedBackground;
	}

	/**
	 * @return the foreground
	 */
	public Color getForeground() {
		return foreground;
	}

	/**
	 * @param foreground the foreground to set
	 */
	public void setForeground(Color foreground) {
		this.foreground = foreground;
	}

	/**
	 * @return the activeForeground
	 */
	public Color getActiveForeground() {
		return activeForeground;
	}

	/**
	 * @param activeForeground the activeForeground to set
	 */
	public void setActiveForeground(Color activeForeground) {
		this.activeForeground = activeForeground;
	}

	/**
	 * @return the focusBorder
	 */
	public Color getFocusBorder() {
		return focusBorder;
	}

	/**
	 * @param focusBorder the focusBorder to set
	 */
	public void setFocusBorder(Color focusBorder) {
		this.focusBorder = focusBorder;
	}

	/**
	 * @return the buttonIconFile
	 */
	public ExternalFile getButtonIconFile() {
		return buttonIconFile;
	}

	/**
	 * @param buttonIconFile the buttonIconFile to set
	 */
	public void setButtonIconFile(ExternalFile buttonIconFile) {
		this.buttonIconFile = buttonIconFile;
	}	
	
	/**
	 * 
	 */
	public RocheButtonWrapper() {		
		background = Color.BLUE;
		borderRaised = BorderFactory.createLineBorder(foreground);
		borderPressed = BorderFactory.createLineBorder(foreground);
		pressedBackground = Color.CYAN;
		foreground = Color.RED;
		activeForeground = Color.GREEN;
		focusBorder = Color.ORANGE;
	}
	
	@Override
	public JComponent createCenterComponent() {
		return null;
	}

	@Override
	public boolean isFillCenterHorizontal() {
		return false;
	}
	
}