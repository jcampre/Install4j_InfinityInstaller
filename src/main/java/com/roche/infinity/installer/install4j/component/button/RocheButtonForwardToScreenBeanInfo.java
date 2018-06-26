package com.roche.infinity.installer.install4j.component.button;

import com.install4j.api.beaninfo.Install4JPropertyDescriptor;
import com.roche.infinity.installer.install4j.wrapper.button.RocheButtonWrapperBeanInfo;

/**
 * 
 * @author Jordi Campreciós
 * @date May 2018
 * Define the roche button cancel bean info
 */
public class RocheButtonForwardToScreenBeanInfo  extends RocheButtonWrapperBeanInfo {
	private static final String PROPERTY_TEXT_TOSCREEN = "toScreen";
	/**
	 * Default constructor
	 */
    public RocheButtonForwardToScreenBeanInfo() {
        super("Custom Roche Button Forward To", "The is a custom Roche button component for the forward to action.", null, null, RocheButtonForwardToScreen.class);
        addPropertyDescriptor(Install4JPropertyDescriptor.create(PROPERTY_TEXT_TOSCREEN, getBeanClass(), "Forward to Screen", "Set the screen to forward to."));
    }
}