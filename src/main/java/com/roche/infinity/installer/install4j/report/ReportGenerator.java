package com.roche.infinity.installer.install4j.report;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import com.roche.infinity.installer.install4j.utils.Utils;
 
/**
 * 
 * @author grebonfe
 * Generates the content of the report
 */
public class ReportGenerator {	
	
	public static final String ACTION= "Action";
	
	private ReportGenerator(){}
	
	/*
	//Only for testing purposes
	public static void main(String []args) throws IOException{	
	  	
	  //Component 1	         
      ReportGenerator.addComponentToTheList("Report Server", Action.INSTALL.toString());
      
      //Component 2	      
      ReportGenerator.addComponentToTheList("Healthshare", Action.INSTALL.toString()); 

      //TODO Replace the path (c:\\report\\) for a system  variable of install4j
	  ReportWriter.writeJSON(ComponentList.getInstance(), new FileWriter(new StringBuffer("c:\\report\\").
		      append(Utils.getFormattedCurrentDate()).append(".json").toString()));         
    }*/
    
    
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