package com.roche.infinity.installer.install4j.report;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import com.roche.infinity.installer.install4j.utils.LoggerManager;

/**
 * @author grebonfe
 * Class used to write the report into a json file
 */
public class ReportWriter {

	private ReportWriter(){}
	
	/**
	 * Write the JSONArray into a JSON file
	 * @param jsonArray  - array with the component names and actions
	 * @param fileWriter - the destination file
	 */
	public static synchronized void writeJSON(JSONArray jsonArray, FileWriter fileWriter){		
	      try {
	    	  fileWriter.write(jsonArray.toJSONString());
	    	  fileWriter.flush();
	      } catch (IOException e) {
	    	  LoggerManager.getInstance(ReportWriter.class).
	    	  error(ReportWriter.class.getSimpleName(), "Error when  trying to save the installation report: " 
	    	  + e.getLocalizedMessage(), e);
	      }
	}    
}
