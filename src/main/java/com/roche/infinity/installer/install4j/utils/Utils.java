package com.roche.infinity.installer.install4j.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import com.install4j.api.context.Context;
import com.install4j.api.context.InstallationComponentSetup;

/**
 * @author jcamprec
 *
 * Implements all generic methods used in Install4j
 */
public class Utils {
	
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
	
	private Utils(){}
		
	/**
	 * return all selected components to be installed
	 * 
	 * @param context
	 * @return
	 */
	public static int getSelectedComponents(Context context) {
		Collection<InstallationComponentSetup> col = context.getInstallationComponents();
		int i=0;
		Iterator<InstallationComponentSetup> it = col.iterator(); 
		while (it.hasNext()){
		    InstallationComponentSetup comp = it.next();
		    if (comp.isSelected())            
		        i++;
		}

		return i;
	}
	
	/**
	 * return all components in the fileset
	 * 
	 * @param context
	 * @return
	 */
	public static int getAllComponents(Context context) {
		Collection<InstallationComponentSetup> col = context.getInstallationComponents();
		if (col != null)
			return col.size();
		
		return 0;
	}
	
	/**
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isAllComponentsSelected(Context context) {
		return getAllComponents(context) == getSelectedComponents(context);
	}
	/**
	 * return all selected components to be installed
	 * 
	 * @param context
	 * @return
	 */
	public static void setAllComponentsSelected(Context context) {
		Collection<InstallationComponentSetup> col = context.getInstallationComponents();
		Iterator<InstallationComponentSetup> it = col.iterator();
		LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), "Setting all components to be installed.");
		while (it.hasNext()){
		    InstallationComponentSetup comp = it.next();
		    comp.setSelected(true);
		    LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), "Component: " + comp.getName() +" checked for installation.");
		}
	}
	
	/**
	 * Calculate all required disk space considering all selected components to be installed
	 * 
	 * @param context
	 * @return
	 */
	public static String getComponentRequiredDiskSpaceForSelectedComponents(Context context) {
		Collection<InstallationComponentSetup> col = context.getInstallationComponents();
		long diskSpace=0;
		Iterator<InstallationComponentSetup> it = col.iterator(); 
		while (it.hasNext()){
		    InstallationComponentSetup comp = it.next();
		    if (comp.isSelected()) {
		    	//only if value (disk space required) defined for that selected component
		    	if (context.getCompilerVariable(comp.getId()+"DiskSpace") != null)
		    		diskSpace = diskSpace+(Integer.valueOf(context.getCompilerVariable(comp.getId()+"DiskSpace")));
		    }
		}
		
		return String.valueOf(diskSpace);
	}
	
	
	
	/**
	 * Return the current date with this format: MM-dd-yyyy hh:mm:ss
	 * @return
	 */
	public static String getFormattedCurrentDate(){
	     SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
	     return sdf.format(new Date());
	}
	
	/**
	 * Return the current date with any format passed as parameter
	 * @return
	 */
	public static String getFormattedCurrentDate(String formatDate){
	     SimpleDateFormat sdf = new SimpleDateFormat(formatDate);
	     return sdf.format(new Date());
	}
	
	/**
	 * Return the date with this format: MM-dd-yyyy hh:mm:ss
	 * @return
	 */
	public static String getFormattedDate(Date d, String formatDate){
	     SimpleDateFormat sdf = new SimpleDateFormat(formatDate);	     
	     return sdf.format(d);
	     
	}	
	
	/**
	 * Checks the status of a windows service 
	 * @param serviceName
	 * @return
	 * -1: Unknow error
	 * 0 : Service not installed
	 * 1: service running
	 * 2: service stopped
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
	
	public static void stopTomcatService(Context context, String serviceName, String servicePath) {
		try {
			ProcessBuilder process = new ProcessBuilder(servicePath,STOP_TOMCAT_SERVICE, serviceName);			
			Map<String,String> env =  process.environment();
			env.put(JAVA_HOME, (String)context.getVariable(JAVA_DIRECTORY)+LINE_SEPARATOR+"jdk1.8.0_101");
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
	
	public static void uninstallTomcatService(Context context, String serviceName, String servicePath) {
		
		try {
			ProcessBuilder process = new ProcessBuilder(servicePath,UNINSTALL_TOMCAT_SERVICE, serviceName);			
			Map<String,String> env =  process.environment();
			env.put(JAVA_HOME, (String)context.getVariable(JAVA_DIRECTORY)+LINE_SEPARATOR+"jdk1.8.0_101");
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
	 * checks if version to be installed is newer than the version already installed
	 *  
	 * @param context
	 * @param installedVersion
	 * @param newVersion
	 * @return
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
	 * 
	 * @return
	 */
	public static File getLatestHealthShareBackup(Context context) {
		File file = new File((String)context.getVariable("backupFolder"));
		if (!file.exists()) {
			LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), (String)context.getVariable("backupFolder") + " does not exist.");
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
