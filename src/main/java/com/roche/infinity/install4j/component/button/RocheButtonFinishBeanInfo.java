package com.roche.infinity.install4j.component.button;

import com.roche.infinity.install4j.wrapper.RocheButtonFinish;
import com.roche.infinity.install4j.wrapper.RocheButtonWrapperBeanInfo;

/**
 * 
 * @author Jordi Campreciós
 * @date May 2018
 * Define the roche button finish bean info
 */
public class RocheButtonFinishBeanInfo  extends RocheButtonWrapperBeanInfo {
  
	/**
	 * Overloaded contructor
	 */
    public RocheButtonFinishBeanInfo() {
        super("Custom Roche Button Finish", "The is a custom Roche button component for the finish action.", null, null, RocheButtonFinish.class);        
    }
}