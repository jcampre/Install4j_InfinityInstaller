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
	 * 
	 * @return
	 * @throws DroolsParserException
	 * @throws IOException
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
	
			WorkingMemory workingMemory = ruleBase.newStatefulSession();
	
			SystemProperties systemProperties = new SystemProperties();
			
			getSystemProperties(systemProperties);	
	
			workingMemory.insert(systemProperties);
			workingMemory.fireAllRules();
	
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
	 * @param systemProperties
	 */
	private static void logSystemProperties(SystemProperties systemProperties) {
		LoggerManager.getInstance(DroolsParser.class).info(DroolsParser.class.getSimpleName(), "Operating System: " + systemProperties.getOperatingSystemName());
		LoggerManager.getInstance(DroolsParser.class).info(DroolsParser.class.getSimpleName(), "Service Pack: " + systemProperties.getServicePack());
		LoggerManager.getInstance(DroolsParser.class).info(DroolsParser.class.getSimpleName(), "Architecture: " + systemProperties.getOperatingSystemArchitecture());
	}

	/**
	 * @param systemProperties
	 */
	private static void getSystemProperties(SystemProperties systemProperties) {
		systemProperties.setOperatingSystemName(System.getProperty("os.name"));
		systemProperties.setServicePack(System.getProperty("os.servicePack"));		
		systemProperties.setOperatingSystemArchitecture(System.getProperty("os.arch"));
	}
}
