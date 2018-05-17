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

	private static final String PROPERTY_DEFAULT_PATH = "defaultPath";
	
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
        super("Custom Roche FileChooser", "The is a custom Roche file chooser component.", null, null, RocheButtonWrapper.class);
        setPropertyDescriptor();        
    }
    
    /**
     * Sets the property descriptor
     */
    private void setPropertyDescriptor() {
    	addPropertyDescriptor(Install4JPropertyDescriptor.create(PROPERTY_DEFAULT_PATH, getBeanClass(), "Default path", "The default path used in the file chooser."));        	
    }
}