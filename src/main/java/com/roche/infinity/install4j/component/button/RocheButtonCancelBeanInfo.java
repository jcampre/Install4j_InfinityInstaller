package com.roche.infinity.install4j.component.button;

import com.roche.infinity.install4j.wrapper.button.RocheButtonWrapperBeanInfo;

/**
 * 
 * @author Jordi Campreciós
 * @date May 2018
 * Define the roche button cancel bean info
 */
public class RocheButtonCancelBeanInfo  extends RocheButtonWrapperBeanInfo {

	/**
	 * Overloaded constructor
	 */
    public RocheButtonCancelBeanInfo() {
        super("Custom Roche Button Cancel", "The is a custom Roche button component for the cancel action.", null, null, RocheButtonCancel.class);
    }
    
}