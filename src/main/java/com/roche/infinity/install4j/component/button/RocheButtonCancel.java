package com.roche.infinity.install4j.component.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import com.install4j.api.Util;
import com.install4j.api.context.InstallerContext;
import com.roche.infinity.install4j.installaction.InstallActions;
import com.roche.infinity.install4j.wrapper.RocheButtonWrapper;
import com.roche.infinity.screen.components.RocheButton;
import com.roche.infinity.screen.components.ui.RocheButtonUI;

/**
 * 
 * @author Jordi Campreciós
 * @date May 2018
 *
 */

public class RocheButtonCancel extends RocheButtonWrapper {
	private String dialogBoxLabel;
	private String dialogBoxText;

	/**
	 * @return the dialogBoxLabel
	 */
	public String getDialogBoxLabel() {
		return dialogBoxLabel;
	}

	/**
	 * @param dialogBoxLabel the dialogBoxLabel to set
	 */
	public void setDialogBoxLabel(String dialogBoxLabel) {
		this.dialogBoxLabel = dialogBoxLabel;
	}

	/**
	 * @return the dialogBoxText
	 */
	public String getDialogBoxText() {
		return dialogBoxText;
	}

	/**
	 * @param dialogBoxText the dialogBoxText to set
	 */
	public void setDialogBoxText(String dialogBoxText) {
		this.dialogBoxText = dialogBoxText;
	}

	@Override
	public JComponent createCenterComponent() {
		
		rocheButton = new RocheButton(
				this.getWidth(), this.getHeight(), 
				this.getTextLabel(), this.getTextToolTip(), null, 
				this.getBorderRaised(), this.getBorderPressed(),
				this.getBackground(), this.getPressedBackground(), 
				this.getForeground(), this.getActiveForeground(), 
				this.getFocusBorder(),
				new ImageIcon(this.getButtonIconFile().getAbsoluteFile().getAbsolutePath()));
		
		rocheButton.setUI(new RocheButtonUI());
		
		rocheButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            	int opcion = JOptionPane.showConfirmDialog(null, RocheButtonCancel.this.getDialogBoxText(), RocheButtonCancel.this.getDialogBoxLabel(), JOptionPane.YES_NO_OPTION);
                
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
		
		return false;
	}
}
