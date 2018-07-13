package com.roche.infinity.installer.install4j.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import com.install4j.api.context.Context;

/**
 * 
 * All methods related to files
 * @author jcamprec
 */
public class FileUtils {

	private static final String INFINITY_INSTALLER_INSTALL4J_LOG = "\\infinityInstallerInstall4j.log";
	private static final String LOGS = "\\logs\\";
	private static final String USER_HOME = "user.home";
	private static final String SYS_TEMP_DIR = "sys.tempDir";

	/**
	 * Default constructor
	 */
	public FileUtils() {}
	
	/**
	 * 
	 * @param file to be deleted
	 */
	public static void delete(File file) {
		if ((file!=null) && (file.exists())) {
		  if (file.isDirectory()) {
		    for (File c : file.listFiles())
		      delete(c);
		  }
		  if (!file.delete()) {
			  LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), "Failed to delete file: " +file);
		  }
		}
	}
	
	/**
	 * Copy Log File (infinityInstaller_%DATE)
	 * @param context - install4j context
	 */
	public static void copyLogFile(Context context) {
		File fIn = new File(((String)context.getVariable(SYS_TEMP_DIR)).concat(INFINITY_INSTALLER_INSTALL4J_LOG));
		if (fIn.exists()) {
			File fOut = new File (System.getProperty(USER_HOME).concat(LOGS).concat(getFileNameWithoutExtension(fIn).concat("_"+Utils.getFormattedCurrentDate())).concat(".log"));
			LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), "Log file copied to: " +fOut.getAbsolutePath());
			try {
				Files.copy(fIn.toPath(), fOut.toPath(), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				LoggerManager.getInstance(Utils.class).error(Utils.class.getSimpleName(), "Failed to copy log file: " +e.getLocalizedMessage(), e);
			}
		}
	}
	
	/**
	 * 
	 * @param file - the name of the file
	 * @return the name of the file without extension
	 */
	public static String getFileNameWithoutExtension(File file) {
        String fileName = "";
 
        try {
            if (file != null && file.exists()) {
                String name = file.getName();
                fileName = name.replaceFirst("[.][^.]+$", "");
            }
        } catch (Exception e) {
        	LoggerManager.getInstance(Utils.class).error(Utils.class.getSimpleName(), "Error getting filename without extension: " +e.getLocalizedMessage(), e);
            fileName = "";
        }
 
        return fileName; 
    }

	/**
	 * Creates a directory
	 * @param folder -  the name of the folder
	 * @return the result of the operation
	 */
	public static boolean createFolder(String folder) {
		File f=new File(folder);		
		if (!f.exists()) {
			if (f.mkdirs()) {
				LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), folder + " created successfully");
				return true;
			}
			else {
				LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), folder + " not created successfully");
				return false;
			}
		}
		LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), folder + " already exists");
		return true;
	}
	
	/**
	 * Creates a directory
	 * @param folder -  the name of the folder
	 * @return the result of the operation
	 */
	public static File createFolder2(String folder) {
		File f=new File(folder);		
		if (!f.exists()) {
			if (f.mkdirs()) {
				LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), folder + " created successfully");
				return f;
			}
			else {
				LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), folder + " not created successfully");
				return f;
			}
		}
		LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), folder + " already exists");
		return f;
	}
	
	/**
	 * Copy folder
	 * @param sourceFolder - the source of origin
	 * @param destinationFolder -  the source of destination
	 * @throws IOException - if the folder can not be copied
	 */
	public static void copyFolder(File sourceFolder, File destinationFolder) throws IOException {
		// Check if sourceFolder is a directory or file
		// If sourceFolder is file; then copy the file directly to new location
		if (sourceFolder.isDirectory()) {
			// Verify if destinationFolder is already present; If not then create it
			if (!destinationFolder.exists()) {
				destinationFolder.mkdir();
				LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), destinationFolder + " created successfully");
			}

			// Get all files from source directory
			String files[] = sourceFolder.list();

			// Iterate over all files and copy them to destinationFolder one by one
			for (String file : files) {
				File srcFile = new File(sourceFolder, file);
				File destFile = new File(destinationFolder, file);

				// Recursive function call
				copyFolder(srcFile, destFile);
			}

			LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(),
					"Folder " + sourceFolder + " copied successfully to :" + destinationFolder);			
		} else {
			// Copy the file content from one place to another
			Files.copy(sourceFolder.toPath(), destinationFolder.toPath(), StandardCopyOption.REPLACE_EXISTING);
			LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(),
					"File copied successfully to :" + destinationFolder);
		}
	}
	
	/**
	 * 
	 * @param dir - the folder to analyze
	 * @return the file size
	 */
	public static long getFolderSize(File dir) {
	    long size = 0;
	    for (File file : dir.listFiles()) {
	        if (file.isFile()) {
	            size += file.length();
	        }
	        else if (file.isDirectory())
	            size += getFolderSize(file);
	        else return 0;
	    }
	    return size;
	}
}
