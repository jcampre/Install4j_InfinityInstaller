package com.roche.infinity.installer.install4j.component.button;

import com.roche.infinity.installer.install4j.wrapper.button.RocheButtonWrapperBeanInfo;

/**
 * 
 * @author Jordi Campreciós
 * @date May 2018
 * Define the roche button finish bean info
 */
public class RocheButtonFinishBeanInfo  extends RocheButtonWrapperBeanInfo {
  
	/**
	 * Default contructor
	 */
    public RocheButtonFinishBeanInfo() {
        super("Custom Roche Footer Button Finish", "The is a custom Roche footer button component for the finish action.", null, null, RocheButtonFinish.class);        
    }
}