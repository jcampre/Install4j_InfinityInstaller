package com.roche.infinity.installer.install4j.component.button;

import com.install4j.api.beaninfo.Install4JPropertyDescriptor;
import com.roche.infinity.installer.install4j.wrapper.button.RocheButtonWrapperBeanInfo;

/**
 * 
 * @author Jordi Camprecios
 * Define the roche button finish bean info
 */
public class RocheButtonSkipBeanInfo  extends RocheButtonWrapperBeanInfo {
	
	private static final String PROPERTY_TEXT_TOSCREEN = "toScreen";
	
	/**
	 * Default contructor
	 */
    public RocheButtonSkipBeanInfo() {
        super("Custom Roche Footer Button Skip", "The is a custom Roche footer button component for the skip action.", null, null, RocheButtonSkip.class);
        addPropertyDescriptor(Install4JPropertyDescriptor.create(PROPERTY_TEXT_TOSCREEN, getBeanClass(), "Skip to Screen", "Set the screen to skip to."));
    }
}