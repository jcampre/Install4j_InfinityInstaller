package com.roche.infinity.install4j.component.filechooser;

import com.install4j.api.beaninfo.FormComponentBeanInfo;
import com.install4j.api.beaninfo.Install4JPropertyDescriptor;
import com.install4j.api.formcomponents.FormComponent;

/**
 * 
 * @author Jordi Campreci�s
 * @date May 2018
 * Define the button wrapper bean info
 */
public class RocheFileChooser4jBeanInfo  extends FormComponentBeanInfo {

	private static final String PROPERTY_DEFAULT_PATH = "defaultPath";
	
	/**
	 * 
	 * @param displayName
	 * @param shortDescription
	 * @param category
	 * @param sortKey
	 * @param beanClass
	 */
	public RocheFileChooser4jBeanInfo(String displayName, String shortDescription, String category, Integer sortKey,
			Class<? extends FormComponent> beanClass) {
		super(displayName, shortDescription, category, sortKey, beanClass);
		setPropertyDescriptor();
	}
	
	/**
	 * Wrapper bean info
	 */
    public RocheFileChooser4jBeanInfo() {
        super("Custom Roche FileChooser", "The is a custom Roche file chooser component.", null, null, RocheFileChooser4j.class);
        setPropertyDescriptor();        
    }
    
    /**
     * Sets the property descriptor
     */
    private void setPropertyDescriptor() {
    	addPropertyDescriptor(Install4JPropertyDescriptor.create(PROPERTY_DEFAULT_PATH, getBeanClass(), "Default path", "The default path used in the file chooser."));        	
    }
}