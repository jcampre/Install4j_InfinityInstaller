package com.roche.infinity.actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.install4j.api.Util;
import com.install4j.api.context.InstallerContext;
import com.roche.infinity.install4j.component.button.RocheButtonCancel;
import com.roche.infinity.install4j.installation.action.InstallationAction;

public class CancelActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		RocheButtonCancel button = (RocheButtonCancel) e.getSource();
		int opcion = JOptionPane.showConfirmDialog(null, button.getDialogBoxText(), button.getDialogBoxTitle(),
				JOptionPane.YES_NO_OPTION);

		if (opcion == 0) { // YES
			InstallationAction installAc = new InstallationAction();
			installAc.rollback((InstallerContext) button.getContext());
		} else { // NO
			Util.showMessage("no");
		}
	}
}

