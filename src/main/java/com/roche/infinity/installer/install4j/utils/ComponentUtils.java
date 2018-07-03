package com.roche.infinity.installer.install4j.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import com.install4j.api.context.Context;
import com.install4j.api.context.InstallationComponentSetup;

/**
 * 
 * All operations with install4j.Context
 * @author jcamprec 
 */
public class ComponentUtils {
	
	private static final String RESPONSE_FILE_LOCATION = "\\.install4j\\response.varfile";
	private static final String SYS_INSTALLATION_DIR = "sys.installationDir";
	private static final String SYS_COMPONENT = "sys.component.";
	private static final String DISK_SPACE = "DiskSpace";
	
	//List that will hold already installed components. Loaded when program starts
	private static ArrayList<String> installedComponents = new ArrayList<String>();
	
	/**
	 * Default constructor
	 */
	public ComponentUtils() {}
	
	/**
	 * Initialize array list with already installed components
	 *
	 * @param context - install4j context
	 */
	public static void setInstalledComponentsList(Context context) {
		installedComponents = new ArrayList<>();
		File respFile = new File((String)context.getVariable(SYS_INSTALLATION_DIR)+RESPONSE_FILE_LOCATION);			
		if (respFile.exists()) {
			Collection<InstallationComponentSetup> col = context.getInstallationComponents();				
			for (InstallationComponentSetup comp:col) {
				if (context.getBooleanVariable(SYS_COMPONENT+comp.getId())) {
					installedComponents.add(comp.getId());
				}
			}
		}
	}
	
	/**
	 * return all selected components to be installed
	 * 
	 * @param context - install4j context
	 * @return the quantity of components
	 */
	public static int getSelectedComponents(Context context) {
		Collection<InstallationComponentSetup> col = context.getInstallationComponents();
		int i=0;
		for (InstallationComponentSetup comp:col) {
		    if (comp.isSelected() && (!isComponentInstalled(context, comp.getId())))            
		        i++;
		}

		return i;
	}
	
	/**
	 * return all components in the fileset
	 * 
	 * @param context - install4j context
	 * @return the quantity of components
	 */
	public static int getAllComponents(Context context) {
		Collection<InstallationComponentSetup> col = context.getInstallationComponents();
		if (col != null)
			return col.size();
		
		return 0;
	}
	
	/**
	 * 
	 * @param context - install4j context
	 * @return flag to determine if all the components are selected
	 */
	public static boolean isAllComponentsSelected(Context context) {
		return getAllComponents(context) == getSelectedAndInstalledComponents(context);
	}
	
	/**
	 * Returns all components already installed and the ones that will be installed
	 * @param context - install4j context
	 * @return all components installed and to be installed
	 */
	private static int getSelectedAndInstalledComponents(Context context) {
		Collection<InstallationComponentSetup> col = context.getInstallationComponents();
		int i=0;		
		for (InstallationComponentSetup comp:col) {
		    if (comp.isSelected())            
		        i++;
		}

		return i;
	}

	/**
	 * return all selected components to be installed
	 * 
	 * @param context - install4j context
	 */
	public static void setAllComponentsSelected(Context context) {
		Collection<InstallationComponentSetup> col = context.getInstallationComponents();
		LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), "Setting all components to be installed.");
		for (InstallationComponentSetup comp:col) {
		    comp.setSelected(true);
		    LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), "Component: " + comp.getName() +" checked for installation.");
		}
	}
	
	/**
	 * Calculate all required disk space considering all selected components to be installed
	 * 
	 * @param context - insstall4j context
	 * @return the components required disk space 
	 */
	public static String getComponentRequiredDiskSpaceForSelectedComponents(Context context) {
		Collection<InstallationComponentSetup> col = context.getInstallationComponents();
		long diskSpace=0;
		for (InstallationComponentSetup comp:col) {		    
		    if (comp.isSelected() && (!isComponentInstalled(context, comp.getId()))) {
		    	//only if value (disk space required) defined for that selected component
		    	if (context.getCompilerVariable(comp.getId()+DISK_SPACE) != null)
		    		diskSpace = diskSpace+(Integer.valueOf(context.getCompilerVariable(comp.getId()+DISK_SPACE)));
		    }
		}

		return String.valueOf(diskSpace);
	}
	
	/**
	 * if component is already installed, sets it as no changeable and selected
	 * @param context - insstall4j context
	 */
	public static void disableInstalledComponents(Context context) {
		Boolean isComponentInstalled = false;
		Collection<InstallationComponentSetup> col = context.getInstallationComponents();
		for (InstallationComponentSetup comp:col) {			
			//check if component already installed
			isComponentInstalled = isComponentInstalled(context, comp.getId());
			if (isComponentInstalled) {				
				comp.setSelected(true);
				comp.setChangeable(false);
			}
		}
	}
	
	/**
	 * Returns if component is already installed
	 * @param context - insstall4j context
	 * @param compId - the componentId
	 * @return true if component already installed 
	 */
	public static boolean isComponentInstalled(Context context, String compId) {
		
		for (String s:installedComponents) {
			if (s.trim().equalsIgnoreCase(compId))
				return true;
		}
		return false;
	}
	
	/**
	 * checks that at least one component is selected to install
	 * 
	 * @param context - insstall4j context
	 * 
	 * @return true if at least one component selected 
	 */
	public static boolean isAnythingToInstall(Context context) {
		Collection<InstallationComponentSetup> col = context.getInstallationComponents();
		for (InstallationComponentSetup comp:col) {
			if ((comp.isSelected()) && (!isComponentInstalled(context, comp.getId())))
				return true;
		}
		return false;
	}
}
