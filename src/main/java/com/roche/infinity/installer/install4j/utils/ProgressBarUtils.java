package com.roche.infinity.installer.install4j.utils;

import javax.swing.JProgressBar;
import com.install4j.api.context.Context;
import com.install4j.api.formcomponents.FormComponent;
import com.install4j.api.formcomponents.FormEnvironment;
import com.install4j.api.screens.FormPanelContainer;
import com.install4j.api.screens.Screen;

/**
 * All methods related to ProgressBar 
 * @author jcamprec
 */
public class ProgressBarUtils {

	private static final String NUM_SELECTED_COMPONENTS = "numSelectedComponents";
	private static final String INSTALLATION_PROGRESS_BAR_ACTION = "installationProgressBarAction";
	private static final String INSTALLING_COMPONENT_ID = "installing_component_id";
	private static final String INSTALLING_COMPONENT_NAME = "installing_component_name";

	/**
	 * Default constructor
	 */
	public ProgressBarUtils() {
		
	}
	/**
	 * Updates the secondary Installation progress bar
	 * 
	 * @param context - the install4j context
	 * @param screenId - id of the screen
	 * @param componentId - id of the component
	 * @param text - text of the progress bar
	 * @param toolTiptext - toll tip text of the progress bar
	 * @param installedComponentId - id of the component installed
	 * @param indeterminate - progress bar type
	 * @param numComponent - number of the component
	 * @param totalComponents -  total number of components
	 */
	public static void updateProgressBar(Context context, String screenId, String componentId, String text,
			String toolTiptext, String installedComponentId,
			boolean indeterminate, Integer numComponent, Integer totalComponents) {
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
	 * @param context - install4j context
	 * @param text - text to be included on the progress bar
	 */
	public static void updateInstallationProgressBar(Context context, String text) {
		context.getProgressInterface().setStatusMessage(context.getMessage(text));
	}
	
	/**
	 * Updates the progress bar with description increasing component being installed
	 * 
	 * @param context - the install4j context
	 * @param screenId - the screen id
	 * @param componentName - the component name
	 * @param text - the text to show
	 * @param toolTiptext - the tool tip text
	 */
	public static void updateProgressBarAndIncreaseComponent(Context context, String screenId, String componentName, String text, String toolTiptext) {
		//update componentName
		ContextUtils.updateStringVariable(context, INSTALLING_COMPONENT_NAME, componentName);
		//update installing_component_id +1 
		ContextUtils.updateIntegerVariable(context, INSTALLING_COMPONENT_ID,(Integer)context.getVariable(INSTALLING_COMPONENT_ID) + 1);
		ProgressBarUtils.updateProgressBar(context, screenId, INSTALLATION_PROGRESS_BAR_ACTION, context.getMessage(text),
		context.getMessage(toolTiptext), (String)context.getVariable(INSTALLING_COMPONENT_NAME), false, (Integer)context.getVariable(INSTALLING_COMPONENT_ID), (Integer)context.getVariable(NUM_SELECTED_COMPONENTS));
		//update status of main progress bar
		ProgressBarUtils.updateInstallationProgressBar(context, text);
	}
	
	/**
	 * Updates the progress bar with description
	 * 
	 * @param context - the install4j context 
	 * @param screenId - screen id
	 * @param componentName -  component name
	 * @param text - the text of the progress bar
	 * @param toolTiptext -  the toll tip text of the progress bar
	 */
	public static void updateProgressBar(Context context, String screenId, String componentName, String text, String toolTiptext) {
		//update componentName
		ContextUtils.updateStringVariable(context, INSTALLING_COMPONENT_NAME, componentName);
		ProgressBarUtils.updateProgressBar(context, screenId, INSTALLATION_PROGRESS_BAR_ACTION, context.getMessage(text),
		context.getMessage(toolTiptext), (String)context.getVariable(INSTALLING_COMPONENT_NAME), false, (Integer)context.getVariable(INSTALLING_COMPONENT_ID), (Integer)context.getVariable(NUM_SELECTED_COMPONENTS));
		//update status of main progress bar
		ProgressBarUtils.updateInstallationProgressBar(context, text);
	}
}
