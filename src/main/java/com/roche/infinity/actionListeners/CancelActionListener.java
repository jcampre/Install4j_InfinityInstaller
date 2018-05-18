package com.roche.infinity.actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import com.install4j.api.context.Context;
import com.install4j.api.context.InstallerContext;
import com.roche.infinity.install4j.installation.action.InstallationAction;

public class CancelActionListener implements ActionListener {

	private String dialogBoxTitle;
	private String dialogBoxText;
	private Context context;
	
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
		this.dialogBoxTitle = "Cancel";
		this.dialogBoxText = "¿Deseas cancelar la aplicación?";
		this.context = context;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int opcion = JOptionPane.showConfirmDialog(null, getDialogBoxText(), getDialogBoxTitle(),
				JOptionPane.YES_NO_OPTION);

		if (opcion == 0) { // YES
			InstallationAction installAc = new InstallationAction(null);
			installAc.rollback((InstallerContext) context);
		}
	}
}
