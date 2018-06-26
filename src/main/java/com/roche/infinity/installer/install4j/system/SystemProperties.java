package com.roche.infinity.installer.install4j.system;

/**
 * 
 * @author grebonfe
 * Bean that represents the system properties
 */
public class SystemProperties {

	private String operatingSystemName;
	private String servicePack;
	private String operatingSystemArchitecture;
	private boolean isCompatible;
	
	/**
	 * @return the operatingSystemName
	 */
	public String getOperatingSystemName() {
		return operatingSystemName;
	}
	
	/**
	 * @param operatingSystemName the operatingSystemName to set
	 */
	public void setOperatingSystemName(String operatingSystemName) {
		this.operatingSystemName = operatingSystemName;
	}
	
	/**
	 * @return the servicePack
	 */
	public String getServicePack() {
		return servicePack;
	}
	
	/**
	 * @param servicePack the servicePack to set
	 */
	public void setServicePack(String servicePack) {
		this.servicePack = servicePack;
	}

	/**
	 * @return the isCompatible
	 */
	public boolean isCompatible() {
		return isCompatible;
	}

	/**
	 * @param isCompatible the isCompatible to set
	 */
	public void setCompatible(boolean isCompatible) {
		this.isCompatible = isCompatible;
	}

	/**
	 * @return the operatingSystemArchitecture
	 */
	public String getOperatingSystemArchitecture() {
		return operatingSystemArchitecture;
	}

	/**
	 * @param operatingSystemArchitecture the operatingSystemArchitecture to set
	 */
	public void setOperatingSystemArchitecture(String operatingSystemArchitecture) {
		this.operatingSystemArchitecture = operatingSystemArchitecture;
	}		
}