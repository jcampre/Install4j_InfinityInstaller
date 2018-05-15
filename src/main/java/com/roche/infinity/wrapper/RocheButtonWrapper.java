package com.roche.infinity.wrapper;

import javax.swing.JComponent;

import com.install4j.api.beans.ExternalFile;
import com.install4j.api.formcomponents.AbstractFormComponent;
import com.roche.infinity.screen.components.RocheButton;

public class RocheButtonWrapper extends AbstractFormComponent{

	protected RocheButton rocheButton;
	private String text;
	private int width;
	private int height;
	

	private ExternalFile buttonIconFile;
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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

	public ExternalFile getButtonIconFile() {
		return buttonIconFile;
	}

	public void setButtonIconFile(ExternalFile buttonIconFile) {
		this.buttonIconFile = buttonIconFile;
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
