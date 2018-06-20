package com.roche.infinity.install4j.wrapper.button;

import java.awt.Font;

import javax.swing.JComponent;

import com.install4j.api.beans.ExternalFile;
import com.install4j.api.context.Context;
import com.install4j.api.formcomponents.AbstractFormComponent;
import com.roche.infinity.install4j.utils.StyleUtils.StyleProperties;
import com.roche.infinity.install4j.utils.StyleUtils.StyleProperties.ButtonSizes;
import com.roche.infinity.install4j.utils.StyleUtils.StyleProperties.ButtonTypes;
import com.roche.infinity.screen.component.button.RocheButton;
import com.roche.infinity.screen.component.ui.button.ActiveRocheButtonUI;
import com.roche.infinity.screen.component.ui.button.NormalRocheButtonUI;
import com.roche.infinity.screen.component.ui.button.RocheButtonUI;

/**
 * 
 * @author Jordi Campreciós i Jordi Arenas
 * @date May 2018 Define the button wrapper
 */
public abstract class RocheButtonWrapper extends AbstractFormComponent {

	private Context context;
	private String textLabel = "button";
	private String textToolTip = "button tooltip";
	private ButtonSizes size = ButtonSizes.MEDIUM;
	private ButtonTypes type = ButtonTypes.NORMAL;
	private int width = 112;
	private int height = 36;
	private boolean hide = false;
	private boolean disable = false;
	private Font font = StyleProperties.BUTTON_FONT;
	private ExternalFile buttonIconFile = null;

	protected RocheButtonUI buttonUI;

	protected RocheButton rocheButton;

	public RocheButtonUI getButtonUI() {
		return buttonUI;
	}

	public void setButtonUI(RocheButtonUI buttonUI) {
		this.buttonUI = buttonUI;
	}

	/**
	 * @return the disable
	 */
	public boolean isDisable() {
		return disable;
	}

	/**
	 * @param disable
	 *            the disable to set
	 */
	public void setDisable(boolean disable) {
		this.disable = disable;
	}

	public ButtonTypes getType() {
		return type;
	}

	public void setType(ButtonTypes type) {
		this.type = type;
		
		switch (this.getType()) {
		case NORMAL:
			buttonUI = (RocheButtonUI) new NormalRocheButtonUI();
			break;
		case ACTIVE:
			buttonUI = (RocheButtonUI) new ActiveRocheButtonUI();
			break;
		}
	}

	public ButtonSizes getSize() {
		return size;
	}

	public void setSize(ButtonSizes size) {
		this.size = size;

		if (StyleProperties.buttonSizesList.isEmpty()) {
			StyleProperties.setDefaultButtonSizes();
		}

		this.setWidth(StyleProperties.buttonSizesList.get(size.name()).width);
		this.setHeight(StyleProperties.buttonSizesList.get(size.name()).height);
	}

	/**
	 * @return the textLabel
	 */
	public String getTextLabel() {
		return textLabel;
	}

	/**
	 * @param textLabel
	 *            the textLabel to set
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
	 * @param textToolTip
	 *            the textToolTip to set
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
	 * @param width
	 *            the width to set
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
	 * @param height
	 *            the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the hide
	 */
	public boolean isHide() {
		return hide;
	}

	/**
	 * @param hide
	 *            the hide to set
	 */
	public void setHide(boolean hide) {
		this.hide = hide;
	}

	/**
	 * @return the font
	 */
	public Font getFont() {
		return font;
	}

	/**
	 * @param font
	 *            the font to set
	 */
	public void setFont(Font font) {
		this.font = font;
	}

	/**
	 * @return the context
	 */
	public Context getContext() {
		return context;
	}

	/**
	 * @param context
	 *            the context to set
	 */
	public void setContext(Context context) {
		this.context = context;
	}

	/**
	 * @return the buttonIconFile
	 */
	public ExternalFile getButtonIconFile() {
		return buttonIconFile;
	}

	/**
	 * @param buttonIconFile
	 *            the buttonIconFile to set
	 */
	public void setButtonIconFile(ExternalFile buttonIconFile) {
		this.buttonIconFile = buttonIconFile;
	}

	/**
	 * Overloaded constructor
	 */
	public RocheButtonWrapper() {
		this.context = getContext();
	}

	/**
	 * 
	 */
	@Override
	public JComponent createCenterComponent() {
		switch (this.getType()) {
		case NORMAL:
			buttonUI = (RocheButtonUI) new NormalRocheButtonUI();
			break;
		case ACTIVE:
			buttonUI = (RocheButtonUI) new ActiveRocheButtonUI();
			break;
		}

		return rocheButton;
	}

	/**
	 * 
	 */
	@Override
	public boolean isFillCenterHorizontal() {
		return false;
	}
}