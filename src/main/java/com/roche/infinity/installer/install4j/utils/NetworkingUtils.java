package com.roche.infinity.installer.install4j.utils;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @author jcamprec
 *
 */
public class NetworkingUtils {
	
	private NetworkingUtils(){}

	/**
	 * Finds an available port, starting from start port and checking up to startPort+numMaxPorts
	 * 
	 * @param startPort
	 * @return
	 */
	public static int getAvailablePort(int startPort, int numMaxPorts) {
		ServerSocket s=null;
		for (int port=startPort; port < startPort+numMaxPorts;port++) {
	        try {
	        	s = new ServerSocket(port);
				port = s.getLocalPort();
				s.close();
				LoggerManager.getInstance(NetworkingUtils.class).info(NetworkingUtils.class.getSimpleName(), "Set port: " + s.getLocalPort());
				//Util.logInfo(null, "Set port: " + s.getLocalPort());
				return port;
	        } catch (IOException ex) {
	            continue; // try next port
	        }
	    }

	    // if the program gets here, no port in the range was found
		LoggerManager.getInstance(NetworkingUtils.class).info(NetworkingUtils.class.getSimpleName(), "No free port found");
	    //Util.logInfo(null, "no free port found");
		return 0;
	}

	/**
	 * Finds an available port
	 * 
	 * @return
	 */
	public static int getAvailablePort() {
		int port=0;
		ServerSocket s=null;
		try {
			s = new ServerSocket(0);
			port=s.getLocalPort();
			
			LoggerManager.getInstance(NetworkingUtils.class).info(NetworkingUtils.class.getSimpleName(), "Set port: " + s.getLocalPort());
			s.close();
		} catch (IOException e) {
			LoggerManager.getInstance(NetworkingUtils.class).error(NetworkingUtils.class.getSimpleName(), e.getLocalizedMessage(), e);
		}
		
		return port;
	}
}
