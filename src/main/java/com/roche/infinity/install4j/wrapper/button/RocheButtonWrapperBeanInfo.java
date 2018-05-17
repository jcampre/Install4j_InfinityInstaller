package com.roche.infinity.install4j.wrapper.button;

import com.install4j.api.beaninfo.FormComponentBeanInfo;
import com.install4j.api.beaninfo.Install4JPropertyDescriptor;
import com.install4j.api.formcomponents.FormComponent;

/**
 * 
 * @author Jordi Campreciós
 * @date May 2018
 * Define the button wrapper bean info
 */
public class RocheButtonWrapperBeanInfo  extends FormComponentBeanInfo {

	private static final String PROPERTY_TEXT_LABEL = "textLabel";
	private static final String PROPERTY_TEXTTOOLTIP = "textToolTip";
	private static final String PROPERTY_WIDTH = "width";
	private static final String PROPERTY_HEIGHT = "height";
	private static final String PROPERTY_BORDERRAISED = "borderRaised";
	private static final String PROPERTY_BORDERPRESSED = "borderPressed";
	private static final String PROPERTY_BACKGROUND = "background";
	private static final String PROPERTY_PRESSEDBACKGROUND = "pressedBackground";
	private static final String PROPERTY_FOREGROUND = "foreground";
	private static final String PROPERTY_ACTIVEFOREGROUND = "activeForeground";
	private static final String PROPERTY_FOCUSBORDER = "focusBorder";
	private static final String PROPERTY_ICON = "buttonIconFile";
  
	/**
	 * 
	 * @param displayName
	 * @param shortDescription
	 * @param category
	 * @param sortKey
	 * @param beanClass
	 */
	public RocheButtonWrapperBeanInfo(String displayName, String shortDescription, String category, Integer sortKey,
			Class<? extends FormComponent> beanClass) {
		super(displayName, shortDescription, category, sortKey, beanClass);
		setPropertyDescriptor();
	}
	
	/**
	 * Wrapper bean info
	 */
    public RocheButtonWrapperBeanInfo() {
        super("Custom Roche Button", "The is a custom Roche button component.", null, null, RocheButtonWrapper.class);
        setPropertyDescriptor();        
    }
    
    /**
     * Sets the property descriptor
     */
    private void setPropertyDescriptor() {
    	addPropertyDescriptor(Install4JPropertyDescriptor.create(PROPERTY_TEXT_LABEL, getBeanClass(), "Label text", "The text shown on the button."));
        addPropertyDescriptor(Install4JPropertyDescriptor.create(PROPERTY_TEXTTOOLTIP, getBeanClass(), "ToolTip text", "The tool tip text shown on the button."));
        addPropertyDescriptor(Install4JPropertyDescriptor.create(PROPERTY_WIDTH, getBeanClass(), "Width", "Defined width of the button."));
        addPropertyDescriptor(Install4JPropertyDescriptor.create(PROPERTY_HEIGHT, getBeanClass(), "Height", "Defined height of the button."));
        addPropertyDescriptor(Install4JPropertyDescriptor.create(PROPERTY_BORDERRAISED, getBeanClass(), "Border", "Defined button's border."));
        addPropertyDescriptor(Install4JPropertyDescriptor.create(PROPERTY_BORDERPRESSED, getBeanClass(), "Border pressed", "Defined button's border when button pressed."));
        addPropertyDescriptor(Install4JPropertyDescriptor.create(PROPERTY_BACKGROUND, getBeanClass(), "Background color", "Defined button's background color."));
        addPropertyDescriptor(Install4JPropertyDescriptor.create(PROPERTY_PRESSEDBACKGROUND, getBeanClass(), "Background color (button pressed)", "Defined button's background color when button is pressed."));
        addPropertyDescriptor(Install4JPropertyDescriptor.create(PROPERTY_FOREGROUND, getBeanClass(), "Foreground color", "Defined button's foreground."));
        addPropertyDescriptor(Install4JPropertyDescriptor.create(PROPERTY_ACTIVEFOREGROUND, getBeanClass(), "Foreground color (button actived)", "Defined button's foreground when button is active."));
        addPropertyDescriptor(Install4JPropertyDescriptor.create(PROPERTY_FOCUSBORDER, getBeanClass(), "Border (button focused)", "Defined button's border when button is focused."));
        addPropertyDescriptor(Install4JPropertyDescriptor.create(PROPERTY_ICON, getBeanClass(), "Image", "The image shown on the button."));    	
    }
}