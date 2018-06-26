package com.roche.infinity.installer.install4j.component.button;

import com.roche.infinity.installer.install4j.wrapper.button.RocheButtonWrapperBeanInfo;

/**
 * 
 * @author Jordi Campreciós
 * @date May 2018
 * Define the roche button cancel bean info
 */
public class RocheButtonCancelBeanInfo  extends RocheButtonWrapperBeanInfo {

	/**
	 * Default constructor
	 */
    public RocheButtonCancelBeanInfo() {
        super("Custom Roche Footer Button Cancel", "The is a custom Roche footer button component for the cancel action.", null, null, RocheButtonCancel.class);
    }
    
}