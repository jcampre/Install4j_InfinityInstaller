package com.roche.infinity.installer.install4j.report;

import org.json.simple.JSONObject;
 
/**
 * 
 * @author grebonfe
 * Generates the content of the report
 */
public class ReportGenerator {	
	
	public static final String ACTION= "Action";
	
	private ReportGenerator(){}    
    
    /**
     * Add JSONObjects to the JSONArray
     * @param jsonObject
     */
    @SuppressWarnings("unchecked")
    public static synchronized void addComponentToTheList(String componentName, String action){    	
    	 JSONObject jsonObject = new JSONObject();    
    	 jsonObject.put(ReportGenerator.ACTION, action);
    	         
         JSONObject jsonObjectPopulated = new JSONObject();
         jsonObjectPopulated.put(componentName, jsonObject);
    	
         ComponentList.getInstance().add(jsonObjectPopulated);   	
    }  
 
}