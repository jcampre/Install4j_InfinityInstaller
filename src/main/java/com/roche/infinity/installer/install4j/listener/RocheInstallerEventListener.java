package com.roche.infinity.installer.install4j.listener;

import com.install4j.api.context.Context;
import com.install4j.api.context.InstallerContext;
import com.install4j.api.events.EventType;
import com.install4j.api.events.InstallerEvent;
import com.install4j.api.events.InstallerEventListener;
import com.roche.infinity.installer.install4j.action.installation.InstallationAction;
import com.roche.infinity.installer.install4j.loader.RocheClassLoader;

/**
 * 
 * @author Jordi Campreciós i Jordi Arenas
 * @date May/juny 2018
 * Define the roche installer event listener
 */
public class RocheInstallerEventListener implements InstallerEventListener{
		
	private Context context;
	
	/**
	 * 
	 */
	public RocheInstallerEventListener(Context context) {
		this.context = context;
	}
	
	/**
	 * create Listeners. 
	 */
	@Override
	public void installerEvent(InstallerEvent event) {

			
		try {
			//listener on BEFORE_EXECUTE_ACTION
			if (event.getType() == EventType.BEFORE_EXECUTE_ACTION) {				
				RocheClassLoader rocheClassLoader = new RocheClassLoader();
				rocheClassLoader.beforeExecuteAction(event,  context);
			}
			
			//listener on AFTER_EXECUTE_ACTION			
			if (event.getType() == EventType.AFTER_EXECUTE_ACTION) {				
				RocheClassLoader rocheClassLoader = new RocheClassLoader();
				rocheClassLoader.afterExecuteAction(event,  context);			
			}
		
			//listener CANCELLING
	        if (event.getType() == EventType.CANCELLING) {
	        	InstallationAction installAc = new InstallationAction();
	        	installAc.rollback((InstallerContext)this.context);
	        }
	        
	        //listener CANCELED
	        if (event.getType() == EventType.CANCELED) {
	        	InstallationAction installAc = new InstallationAction();
	        	installAc.canceled((InstallerContext)this.context);
	        }
		}
		catch(Exception e) {
			
		}
	}
}
