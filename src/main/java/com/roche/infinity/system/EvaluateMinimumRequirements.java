package com.roche.infinity.system;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;


/**
 * 
 * @author grebonfe
 * Evaluates the minimum requitements of the system
 */
public class EvaluateMinimumRequirements {

	/*
	 * 
	 */
	public static void main(String[] args) throws DroolsParserException,
	IOException {		
		EvaluateMinimumRequirements evaluateMinimunRequirements = new EvaluateMinimumRequirements();
		System.out.println("Is Compatible?: "+evaluateMinimunRequirements.executeDrools());
	}

	/**
	 * 
	 * @return
	 * @throws DroolsParserException
	 * @throws IOException
	 */
	public boolean executeDrools() throws DroolsParserException, IOException {

		PackageBuilder packageBuilder = new PackageBuilder();

	//TODO put this file outside the project
		String ruleFile = "/com/rule/Rules.drl";
		InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);

		Reader reader = new InputStreamReader(resourceAsStream);
		packageBuilder.addPackageFromDrl(reader);
		org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
		RuleBase ruleBase = RuleBaseFactory.newRuleBase();
		ruleBase.addPackage(rulesPackage);

		WorkingMemory workingMemory = ruleBase.newStatefulSession();

		SystemProperties systemProperties = new SystemProperties();
		
		systemProperties.setOperatingSystemName(System.getProperty("os.name"));
		systemProperties.setServicePack(System.getProperty("os.servicePack"));		

		workingMemory.insert(systemProperties);
		workingMemory.fireAllRules();

		System.out.println("Operating System Name: " + systemProperties.getOperatingSystemName()
				+ " Service Pack: " + systemProperties.getServicePack());
		
		return systemProperties.isCompatible();
	}
}
