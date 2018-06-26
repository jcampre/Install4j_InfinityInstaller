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
 * @Date June 2018
 */
public class FileUtils {

	/**
	 * Default constructor
	 */
	public FileUtils() {}
	
	/**
	 * 
	 * @param f
	 */
	public static void delete(File f) {
		if ((f!=null) && (f.exists())) {
		  if (f.isDirectory()) {
		    for (File c : f.listFiles())
		      delete(c);
		  }
		  if (!f.delete()) {
			  LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), "Failed to delete file: " +f);
		  }
		}
	}
	
	/**
	 * Copy Log File (infinityInstaller_%DATE)
	 */
	public static void copyLogFile(Context context) {
		File fIn = new File(((String)context.getVariable("sys.tempDir")).concat("\\infinityInstallerInstall4j.log"));
		if (fIn.exists()) {
			File fOut = new File (System.getProperty("user.home").concat("\\logs\\").concat(getFileNameWithoutExtension(fIn).concat("_"+Utils.getFormattedCurrentDate())).concat(".log"));
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
	 * @param file
	 * @return
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
	 * @param folder
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
	 * Copy folder
	 * @param sourceFolder
	 * @param destinationFolder
	 * @throws IOException
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
	 * @param dir
	 * @return
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
