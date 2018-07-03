package com.roche.infinity.installer.install4j.report;

import java.util.Collection;
import org.json.simple.JSONObject;
import com.install4j.api.context.Context;
import com.install4j.api.context.InstallationComponentSetup;
 
/**
 * 
 * @author grebonfe
 * Generates the content of the report
 */
public class ReportGenerator {	
	
	public static final String ACTION= "Action";
	
	private ReportGenerator(){}    
    
	/**
	 * Generates the report
	 * @param context - install4j context 
	 * @param action - the action to be reported
	 */
	public static void generateReport(Context context, Action action) {
		Collection<InstallationComponentSetup> col = context.getInstallationComponents();
		for (InstallationComponentSetup comp:col) {
			if (comp.isSelected()) {
				addComponentToTheList(comp.getName(), action.toString());
			}
		}
	}

	/**
	 * Add JSONObjects to the JSONArray
	 * @param componentName - name of the component to save
	 * @param action - action type to save
	 */
    @SuppressWarnings("unchecked")
    static synchronized void addComponentToTheList(String componentName, String action){    	
    	 JSONObject jsonObject = new JSONObject();    
    	 jsonObject.put(ReportGenerator.ACTION, action);
    	         
         JSONObject jsonObjectPopulated = new JSONObject();
         jsonObjectPopulated.put(componentName, jsonObject);
    	
         ComponentList.getInstance().add(jsonObjectPopulated);   	
    }
}