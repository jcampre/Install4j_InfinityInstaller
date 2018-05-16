package com.roche.infinity.install4j.component.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import com.install4j.api.Util;
import com.install4j.api.context.InstallerContext;
import com.roche.infinity.install4j.installation.action.InstallationAction;
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
	
	private String dialogBoxTitle;
	private String dialogBoxText;

	/**
	 * @return the dialogBoxLabel
	 */
	public String getDialogBoxTitle() {
		return dialogBoxTitle;
	}

	/**
	 * @param dialogBoxLabel the dialogBoxLabel to set
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
               
            	int opcion = JOptionPane.showConfirmDialog(null, RocheButtonCancel.this.getDialogBoxText(), RocheButtonCancel.this.getDialogBoxTitle(), JOptionPane.YES_NO_OPTION);
                
                if (opcion == 0) { //YES
                	InstallationAction installAc = new InstallationAction();
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
