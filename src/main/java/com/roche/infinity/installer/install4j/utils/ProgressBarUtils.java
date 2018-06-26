package com.roche.infinity.installer.install4j.utils;

import javax.swing.JProgressBar;
import com.install4j.api.context.Context;
import com.install4j.api.formcomponents.FormComponent;
import com.install4j.api.formcomponents.FormEnvironment;
import com.install4j.api.screens.FormPanelContainer;
import com.install4j.api.screens.Screen;

/**
 * All methods related to ProgressBar
 * 
 * @author jcamprec
 * @Date June 2018
 */
public class ProgressBarUtils {

	/**
	 * Default constructor
	 */
	public ProgressBarUtils() {
		
	}
	/**
	 * Updates the secondary Installation progress bar
	 * 
	 * @param context
	 * @param screenId
	 * @param componentId
	 * @param text
	 * @param toolTiptext
	 * @param installedComponentId
	 * @param indeterminate
	 * @param value
	 */
	public static void updateProgressBar(Context context, String screenId, String componentId, String text, String toolTiptext, String installedComponentId, boolean indeterminate, Integer numComponent, Integer totalComponents) {
		Screen otherScreen = context.getScreenById(screenId);

		FormEnvironment otherFormEnvironment = ((FormPanelContainer)otherScreen).getFormEnvironment();
		FormComponent component2 = otherFormEnvironment.getFormComponentById(componentId);
		JProgressBar prog = (JProgressBar)component2.getConfigurationObject();
				
		prog.setVisible(true);
		if (indeterminate)
			prog.setIndeterminate(true);
		else {	
			int percentage=0;
			if ((numComponent!=null) && (numComponent!=0)) {
				Double percen = ((double)(numComponent.intValue()) / totalComponents.intValue())*100;
				percentage = percen.intValue();
			}
						
			prog.setValue(percentage);
		}
		String textProgressBar;
		if (totalComponents == null)
			textProgressBar = (installedComponentId != null) ? text + " " + installedComponentId:text;
		else
			textProgressBar = (installedComponentId != null) ? text + " " + installedComponentId+" ("+numComponent+" of "+totalComponents+")":text+" ("+numComponent+" of "+totalComponents+")";
		prog.setString(textProgressBar);
		prog.setToolTipText(toolTiptext);
		
		prog.setStringPainted(true);
		prog.updateUI();
		
	}
	
	/**
	 * Updates the main installation progress bar
	 * 
	 * @param context
	 * @param text
	 */
	public static void updateInstallationProgressBar(Context context, String text) {
		context.getProgressInterface().setStatusMessage(context.getMessage(text));
	}
}
