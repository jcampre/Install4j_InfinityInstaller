package com.roche.infinity.installer.install4j.system;

import java.io.File;

import com.install4j.api.Util;
import com.roche.infinity.installer.install4j.utils.LoggerManager;

/**
 * 
 * @author jcamprec
 * Evaluates the minimum requirements for each component
 */

public class ComponentRequirements {
	
	private ComponentRequirements(){}
	
	private static final long  MEGABYTE = 1024L * 1024L;
	private static final long  GIGABYTE = 1024L * 1024L * 1024L;
	
	/**
	 * Evaluates if there is enough disk space considering components selected
	 * 
	 * @param file -  the file to evaluate
	 * @param requiredSpace -  the required space	
	 * @return the return of the operation
	 */
	public static boolean evaluateMinimumDiskSpace(File file, double requiredSpace) {
		if (!file.exists()) {			
			if (file.mkdirs()) {
				LoggerManager.getInstance(ComponentRequirements.class).
				info(ComponentRequirements.class.getSimpleName(), "Directory " + file.getAbsolutePath() + " has been created");
			} else {
				LoggerManager.getInstance(ComponentRequirements.class).
				info(ComponentRequirements.class.getSimpleName(), "Directory " + file.getAbsolutePath() + " cannot be created");
				return false;
			}
		}

		Util.logInfo(null, "requiredSpace --> " + requiredSpace);
		Util.logInfo(null, "file.getFreeSpace() --> " + file.getFreeSpace());
		Util.logInfo(null, "file.getFreeSpace()/MEGABYTE --> " + file.getFreeSpace()/MEGABYTE);
		return requiredSpace < file.getFreeSpace()/MEGABYTE;
	}
}
