package com.roche.infinity.actionListeners;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import com.install4j.api.context.Context;
import com.install4j.api.context.InstallerContext;
import com.roche.infinity.install4j.installation.action.InstallationAction;

public class CancelActionListener extends AbstractActionListener {

	private String dialogBoxTitle;
	private String dialogBoxText;
		
	/**
	 * @return the dialogBoxLabel
	 */
	public String getDialogBoxTitle() {
		return dialogBoxTitle;
	}

	/**
	 * @param dialogBoxLabel
	 *            the dialogBoxLabel to set
	 */
	public void setDialogBoxTitle(String dialogBoxTitle) {
		this.dialogBoxTitle = dialogBoxTitle;
	}

	/**
	 * @return the dialogBoxText
	 */
	public String getDialogBoxText() {
		return dialogBoxText;
	}

	/**
	 * @param dialogBoxText
	 *            the dialogBoxText to set
	 */
	public void setDialogBoxText(String dialogBoxText) {
		this.dialogBoxText = dialogBoxText;
	}

	public CancelActionListener(Context context) {
		super(context);
		dialogBoxTitle = "Cancel";
		dialogBoxText = "¿Deseas cancelar la aplicación?";		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int opcion = JOptionPane.showConfirmDialog(null, getDialogBoxText(), getDialogBoxTitle(),
				JOptionPane.YES_NO_OPTION);

		if (opcion == 0) { // YES
			InstallationAction installAc = new InstallationAction(null);
			installAc.rollback((InstallerContext) this.getContext());
		}
	}
}
