package com.roche.infinity.install4j.components.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

import com.install4j.api.Util;
import com.install4j.api.context.InstallerContext;
import com.roche.infinity.install4j.InstallActions.InstallActions;
import com.roche.infinity.screen.components.RocheButton;
import com.roche.infinity.wrapper.RocheButtonWrapper;

public class RocheButtonCancel extends RocheButtonWrapper {
	private String dialogBoxLabel;
	private String dialogBoxText;
	
	/**
	 * Label shown on DialogBox
	 * 
	 * @return String
	 */
	public String getDialogBoxLabel() {
		return dialogBoxLabel;
	}

	/**
	 * Label shown on DialogBox
	 * 
	 * @return String
	 */
	public void setDialogBoxLabel(String dialogBoxLabel) {
		this.dialogBoxLabel = dialogBoxLabel;
	}

	/**
	 * Text shown on DialogBox
	 * 
	 * @return String
	 */
	public String getDialogText() {
		return dialogBoxText;
	}

	/**
	 * Text shown on DialogBox
	 * 
	 * @return String
	 */
	public void setDialogText(String dialogBoxText) {
		this.dialogBoxText = dialogBoxText;
	}

	@Override
	public JComponent createCenterComponent() {
		
		rocheButton = new RocheButton(this.getWidth(), this.getHeight(), this.getText(), null, null, new ImageIcon(this.getButtonIconFile().getAbsoluteFile().getAbsolutePath()));

		rocheButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            	int opcion = JOptionPane.showConfirmDialog(null, RocheButtonCancel.this.getDialogText(), RocheButtonCancel.this.getDialogBoxLabel(), JOptionPane.YES_NO_OPTION);
                
                if (opcion == 0) { //YES
                	InstallActions installAc = new InstallActions();
                	installAc.rollback((InstallerContext)getContext());
                } else { //NO
                	Util.showMessage("no");
                }
            }
        });
		return rocheButton;
	}

	@Override
	public boolean isFillCenterHorizontal() {
		// TODO Auto-generated method stub
		return false;
	}
}
