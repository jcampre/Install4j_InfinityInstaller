package com.roche.infinity.installer.install4j.utils;

import com.install4j.api.context.Context;

/**
 * 
 * All operations with install4j.Context
 * 
 * @author jcamprec
 * @Date June 2018
 */
public class ContextUtils {

	private static final String GB = "GB";
	private static final String MB = "MB";
	private static final long  BYTE = 1024L;
	
	/**
	 * Default constructor
	 */
	public ContextUtils() {}
	
	/**
	 * Updates String context variable
	 * 
	 * @param context
	 * @param variableName
	 * @param newValue
	 */

	public static void updateStringVariable(Context context, String variableName, String newValue) {
		context.setVariable(variableName, newValue);
	}
	
	/**
	 * Updates Integer context variable
	 * 
	 * @param context
	 * @param variableName
	 * @param newValue
	 */
	public static void updateIntegerVariable(Context context, String variableName, int newValue) {
		context.setVariable(variableName, newValue);
	}
	
	/**
	 * 
	 * @param context
	 * @param requiredSpaceDisk
	 * @return
	 */
	public static String isMBorGB(Context context, Double requiredSpaceDisk) {
		
		if (requiredSpaceDisk < BYTE)
		    return MB;
		else {
		    context.setVariable("selectedComponentsRequiredSpaceDisk", String.valueOf(requiredSpaceDisk/BYTE));
		    LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), "Required installation disk space changed to GB.");
		    return GB;
		}
	}
}
