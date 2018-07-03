/**
 * 
 */
package com.roche.infinity.installer.install4j.utils;

import org.springframework.util.SocketUtils;

/**
 * @author grebonfe
 * 
 */
public class NetworkingUtils {
	
	public static int maxPorts = 1000;
	
	private NetworkingUtils(){}
	
	/**
	 * Finds an available port
	 * @return the available port
	 */
	public static int getAvailablePort(){
		return SocketUtils.findAvailableTcpPort();
	}

	/**
	 * Finds an available port, starting from start port and checking up to startPort+numMaxPorts
	 * @param minPort - the minimum port number 
	 * @param maxPort - the maximum port number
	 * @return the available port between the range
	 */
	public static int getAvailablePort(int minPort, int maxPort){
		return SocketUtils.findAvailableTcpPort(minPort, maxPort);	
	}	
}
