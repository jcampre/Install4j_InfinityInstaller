package com.roche.infinity.action;

import javax.swing.JOptionPane;

import com.install4j.api.Util;
import com.install4j.api.context.Context;
import com.install4j.api.context.ControlButtonType;
import com.install4j.api.context.InstallerContext;
import com.roche.infinity.installer.install4j.action.installation.InstallationAction;

/**
 * 
 * @author Jordi Campreciós
 * @date June 2018 Define the installation action
 */
public class CancelButtonAction extends AbstractRocheAction {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Default constructor
	 */
	public CancelButtonAction() {
		super();		
	}
	
	/**
	 * 
	 * @param context
	 */
	private void cancel(Context context) {
//		context.getWizardContext().pressControlButton(ControlButtonType.CANCEL);
		
		int opcion = JOptionPane.showConfirmDialog(null, "EXIT?", "Vols cancel·lar la instal·lació?",
				JOptionPane.YES_NO_OPTION);

		if (opcion == 0) { // YES
			Util.showMessage("Volem sortir");
			InstallationAction installAc = new InstallationAction();
			installAc.rollback((InstallerContext) context);
			
		}
		
		else {
			Util.showMessage("Volem continuar");
		}
	}
	
	/**
	 * 
	 */
	@Override
	public boolean execute(Context context) throws Exception {
		cancel(context);
		return true;
	}
	
	/**
	 * 
	 */
	@Override
	public boolean execute(Context context, String toScreen) throws Exception {
		
		return false;
	}

	@Override
	public void reportFailure(Context context, Exception e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preaction(Context context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean postaction(Context context) {
		// TODO Auto-generated method stub
		return false;
	}
}
