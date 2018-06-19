package com.roche.infinity.installer.install4j.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.swing.JProgressBar;
import com.install4j.api.context.Context;
import com.install4j.api.formcomponents.FormComponent;
import com.install4j.api.formcomponents.FormEnvironment;
import com.install4j.api.screens.FormPanelContainer;
import com.install4j.api.screens.Screen;
import com.roche.infinity.test.Utils.ZipUtilsExample;
import com.install4j.api.context.InstallationComponentSetup;

/**
 * @author jcamprec
 *
 *         Implements all generic methods used in Install4j
 */
public class Utils {

	private Utils() {
	}

	/**
	 * Updates the secondary Installation progress bar
	 * 
	 * @param context
	 * @param screenId
	 * @param componentId
	 * @param text
	 * @param toolTiptext
	 * @param installedComponentId
	 * @param indeterminate
	 * @param value
	 */
	public static void updateProgressBar(Context context, String screenId, String componentId, String text,
			String toolTiptext, String installedComponentId, boolean indeterminate, Integer numComponent,
			Integer totalComponents) {
		Screen otherScreen = context.getScreenById(screenId);

		FormEnvironment otherFormEnvironment = ((FormPanelContainer) otherScreen).getFormEnvironment();
		FormComponent component2 = otherFormEnvironment.getFormComponentById(componentId);
		JProgressBar prog = (JProgressBar) component2.getConfigurationObject();

		prog.setVisible(true);
		if (indeterminate)
			prog.setIndeterminate(true);
		else {
			int percentage = 0;
			if ((numComponent != null) && (numComponent != 0)) {
				Double percen = ((double) (numComponent.intValue()) / totalComponents.intValue()) * 100;
				percentage = percen.intValue();
			}

			prog.setValue(percentage);
		}
		String textProgressBar;
		if (totalComponents == null)
			textProgressBar = (installedComponentId != null) ? text + " " + installedComponentId : text;
		else
			textProgressBar = (installedComponentId != null)
					? text + " " + installedComponentId + " (" + numComponent + " of " + totalComponents + ")"
					: text + " (" + numComponent + " of " + totalComponents + ")";
		prog.setString(textProgressBar);
		prog.setToolTipText(textProgressBar);

		prog.setStringPainted(true);
		prog.updateUI();

	}

	/**
	 * Updates the main installation progress bar
	 * 
	 * @param context
	 * @param text
	 */
	public static void updateInstallationProgressBar(Context context, String text) {
		context.getProgressInterface().setStatusMessage(context.getMessage(text));
	}

	/**
	 * Updates String context variable
	 * 
	 * @param context
	 * @param variableName
	 * @param newValue
	 */

	public static void updateStringVariable(Context context, String variableName, String newValue) {
		context.setVariable(variableName, newValue);
	}

	/**
	 * Updates Integer context variable
	 * 
	 * @param context
	 * @param variableName
	 * @param newValue
	 */
	public static void updateIntegerVariable(Context context, String variableName, int newValue) {
		context.setVariable(variableName, newValue);
	}

	/**
	 * return all selected components to be installed
	 * 
	 * @param context
	 * @return
	 */
	public static int getSelectedComponents(Context context) {
		Collection<InstallationComponentSetup> col = context.getInstallationComponents();
		int i = 0;
		Iterator<InstallationComponentSetup> it = col.iterator();
		while (it.hasNext()) {
			InstallationComponentSetup comp = it.next();
			if (comp.isSelected())
				i++;
		}

		return i;
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
		LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(),
				"Setting all components to be installed.");
		while (it.hasNext()) {
			InstallationComponentSetup comp = it.next();
			comp.setSelected(true);
			LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(),
					"Component: " + comp.getName() + " checked for installation.");
		}
	}

	/**
	 * Calculate all required disk space considering all selected components to be
	 * installed
	 * 
	 * @param context
	 * @return
	 */
	public static String getComponentRequiredDiskSpaceForSelectedComponents(Context context) {
		Collection<InstallationComponentSetup> col = context.getInstallationComponents();
		long diskSpace = 0;
		Iterator<InstallationComponentSetup> it = col.iterator();
		while (it.hasNext()) {
			InstallationComponentSetup comp = it.next();
			if (comp.isSelected()) {
				// only if value (disk space required) defined for that selected component
				if (context.getCompilerVariable(comp.getId() + "DiskSpace") != null)
					diskSpace = diskSpace + (Integer.valueOf(context.getCompilerVariable(comp.getId() + "DiskSpace")));
			}
		}

		return String.valueOf(diskSpace);
	}

	/**
	 * 
	 * @param context
	 * @param requiredSpaceDisk
	 * @return
	 */
	public static String isMBorGB(Context context, Double requiredSpaceDisk) {

		if (requiredSpaceDisk < 1000)
			return "MB";
		else {
			context.setVariable("selectedComponentsRequiredSpaceDisk", String.valueOf(requiredSpaceDisk / 1000));
			LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(),
					"Required installation disk space changed to GB.");
			return "GB";
		}
	}

	/**
	 * Return the current date with this format: MM-dd-yyyy hh:mm:ss
	 * 
	 * @return
	 */
	public static String getFormattedCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy-hhmmss");
		return sdf.format(new Date());
	}

	/**
	 * Return the current date with this format: MM-dd-yyyy hh:mm:ss
	 * 
	 * @return
	 */
	public static String getFormattedCurrentDate(String formatDate) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatDate);
		return sdf.format(new Date());
	}

	/**
	 * Return the current date with this format: MM-dd-yyyy hh:mm:ss
	 * 
	 * @return
	 */
	public static String getFormattedDate(Date d, String formatDate) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatDate);
		return sdf.format(d);

	}

	/**
	 * 
	 * @param f
	 */
	public static void delete(File f) {
		if (f.isDirectory()) {
			for (File c : f.listFiles())
				delete(c);
		}
		if (!f.delete()) {
			LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), "Failed to delete file: " + f);
		}
	}

	/**
	 * Copy Log File (infinityInstaller_%DATE)
	 */
	public static void copyLogFile(Context context) {
		File fIn = new File(((String) context.getVariable("sys.tempDir")).concat("\\infinityInstallerInstall4j.log"));
		if (fIn.exists()) {
			File fOut = new File(System.getProperty("user.home").concat("\\logs\\")
					.concat(Utils.getFileNameWithoutExtension(fIn).concat("_" + Utils.getFormattedCurrentDate()))
					.concat(".log"));
			LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(),
					"Log file copied to: " + fOut.getAbsolutePath());
			try {
				Files.copy(fIn.toPath(), fOut.toPath(), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				LoggerManager.getInstance(Utils.class).error(Utils.class.getSimpleName(),
						"Failed to copy log file: " + e.getLocalizedMessage(), e);
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
			LoggerManager.getInstance(Utils.class).error(Utils.class.getSimpleName(),
					"Error getting filename without extension: " + e.getLocalizedMessage(), e);
			fileName = "";
		}

		return fileName;
	}

	/**
	 * Creates a directory
	 * 
	 * @param folder
	 */
	public static void createFolder(String folder) {
		File f = new File(folder);
		if (!f.exists())
			if (f.mkdirs())
				LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(),
						folder + " created successfully");
			else
				LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(),
						folder + " not created successfully");
	}

	/**
	 * Checks the status of a windows service
	 * 
	 * @param serviceName
	 * @return -1: Unknow error 0 : Service not installed 1: service running 2:
	 *         service stopped
	 */
	public static int checkService(String serviceName) {
		try {
			Process process = new ProcessBuilder("C:\\Windows\\System32\\sc.exe", "query", serviceName).start();
			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			String line;
			String scOutput = "";

			// Append the buffer lines into one string
			while ((line = br.readLine()) != null) {
				scOutput += line + "\n";
			}

			if (scOutput.contains("STATE")) {
				if (scOutput.contains("RUNNING")) {
					LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), serviceName + " running");
					return 2;
				} else {
					LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), serviceName + " stopped");
					return 1;
				}
			} else {
				LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(),
						serviceName + " not installed");
				return 0;
			}
		} catch (IOException e) {
			LoggerManager.getInstance(Utils.class).error(Utils.class.getSimpleName(),
					"Unknown error checking if " + serviceName + " is installed. " + e.getLocalizedMessage(), e);
			return -1;
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

			LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(),
					"Installed version " + installedVersion);
			LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(),
					"Version to be upgraded to " + newVersion);

			return newVersionLong > installedVersionLong;
		} catch (Exception e) {
			LoggerManager.getInstance(Utils.class).error(Utils.class.getSimpleName(),
					"checkLowerVersion " + e.getLocalizedMessage(), e);
			return false;
		}
	}

	/**
	 * 
	 * @return
	 */
	public static File getLatestHealthShareBackup(Context context) {

		LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(),
				"Folder backup --> " + (String) context.getVariable("backupFolder"));
		File file = new File((String) context.getVariable("backupFolder"));
		if (!file.exists()) {
			LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(),
					(String) context.getVariable("backupFolder") + " does not exist.");
			return null;
		}

		File[] files = file.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				if (name.toLowerCase().endsWith(".dat"))
					return true;

				return false;

			}
		});

		Arrays.sort(files);
		return (files.length > 0) ? files[0] : null;
	}

	public static void copyFolder(File sourceFolder, File destinationFolder) throws IOException {
		// Check if sourceFolder is a directory or file
		// If sourceFolder is file; then copy the file directly to new location
		if (sourceFolder.isDirectory()) {
			// Verify if destinationFolder is already present; If not then create it
			if (!destinationFolder.exists()) {
				destinationFolder.mkdir();
				System.out.println("Directory created :: " + destinationFolder);
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
					"Folder " + sourceFolder + " copied successfully to ::" + destinationFolder);
		} else {
			// Copy the file content from one place to another
			Files.copy(sourceFolder.toPath(), destinationFolder.toPath(), StandardCopyOption.REPLACE_EXISTING);
			// System.out.println("File copied :: " + destinationFolder);
			LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(),
					"File copied successfully to ::" + destinationFolder);
		}
	}
}
