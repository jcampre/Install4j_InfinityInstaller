package com.roche.infinity.installer.install4j.loader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.install4j.api.Util;
import com.install4j.api.context.Context;
import com.install4j.api.events.InstallerEvent;
import com.roche.infinity.installer.install4j.utils.LoggerManager;
import com.roche.infinity.installer.install4j.utils.Utils;

/**
 * Loads dynamically the class using reflection and calls preaction or postaction method
 * @author jcamprec
 * @date June 2018
 *
 */
public class RocheClassLoader {
	Object objReflection = null;
	Class<?> myClass = null;
	
	String ERROR_AFTER_EXECUTE = "Error executing AFTER_EXECUTE_ACTION event on class ";
	String ERROR_BEFORE_EXECUTE = "Error executing BEFORE_EXECUTE_ACTION event on class ";
	
	/**
	 * Default constructor
	 */
	public RocheClassLoader() {
		
	}
	
	/**
	 * 
	 * @param event
	 * @param context
	 * @return
	 */
	public boolean beforeExecuteAction(InstallerEvent event, Context context) {
		String className = event.getSource().getClass().getName();
						
		try {					
			myClass = Class.forName(className);
			objReflection = myClass.newInstance();
			
			Method m = myClass.getDeclaredMethod("preaction", Context.class);
			m.invoke(objReflection, context);									
		}
		catch (NoSuchMethodException e) {
			LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), ERROR_BEFORE_EXECUTE + className + ". NoSuchMethodException: " + e  );
			return false;		
		}
		catch (ClassNotFoundException e1) {
			LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), ERROR_BEFORE_EXECUTE + className + ". ClassNotFoundException: " + e1  );
			return false;					
		}		 
		catch(IllegalAccessException e2) {
			LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), ERROR_BEFORE_EXECUTE + className + ". IllegalAccessException: " + e2  );
			return false;					
		}
		catch(IllegalArgumentException e3) {
			LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), ERROR_BEFORE_EXECUTE + className + ". IllegalArgumentException: " + e3  );
			return false;
		}
		catch(InvocationTargetException e4) {
			LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), ERROR_BEFORE_EXECUTE + className + ". InvocationTargetException: " + e4  );
			return false;
		}		
		catch(InstantiationException e5) {
			LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), ERROR_BEFORE_EXECUTE + className + ". InstantiationException: " + e5  );
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @param event
	 * @param context
	 * @return
	 */
	public boolean afterExecuteAction(InstallerEvent event, Context context) {
		
		String className = event.getSource().getClass().getName();
		try {
			myClass = Class.forName(className);
		
			objReflection = myClass.newInstance();				
			Util.showMessage("objReflection = myClass.newInstance();");
			
			Method m = myClass.getDeclaredMethod("postaction", Context.class);
			Util.showMessage("Method m = myClass.getDeclaredMethod(\"postaction\", Context.class);");
			m.invoke(objReflection, context);	
			Util.showMessage("m.invoke(objReflection, context);	"
					+ "");
			
		}
		catch (NoSuchMethodException e) {
			LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), ERROR_AFTER_EXECUTE + className + ". NoSuchMethodException: " + e  );
			return false;		
		}
		catch (ClassNotFoundException e1) {
			LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), ERROR_AFTER_EXECUTE + className + ". ClassNotFoundException: " + e1  );
			return false;					
		}		 
		catch(IllegalAccessException e2) {
			LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), ERROR_AFTER_EXECUTE + className + ". IllegalAccessException: " + e2  );
			return false;					
		}
		catch(IllegalArgumentException e3) {
			LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), ERROR_AFTER_EXECUTE + className + ". IllegalArgumentException: " + e3  );
			return false;
		}
		catch(InvocationTargetException e4) {
			LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), ERROR_AFTER_EXECUTE + className + ". InvocationTargetException: " + e4  );
			return false;
		}		
		catch(InstantiationException e5) {
			LoggerManager.getInstance(Utils.class).info(Utils.class.getSimpleName(), ERROR_AFTER_EXECUTE + className + ". InstantiationException: " + e5  );
			return false;
		}
		return true;
	}
	
	
}
