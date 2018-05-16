package com.roche.infinity.install4j.wrapper;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.Border;

import com.install4j.api.beans.ExternalFile;
import com.install4j.api.formcomponents.AbstractFormComponent;
import com.roche.infinity.screen.components.RocheButton;

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
	
	public String getTextLabel() {
		return textLabel;
	}

	public void setTextLabel(String textLabel) {
		this.textLabel = textLabel;
	}

	
	public String getTextToolTip() {
		return textToolTip;
	}

	public void setTextToolTip(String textToolTip) {
		this.textToolTip = textToolTip;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public RocheButton getRocheButton() {
		return rocheButton;
	}

	public void setRocheButton(RocheButton rocheButton) {
		this.rocheButton = rocheButton;
	}

	public Border getBorderRaised() {
		return borderRaised;
	}

	public void setBorderRaised(Border borderRaised) {
		this.borderRaised = borderRaised;
	}

	public Border getBorderPressed() {
		return borderPressed;
	}

	public void setBorderPressed(Border borderPressed) {
		this.borderPressed = borderPressed;
	}

	public Color getBackground() {
		return background;
	}

	public void setBackground(Color background) {
		this.background = background;
	}

	public Color getPressedBackground() {
		return pressedBackground;
	}

	public void setPressedBackground(Color pressedBackground) {
		this.pressedBackground = pressedBackground;
	}

	public Color getForeground() {
		return foreground;
	}

	public void setForeground(Color foreground) {
		this.foreground = foreground;
	}

	public Color getActiveForeground() {
		return activeForeground;
	}

	public void setActiveForeground(Color activeForeground) {
		this.activeForeground = activeForeground;
	}

	public Color getFocusBorder() {
		return focusBorder;
	}

	public void setFocusBorder(Color focusBorder) {
		this.focusBorder = focusBorder;
	}

	public ExternalFile getButtonIconFile() {
		return buttonIconFile;
	}

	public void setButtonIconFile(ExternalFile buttonIconFile) {
		this.buttonIconFile = buttonIconFile;
	}

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isFillCenterHorizontal() {
		// TODO Auto-generated method stub
		return false;
	}
}
