package com.roche.infinity.installer.install4j.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.install4j.api.Util;

/**
 * Logger Manager for custom logs
 * @author Jordi Camprecios
 *
 */
public class LoggerManager {
	
	private static LoggerManager instance = null;
    protected static Logger log4j;

    private LoggerManager() {
        super();
    }

    /**
     * 
     * @param className - the name of the class where the log is used
     * @return LoggerManager
     */
    public static LoggerManager getInstance(Class<?> className){
        if(instance  == null){
            instance  = new LoggerManager();
        }
        log4j = LogManager.getLogger(className);
        return instance;
    }

    /**
     * 
     * @param myclass - the name of the class where the log is used
     * @param msg - the message to include on the log
     */
    public void info(String myclass, String msg) {
    	String message="[" + myclass + "] " + msg;
    	Util.logInfo(null, message) ;
    	log4j.info(message);

    }

    /**
     * 
     * @param myclass - the name of the class where the log is used 
     * @param msg - the message to include on the log
     * @param ce - exception
     */
    public void error(String myclass, String msg, Exception ce) {
    	String message="[" + myclass + "] " + msg;
    	Util.logError(null, message) ;        
    	log4j.error(message, ce);      
    }

    /**
     * 
     * @param myclass - the name of the class where the log is used 
     * @param msg - the message to include on the log
     */
    public void warning(String myclass, String msg) {
    	String message="[" + myclass + "] " + msg;
    	Util.logInfo(null, message) ;
    	log4j.warn(message);
    }    
}
