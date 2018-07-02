package com.roche.infinity.installer.install4j.wrapper.button;

import com.install4j.api.beaninfo.FormComponentBeanInfo;
import com.install4j.api.beaninfo.Install4JPropertyDescriptor;
import com.install4j.api.formcomponents.FormComponent;

/**
 * 
 * @author Jordi Camprecios
 * Define the button wrapper bean info
 */
public class RocheButtonWrapperBeanInfo  extends FormComponentBeanInfo {

	private static final String PROPERTY_TEXT_LABEL = "textLabel";
	private static final String PROPERTY_TEXTTOOLTIP = "textToolTip";
	private static final String PROPERTY_WIDTH = "width";
	private static final String PROPERTY_HEIGHT = "height";
	private static final String PROPERTY_ICON = "buttonIconFile";
	private static final String PROPERTY_HIDE = "hide";	
	private static final String PROPERTY_FONT = "font";
	private static final String PROPERTY_DISABLE = "disable";
	private static final String PROPERTY_BUTTON_SIZE = "size";
	private static final String PROPERTY_BUTTON_TYPE = "type";
	
  
	/**
	 * 
	 * @param displayName display name
	 * @param shortDescription short description
	 * @param category category
	 * @param sortKey sort key
	 * @param beanClass bean class
	 */
	
	public RocheButtonWrapperBeanInfo(String displayName, String shortDescription, String category, Integer sortKey,
			Class<? extends FormComponent> beanClass) {
		super(displayName, shortDescription, category, sortKey, beanClass);
		setPropertyDescriptor();
		addEnumProperties();
	}
	
	/**
	 * Default constructor
	 */
    public RocheButtonWrapperBeanInfo() {
        super("Custom Roche Button", 
        		"The is a custom Roche button component.", 
        		null, null, RocheButtonWrapper.class);
        setPropertyDescriptor();
        addEnumProperties();
    }
    
    /**
     * Sets the property descriptor
     */
    private void setPropertyDescriptor() {
    	addPropertyDescriptor(Install4JPropertyDescriptor.create(PROPERTY_TEXT_LABEL, getBeanClass(), "Label text", "The text shown on the button."));
        addPropertyDescriptor(Install4JPropertyDescriptor.create(PROPERTY_TEXTTOOLTIP, getBeanClass(), "ToolTip text", "The tool tip text shown on the button."));
        addPropertyDescriptor(Install4JPropertyDescriptor.create(PROPERTY_WIDTH, getBeanClass(), "Width", "Defined width of the button."));
        addPropertyDescriptor(Install4JPropertyDescriptor.create(PROPERTY_HEIGHT, getBeanClass(), "Height", "Defined height of the button."));
        addPropertyDescriptor(Install4JPropertyDescriptor.create(PROPERTY_ICON, getBeanClass(), "Image", "The image shown on the button."));    	
        addPropertyDescriptor(Install4JPropertyDescriptor.create(PROPERTY_HIDE, getBeanClass(), "Hide", "Set button's visibility."));
        addPropertyDescriptor(Install4JPropertyDescriptor.create(PROPERTY_FONT, getBeanClass(), "Font", "Set button's font."));
        addPropertyDescriptor(Install4JPropertyDescriptor.create(PROPERTY_DISABLE, getBeanClass(), "Disabled", "Set button disabled."));
    }
    
    private void addEnumProperties() {
        addPropertyDescriptor(Install4JPropertyDescriptor.create(PROPERTY_BUTTON_SIZE, getBeanClass(), "Size of the button", "Set the size of the button."));
        addPropertyDescriptor(Install4JPropertyDescriptor.create(PROPERTY_BUTTON_TYPE, getBeanClass(), "Type of button", "Set the type of button."));
	}
}