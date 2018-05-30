package com.roche.infinity.install4j.wrappers;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComponent;
import com.install4j.api.formcomponents.AbstractFormComponent;
import com.roche.infinity.install4j.components.RocheProgressBar;
import com.roche.infinity.screen.component.ui.button.RocheProgressBarUI;

public class RocheProgressBarWrapper extends AbstractFormComponent {

	private static final int PROGRESSBAR_WIDTH = 200;
	private static final int PROGRESSBAR_HEIGHT = 141;

	private Color background;

	private int width = PROGRESSBAR_WIDTH;
	private int height =  PROGRESSBAR_HEIGHT;
	private int value;
	
	

	protected RocheProgressBar rocheProgressBar;

	@Override
	public JComponent createCenterComponent() {
		rocheProgressBar = new RocheProgressBar(getWidth(), getHeight(), getBackground(), this.getValue());
		
		return rocheProgressBar;
	}

	@Override
	public boolean isFillCenterHorizontal() {
		return false;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
		setSize();
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
		setSize();
	}

	public Color getBackground() {
		return background;
	}

	public void setBackground(Color background) {
		this.background = background;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
		rocheProgressBar.setValue(value);
	}

	private void setSize() {
		if ( ( getWidth() == 0 ) &&  (getHeight() == 0))
		{
			setPreferredSize();
		}
		else {
			setCustomSize();
		}
	}
	
	private void setPreferredSize() {
		rocheProgressBar.setWidth(getWidth());
		rocheProgressBar.setHeight(getHeight());
	}

	private void setCustomSize() {
		rocheProgressBar.setPreferredSize(new Dimension(getWidth(), getHeight()));
	}
}
