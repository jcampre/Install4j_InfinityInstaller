package com.roche.infinity.installer.install4j.report;

import org.json.simple.JSONArray;

/**
 * 
 * @author grebonfe
 * Define a single instance for saving the report
 */
public class ComponentList {	

	   private static JSONArray components = null;
	   
	   private ComponentList() {}
	   
	   public static JSONArray getInstance() {
	      if(components == null) {
	    	  components = new JSONArray();
	      }
	      return components;
	   } 
}