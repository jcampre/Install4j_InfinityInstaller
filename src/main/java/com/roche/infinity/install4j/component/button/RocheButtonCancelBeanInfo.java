package com.roche.infinity.install4j.component.button;

import com.install4j.api.beaninfo.Install4JPropertyDescriptor;
import com.roche.infinity.install4j.wrapper.RocheButtonWrapperBeanInfo;

/**
 * 
 * @author Jordi Campreciós
 * @date May 2018
 * Define the roche button cancel bean info
 */
public class RocheButtonCancelBeanInfo  extends RocheButtonWrapperBeanInfo {

	private static final String PROPERTY_DIALOGBOX_TITLE = "dialogBoxTitle";
	private static final String PROPERTY_DIALOGBOX_TEXT = "dialogBoxText";
	
	/**
	 * Overloaded constructor
	 */
    public RocheButtonCancelBeanInfo() {
        super("Custom Roche Button Cancel", "The is a custom Roche button component for the cancel action.", null, null, RocheButtonCancel.class);
        setPropertyDescriptor();
    }
    
    /**
     * 
     */
    private void setPropertyDescriptor() {
    	addPropertyDescriptor(Install4JPropertyDescriptor.create(PROPERTY_DIALOGBOX_TITLE, getBeanClass(), "Cancellation dialog box title", "The title shown on the cancellation dialog box."));
        addPropertyDescriptor(Install4JPropertyDescriptor.create(PROPERTY_DIALOGBOX_TEXT, getBeanClass(), "Cancellation dialog box text", "The text shwon on the cancellation dialog box."));
    }
}