package com.roche.infinity.action;

import com.install4j.api.beaninfo.*;
import com.install4j.api.beans.Bean;

/**
 * BeanInfo for SampleAction
 */
@SuppressWarnings("unused")
public class ZipActionBeanInfo extends ActionBeanInfo {

    private static final String PROPERTY_SOURCE_FOLDER = "sourceFolder";
    private static final String PROPERTY_ZIP_FILE = "destinationZipFile";
   
    public ZipActionBeanInfo() {
        super("Zip action", "This is just a zip action", "Utils", true, false, null, ZipAction.class);

        addPropertyDescriptor(Install4JPropertyDescriptor.create(PROPERTY_SOURCE_FOLDER, getBeanClass(), "Source folder", "The source control to create a zip file. Cannot be empty."));
        addPropertyDescriptor(Install4JPropertyDescriptor.create(PROPERTY_ZIP_FILE, getBeanClass(), "Zip file", "The zip file where the source folder will be compressed. Cannot be empty."));
    }
}
