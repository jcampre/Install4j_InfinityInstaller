package com.roche.infinity.installer.install4j.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import com.install4j.api.context.Context;

/**
 * @author jcamprec
 *
 * Implements all generic methods used in Install4j
 */
public class Utils {

	
	private static final String FORMAT_2_DECIMALS = "%.2f";
	private static final String JDK1_8_0_101 = "jdk1.8.0_101";
	private static final String BACKUP_BIN_FOLDER = "backup_binFolder";
	private static final String DATE_TIME_FORMAT = "MM-dd-yyyy-hhmmss";
	private static final String BACKUP_EXT = ".dat";
	private static final String UNINSTALL_TOMCAT_SERVICE = "uninstall";
	private static final String STOP_TOMCAT_SERVICE = "stop";
	private static final String LINE_SEPARATOR = "\\";
	private static final String CATALINA_HOME = "CATALINA_HOME";
	private static final String JAVA_HOME = "JAVA_HOME";
	private static final String JAVA_DIRECTORY = "java_directory";
	private static final String TOMCAT_DIRECTORY = "tomcat_directory";	
	private static final String SC_RUNNING = "RUNNING";
	private static final String SC_STATE = "STATE";
	private static final String SC_QUERY = "query";
	private static final String C_WINDOWS_SYSTEM32_SC_EXE = "C:\\Windows\\System32\\sc.exe";	
	
	private static final String GB = "GB";
	private static final String MB = "MB";
	private static final long  BYTE = 1024L;
	
	//List that will hold already installed components. Loaded when program starts
	private static ArrayList<String> installedComponents = new ArrayList<String>();
	
	private Utils(){}
	
	
	
	/**
	 * Return the current date with this format: MM-dd-yyyy hh:mm:ss
	 * @return the date with format 
	 */
	public static String getFormattedCurrentDate(){
	     SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
	     return sdf.format(new Date());
	}
	
	/**
	 * Return the current date with any format passed as parameter
	 * @param formatDate the date format
	 * @return the date with format
	 */
	public static String getFormattedCurrentDate(String formatDate){
	     SimpleDateFormat sdf = new SimpleDateFormat(formatDate);
	     return sdf.format(new Date());
	}
	
	/**
	 * Return the date with this format: MM-dd-yyyy hh:mm:ss
	 * @param formatDate - the date format
	 * @param date - the date 
	 * @return the date  with format
	 */
	public static String getFormattedDate(Date date, String formatDate){
	     SimpleDateFormat sdf = new SimpleDateFormat(formatDate);	     
	     return sdf.format(date);
	     
	}	
	
	/**
	 * Return a string formatted with 2 decimals
	 * @param str input string
	 * @return the string formatted
	 */
	public static String formatString2Decimals(String str) {
		Double d = Double.valueOf(str);		
		return String.format(FORMAT_2_DECIMALS, d);
	}
	
	/**
	 * 
	 * @param requiredSpaceDisk - the disk space required
	 * @return the required space unit unit of measurement
	 */
	public static String isMBorGB(Double requiredSpaceDisk) {
		
		if (requiredSpaceDisk < BYTE)
		    return MB;
		else {
		    return GB;
		}
	}
	
	/**
	 * 
	 * @param requiredSpaceDisk - the disk space required
	 * @return the required space formatted as MB or GB
	 */
	public static String getDiskSpaceAsMBorGB(Double requiredSpaceDisk) {
		
		if (requiredSpaceDisk < BYTE)
		    return String.valueOf(requiredSpaceDisk);
		else {		    
		    return String.valueOf(requiredSpaceDisk/BYTE);
		}
	}
	
	/**
	 * Checks the status of a windows service 
	 * @param serviceName -the name of the service to check
	 * @return the status
	 * -1: Unknown error
	 *  0: Service not installed
	 *  1: service running
	 *  2: service stopped
	 */
	public static int checkService(String serviceName) {
		try {
			Process process = new ProcessBuilder(C_WINDOWS_SYSTEM32_SC_EXE, SC_QUERY , serviceName ).start();
		    InputStream is = process.getInputStream();
		    InputStreamReader isr = new InputStreamReader(is);
		    BufferedReader br = new BufferedReader(isr);

		    String line;
		    String scOutput = "";
		    
		    // Append the buffer lines into one string
		    while ((line = br.readLine()) != null) {
		        scOutput +=  line + "\n" ;		       
		    }		    
		    if (scOutput.contains(SC_STATE)) {
		        if (scOutput.contains(SC_RUNNING)) {
		            LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), serviceName + " running");
		            return 2;
		        } else {
		        	LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), serviceName + " stopped");
		            return 1;
		        }       
		    } else {
		    	LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), serviceName + " not installed");
		        return 0;
		    }
		  } catch (IOException e) {
		    LoggerManager.getInstance(Utils.class).error(Utils.class.getSimpleName(), "Unknown error checking if " + serviceName + " is installed. " +e.getLocalizedMessage(), e);
		    return -1;
		  } 
	}
	
	/**
	 * Stop the service of tomcat
	 * @param context - the install4j context
	 * @param serviceName -  the service name
	 * @param servicePath -  the service path
	 */
	public static void stopTomcatService(Context context, String serviceName, String servicePath) {
		try {
			ProcessBuilder process = new ProcessBuilder(servicePath,STOP_TOMCAT_SERVICE, serviceName);			
			Map<String,String> env =  process.environment();
			env.put(JAVA_HOME, (String)context.getVariable(JAVA_DIRECTORY)+LINE_SEPARATOR+JDK1_8_0_101);
			env.put(CATALINA_HOME, (String)context.getVariable(TOMCAT_DIRECTORY));
			Process pb = process.start();
			BufferedReader reader = 
	                new BufferedReader(new InputStreamReader(pb.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String line = null;
			while ( (line = reader.readLine()) != null) {
			   builder.append(line);
			   builder.append(LINE_SEPARATOR);
			}
			String result = builder.toString();
			pb.waitFor();
		    pb.destroy();
			LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), "Stopping " + serviceName + " with a result:"+result);
		} catch (IOException e) {
			LoggerManager.getInstance(Utils.class).error(Utils.class.getSimpleName(), serviceName + " cannot be stopped. Error " + e.getLocalizedMessage(), e);
		} catch (InterruptedException e) {
			LoggerManager.getInstance(Utils.class).error(Utils.class.getSimpleName(), serviceName + " cannot be uninstalled. Error " + e.getLocalizedMessage(), e);
		}
	}

	/**
	 * Uninstall the tomcat service
	 * @param context - the install4j context
	 * @param serviceName - the service name
	 * @param servicePath - the service path
	 */
	public static void uninstallTomcatService(Context context, String serviceName, String servicePath) {
		
		try {
			ProcessBuilder process = new ProcessBuilder(servicePath,UNINSTALL_TOMCAT_SERVICE, serviceName);			
			Map<String,String> env =  process.environment();
			env.put(JAVA_HOME, (String)context.getVariable(JAVA_DIRECTORY)+LINE_SEPARATOR+JDK1_8_0_101);
			env.put(CATALINA_HOME, (String)context.getVariable(TOMCAT_DIRECTORY));
			Process pb = process.start();
			BufferedReader reader = 
	                new BufferedReader(new InputStreamReader(pb.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String line = null;
			while ( (line = reader.readLine()) != null) {
			   builder.append(line);
			   builder.append(LINE_SEPARATOR);
			}
			String result = builder.toString();
			pb.waitFor();
		    pb.destroy();
			LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), "uninstalling " + serviceName + " with a result:"+result);
		} catch (IOException e) {
			LoggerManager.getInstance(Utils.class).error(Utils.class.getSimpleName(), serviceName + " cannot be uninstalled. Error " + e.getLocalizedMessage(), e);
		} catch (InterruptedException e) {
			LoggerManager.getInstance(Utils.class).error(Utils.class.getSimpleName(), serviceName + " cannot be uninstalled. Error " + e.getLocalizedMessage(), e);
		}
	}
	
	/**
	 * Checks if version to be installed is newer than the version already installed
	 *  
	 * @param installedVersion -  the installed version
	 * @param newVersion -  the new version
	 * @return - the result of the check
	 */
	public static boolean checkLowerVersion(String installedVersion, String newVersion) {
				
		try {
			Long installedVersionLong = Long.valueOf(String.join("", installedVersion.split("\\.")));
			Long newVersionLong = Long.valueOf(String.join("", newVersion.split("\\.")));
			
			LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), "Installed version " + installedVersion);
			LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), "Version to be upgraded to " + newVersion);
			
			return newVersionLong > installedVersionLong;
		}
		catch(Exception e) {
			LoggerManager.getInstance(Utils.class).error(Utils.class.getSimpleName(), "checkLowerVersion " +e.getLocalizedMessage(), e);
			return false;
		}
	}
	
	/**
	 * Get the latest HealthShare backup
	 * @param context -  the install4j context
	 * @return File - the file with the backup	 
	 */
	public static File getLatestHealthShareBackup(Context context) {
		File file = new File((String)context.getVariable("backupFolder"));
		if (!file.exists()) {
			LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), (String)context.getVariable(BACKUP_BIN_FOLDER) + " does not exist.");
			return null;
		}
			
        
		File[] files = file.listFiles(new FilenameFilter() {
             
            @Override
            public boolean accept(File dir, String name) {
                if (name.toLowerCase().endsWith(BACKUP_EXT))
                    return true;
                
                return false;
                
            }
        });
        
        Arrays.sort(files, new Comparator<File>(){
            public int compare(File f1, File f2)
            {
                return Long.valueOf(f1.lastModified()).compareTo(f2.lastModified());
            } });
		return (files.length>0) ? files[0]:null;
	}
}