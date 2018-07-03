package com.roche.infinity.installer.install4j.component.button;

import com.roche.infinity.installer.install4j.wrapper.button.RocheButtonWrapperBeanInfo;

/**
 * 
 * @author Jordi Camprecios
 * Define the roche button cancel bean info
 */
public class RocheButtonNextBeanInfo  extends RocheButtonWrapperBeanInfo {

	/**
	 * Default constructor
	 */
    public RocheButtonNextBeanInfo() {
        super("Custom Roche Footer Button Next", "The is a custom Roche footer button component for the next action.", null, null, RocheButtonNext.class);
    }
    
}