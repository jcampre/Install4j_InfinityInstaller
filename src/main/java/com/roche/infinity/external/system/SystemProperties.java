package com.roche.infinity.external.system;

/**
 * 
 * @author grebonfe
 *
 */
public class SystemProperties {

	protected int numberOfProcessors;
	protected String architecture;
	protected String operatingSystem;
	protected String servicePack;
	
	/**
	 * @return the numberOfProcessors
	 */
	public static int getNumberOfProcessors() {
		return Runtime.getRuntime().availableProcessors();
	}
	
	/**
	 * @return the architecture
	 */
	public static String getArchitecture() {
		return System.getProperty("os.arch");
	}
	
	/**
	 * @return the operatingSystem
	 */
	public static String getOperatingSystem() {
		return System.getProperty("os.name");
	}
	
	/**
	 * @return the servicePack
	 */
	public static String getServicePack() {
		return System.getProperty("os.servicePack");
	}		
}
