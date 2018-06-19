package com.roche.infinity.installer.install4j.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.install4j.api.Util;

/**
 * Logger Manager for custom logs
 * @author Jordi Campreciós
 * @Date June 2018
 *
 */
public class LoggerManager {
	
	private static LoggerManager instance = null;
    protected static Logger log4j;

    private LoggerManager() {
        super();
    }

    public static LoggerManager getInstance(Class<?> className){
        if(instance  == null){
            instance  = new LoggerManager();
        }
        log4j = LogManager.getLogger(className);
        return instance;
    }

    public void info(String myclass, String msg) {
    	String message="[" + myclass + "] " + msg;
    	Util.logInfo(null, message) ;
    	log4j.info(message);

    }

    public void error(String myclass, String msg, Exception ce) {
    	String message="[" + myclass + "] " + msg;
    	Util.logError(null, message) ;        
    	log4j.error(message, ce);      
    }

    public void warning(String myclass, String msg) {
    	String message="[" + myclass + "] " + msg;
    	Util.logInfo(null, message) ;
    	log4j.warn(message);
    }    
}
