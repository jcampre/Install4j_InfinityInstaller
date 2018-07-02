package com.roche.infinity.installer.install4j.wrapper.button;

import java.awt.Font;
import javax.swing.JComponent;
import com.install4j.api.beans.ExternalFile;
import com.install4j.api.formcomponents.AbstractFormComponent;
import com.roche.infinity.installer.install4j.screen.component.button.RocheButton;
import com.roche.infinity.installer.install4j.style.utilities.ButtonFonts;
import com.roche.infinity.installer.install4j.style.utilities.Utilities.StyleProperties;
import com.roche.infinity.installer.install4j.style.utilities.Utilities.StyleProperties.ButtonSizes;
import com.roche.infinity.installer.install4j.style.utilities.Utilities.StyleProperties.ButtonTypes;

/**
 * 
 * @author Jordi Camprecios
 * Define the button wrapper
 */
public abstract class RocheButtonWrapper extends AbstractFormComponent {

	private String textLabel;
	private String textToolTip;	
	private ExternalFile buttonIconFile;
	private ButtonTypes type = ButtonTypes.NORMAL;
	private int width = 112;
	private int height = 36;
	private boolean hide = false;
	private boolean disable = false;
	private Font font = ButtonFonts.BUTTON_FONT.getFont();
	private ButtonSizes size = ButtonSizes.MEDIUM;
	
	protected RocheButton rocheButton;
	
	public ButtonSizes getSize() {
		return size;
	}

	public void setSize(ButtonSizes size) {
		this.size = size;
		
		if ( StyleProperties.buttonSizesList.isEmpty())
		{
			StyleProperties.setDefaultButtonSizes();
		}

		this.setWidth(StyleProperties.buttonSizesList.get(size.name()).width);
		this.setHeight(StyleProperties.buttonSizesList.get(size.name()).height);
	}
	
	/**
	 * @return the disable
	 */
	public boolean isDisable() {
		return disable;
	}

	/**
	 * @param disable
	 * The disable to set
	 */
	public void setDisable(boolean disable) {
		this.disable = disable;
	}

	public ButtonTypes getType() {
		return type;
	}

	public void setType(ButtonTypes type) {
		this.type = type;
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
	 * @return the hide
	 */
	public boolean isHide() {
		return hide;
	}

	/**
	 * @param hide the hide to set
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
	 * @param font the font to set
	 */
	public void setFont(Font font) {
		this.font = font;
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
	 * Default constructor
	 */
	public RocheButtonWrapper() {
		super();		
	}
	
	/**
	 * 
	 */
	@Override
	public JComponent createCenterComponent() {
		return null;
	}
	
	/**
	 * 
	 */
	@Override
	public boolean isFillCenterHorizontal() {
		return false;
	}
}