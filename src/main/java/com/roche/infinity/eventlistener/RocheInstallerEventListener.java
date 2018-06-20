package com.roche.infinity.eventlistener;

import com.install4j.api.Util;
import com.install4j.api.context.Context;
import com.install4j.api.context.InstallerContext;
import com.install4j.api.events.EventType;
import com.install4j.api.events.InstallerEvent;
import com.install4j.api.events.InstallerEventListener;
import com.roche.infinity.installer.install4j.action.installation.InstallationAction;
import com.roche.infinity.installer.install4j.loader.RocheClassLoader;

public class RocheInstallerEventListener implements InstallerEventListener {
	private Context context;

	/**
	 * 
	 */
	public RocheInstallerEventListener(Context context) {
		this.context = context;

		try {
			// Util.showMessage("DOING SOMETHING");
		} catch (Exception ex) {
			Util.showErrorMessage("DOING SOMETHING RocheInstallerEventListener");
		}
	}

	/**
	 * create Listeners.
	 */
	@Override
	public void installerEvent(InstallerEvent event) {

//			Util.showMessage("verbose : " + event.getVerbose() + "  i ara el type: " + event.getType().toString() + " i ara el source: " + event.getSource());
//			Util.showMessage("class getCanonicalName: " + event.getClass().getCanonicalName() 
//					+ " class name: " + event.getClass().getName() 
//					+ " class simple name: " + event.getClass().getSimpleName() 
//					+ " to String : " + event.toString() + "\n wasSuccessful : " + event.wasSuccessful() + "\n code: " + event.hashCode());
//			
			try {
				
				//				//listener on BEFORE_EXECUTE_ACTION
//				if (event.getType() == EventType.BEFORE_EXECUTE_ACTION) {		
//					Util.showMessage("BEFORE_EXECUTE_ACTION");
//					RocheClassLoader rocheClassLoader = new RocheClassLoader();
//					rocheClassLoader.beforeExecuteAction(event,  context);
//				}
//				//listener on AFTER_EXECUTE_ACTION			
//				if (event.getType() == EventType.AFTER_EXECUTE_ACTION) {
//					Util.showMessage("AFTER_EXECUTE_ACTION");
//					RocheClassLoader rocheClassLoader = new RocheClassLoader();
//					rocheClassLoader.afterExecuteAction(event,  context);			
//				}
//				
//				//listener CANCELLING
//		        if (event.getType() == EventType.CANCELLING) {
//		        	Util.showMessage("CANCELLING");
//		        	InstallationAction installAc = new InstallationAction();
//		        	installAc.rollback((InstallerContext)this.context);
//		        }
//		        
//		        //listener CANCELED
//		        if (event.getType() == EventType.CANCELED) {
//		        	Util.showMessage("CANCELED");
//		        	InstallationAction installAc = new InstallationAction();
//		        	installAc.canceled((InstallerContext)this.context);
//		        }
			}
			catch(Exception e) {
				Util.showErrorMessage("DOING SOMETHING installerEvent");
			}
	}
}
