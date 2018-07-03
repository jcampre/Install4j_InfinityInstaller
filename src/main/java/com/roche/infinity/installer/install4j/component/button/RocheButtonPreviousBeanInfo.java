package com.roche.infinity.installer.install4j.component.button;

import com.roche.infinity.installer.install4j.wrapper.button.RocheButtonWrapperBeanInfo;

/**
 * 
 * @author Jordi Camprecios
 * Define the roche button cancel bean info
 */
public class RocheButtonPreviousBeanInfo  extends RocheButtonWrapperBeanInfo {

	/**
	 * Default constructor
	 */
    public RocheButtonPreviousBeanInfo() {
        super("Custom Roche Footer Button Previous", "The is a custom Roche footer button component for the previous action.", null, null, RocheButtonPrevious.class);
    }
    
}