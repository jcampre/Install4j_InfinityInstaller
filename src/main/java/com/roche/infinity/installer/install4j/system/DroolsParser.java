package com.roche.infinity.installer.install4j.system;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;
import com.roche.infinity.installer.install4j.utils.LoggerManager;

/**
 * 
 * @author grebonfe
 * Evaluates the minimum requirements of the system
 */
public class DroolsParser {

	private DroolsParser(){}
	
	public static final String RULE_FILE = "/com/roche/infinity/installer/install4j/Rules.drl";
	
	/**
	 * Executes all the rules
	 * @return the result of the execution
	 */	
	public static boolean executeRules() {

		PackageBuilder packageBuilder = new PackageBuilder();		
		
		InputStream resourceAsStream = DroolsParser.class.getResourceAsStream(RULE_FILE);
		
		if (resourceAsStream==null)
			resourceAsStream = DroolsParser.class.getClassLoader().getResourceAsStream(RULE_FILE);
		
		Reader reader = new InputStreamReader(resourceAsStream);
		
		try {
			packageBuilder.addPackageFromDrl(reader);
		
			org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
			RuleBase ruleBase = RuleBaseFactory.newRuleBase();
			ruleBase.addPackage(rulesPackage);
		
			SystemProperties systemProperties = new SystemProperties();
			
			getSystemProperties(systemProperties);	
	
			buildWorkingMemory(ruleBase, systemProperties);
	
			logSystemProperties(systemProperties);			
			return systemProperties.isCompatible();
			
		} catch (DroolsParserException e) {
			LoggerManager.getInstance(DroolsParser.class).error(DroolsParser.class.getSimpleName(), e.getErrorCode() +  ": " + e.getLineNumber() + "." + e.getLocalizedMessage(), e); 
			return false;
		} catch (IOException e) {
			LoggerManager.getInstance(DroolsParser.class).error(DroolsParser.class.getSimpleName(), e.getLocalizedMessage(), e);
			return false;
		}
	}

	/**
	 * @param ruleBase - the rule base
	 * @param systemProperties - the system properties
	 */
	private static void buildWorkingMemory(RuleBase ruleBase, SystemProperties systemProperties) {
		WorkingMemory workingMemory = ruleBase.newStatefulSession();
		workingMemory.insert(systemProperties);
		workingMemory.fireAllRules();
	}

	/**
	 * Log the system properties
	 * @param systemProperties  - are the  system properties to be logged
	 */
	private static void logSystemProperties(SystemProperties systemProperties) {
		LoggerManager.getInstance(DroolsParser.class).info(DroolsParser.class.getSimpleName(), "Operating System: " + systemProperties.getOperatingSystemName());
		LoggerManager.getInstance(DroolsParser.class).info(DroolsParser.class.getSimpleName(), "Service Pack: " + systemProperties.getServicePack());
		LoggerManager.getInstance(DroolsParser.class).info(DroolsParser.class.getSimpleName(), "Architecture: " + systemProperties.getOperatingSystemArchitecture());
	}

	/**
	 * Get the system properties
	 * @param systemProperties - the system properties to retrieve
	 */
	private static void getSystemProperties(SystemProperties systemProperties) {
		systemProperties.setOperatingSystemName(System.getProperty("os.name"));
		systemProperties.setServicePack(System.getProperty("os.servicePack"));		
		systemProperties.setOperatingSystemArchitecture(getOperatingSystemArchitecture());
	}
	
	/**
	 * Evaluate the architecture of the operating system
	 * @return String the Operating System Architecture
	 */
	private static String getOperatingSystemArchitecture(){	    
	    if(System.getenv("ProgramFiles(X86)")!=null)
	    	return "64bit";
	    else
	    	return "32bit";	    
	}
}
