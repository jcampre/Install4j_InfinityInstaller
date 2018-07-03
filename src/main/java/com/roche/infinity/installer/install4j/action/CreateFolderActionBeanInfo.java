package com.roche.infinity.installer.install4j.action;

import com.install4j.api.beaninfo.ActionBeanInfo;
import com.install4j.api.beaninfo.Install4JPropertyDescriptor;

/**
 * 
 * @author Jordi Camprecios
 * Define the custom action bean info create folder
 */
public class CreateFolderActionBeanInfo  extends ActionBeanInfo {

	private static final String PROPERTY_FOLDER = "folder";	
	  
	/**
	 * Default constructor
	 */
    public CreateFolderActionBeanInfo() {        
        super("Custom Create Folder Action", "The is a custom action to create a folder.", "Custom Action", true, false, null, CreateFolderAction.class);        
        setPropertyDescriptor();        
    }
    
    /**
     * Sets the property descriptor
     */
    private void setPropertyDescriptor() {    	
    	addPropertyDescriptor(Install4JPropertyDescriptor.create(PROPERTY_FOLDER, getBeanClass(), "Folder to create", "Folder to create"));
    }
    
    
}