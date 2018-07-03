package com.roche.infinity.installer.install4j.utils;

import com.install4j.api.context.Context;

/**
 * 
 * All operations with install4j.Context
 * @author jcamprec 
 */
public class ContextUtils {
	
	/**
	 * Default constructor
	 */
	public ContextUtils() {}
	
	/**
	 * Updates String context variable
	 * 
	 * @param context - install4j context
	 * @param variableName - name of the variable to be updated
	 * @param newValue - value of the variable to be updated
	 */

	public static void updateStringVariable(Context context, String variableName, String newValue) {
		context.setVariable(variableName, newValue);
	}
	
	/**
	 * Updates Integer context variable
	 * 
	 * @param context - install4j context
	 * @param variableName - the name of the variable to be updated
	 * @param newValue - the value of the variable to be updated
	 */
	public static void updateIntegerVariable(Context context, String variableName, int newValue) {
		context.setVariable(variableName, newValue);
	}
}
