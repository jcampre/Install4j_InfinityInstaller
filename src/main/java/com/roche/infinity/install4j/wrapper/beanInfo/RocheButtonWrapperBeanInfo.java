package com.roche.infinity.install4j.wrapper.beanInfo;

import com.install4j.api.beaninfo.FormComponentBeanInfo;
import com.install4j.api.beaninfo.Install4JPropertyDescriptor;
import com.roche.infinity.install4j.wrapper.RocheButtonWrapper;

/**
 * 
 * @author Jordi Campreciós
 * @date May 2018
 *
 */

public class RocheButtonWrapperBeanInfo  extends FormComponentBeanInfo {

	private static final String PROPERTY_BUTTON_WIDTH = "width";
	private static final String PROPERTY_BUTTON_HEIGHT = "height";
	public RocheButtonWrapperBeanInfo() {
		
		super("Roche Button", 
			"A control button that handles the user action with respect to the screen flow. This includes activating the next screen, activating the previous screen and cancelling the wizard",
			null, null, RocheButtonWrapper.class);
		
		addPropertyDescriptor(Install4JPropertyDescriptor.create(PROPERTY_BUTTON_WIDTH, getBeanClass(), "Amplada", "Set the widht of the button"));
		addPropertyDescriptor(Install4JPropertyDescriptor.create(PROPERTY_BUTTON_HEIGHT, getBeanClass(), "Alçada", "Set the height of the button"));
	}
}

