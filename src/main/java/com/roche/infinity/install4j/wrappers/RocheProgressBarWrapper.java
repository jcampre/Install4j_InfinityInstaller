package com.roche.infinity.install4j.wrappers;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.plaf.ProgressBarUI;

import com.install4j.api.context.Context;
import com.install4j.api.formcomponents.AbstractFormComponent;
import com.roche.infinity.install4j.components.RocheProgressBar;
import com.roche.infinity.screen.component.ui.button.RocheButtonUI;
import com.roche.infinity.screen.component.ui.button.RocheProgressBarUI;

public class RocheProgressBarWrapper extends AbstractFormComponent{

	private Color background;
	private Context context;
	
	private int width;
	private int height;
	
	protected RocheProgressBar rocheProgressBar;
	
	/**
	 * Overloaded constructor
	 */
	public RocheProgressBarWrapper() {
		this.context = getContext(); 
		background = Color.RED;
	}
	
	@Override
	public JComponent createCenterComponent() {
		rocheProgressBar = new RocheProgressBar(this.getWidth(), this.getHeight(), this.getBackground());
		rocheProgressBar.setUI(new RocheProgressBarUI());
		
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
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Color getBackground() {
		return background;
	}

	public void setBackground(Color background) {
		this.background = background;
	}
	
	/**
	 * @return the context
	 */
	public Context getContext() {
		return context;
	}

	/**
	 * @param context the context to set
	 */
	public void setContext(Context context) {
		this.context = context;
	}
	
}
