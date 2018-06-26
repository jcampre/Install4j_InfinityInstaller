/**
 * 
 */
package com.roche.infinity.installer.install4j.utils;

import org.springframework.util.SocketUtils;

/**
 * @author grebonfe
 * 
 */
public class NetworkingUtils_NEWSPRING {
	
	/**
	 * Finds an available port
	 * @return
	 */
	public static int getAvailableTCPPort(){
		return SocketUtils.findAvailableTcpPort();
	}

	/**
	 * Finds an available port, starting from start port and checking up to startPort+numMaxPorts
	 * @param minPort
	 * @param maxPort
	 * @return
	 */
	public static int getAvailableTCPPort(int minPort, int maxPort){
		return SocketUtils.findAvailableTcpPort(minPort, maxPort);	
	}	
}
