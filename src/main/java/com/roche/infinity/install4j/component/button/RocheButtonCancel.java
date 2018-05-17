package com.roche.infinity.install4j.component.button;

import javax.swing.JComponent;

import com.roche.infinity.actionListeners.CancelActionListener;
import com.roche.infinity.install4j.wrapper.button.RocheButtonWrapper;
import com.roche.infinity.screen.component.button.RocheButton;
import com.roche.infinity.screen.component.ui.button.RocheButtonUI;

/**
 * 
 * @author Jordi Campreciós
 * @date May 2018
 * Define the roche button cancel
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

	/**
	 * Creates the button
	 */
	@Override
	public JComponent createCenterComponent() {
		
		rocheButton = new RocheButton(
				this.getWidth(), this.getHeight(), 
				this.getTextLabel(), this.getTextToolTip(), null, 
				this.getBorderRaised(), this.getBorderPressed(),
				this.getBackground(), this.getPressedBackground(), 
				this.getForeground(), this.getActiveForeground(), 
				this.getFocusBorder(),
				this.getButtonIconFile());
		
		rocheButton.setUI(new RocheButtonUI());
		rocheButton.addActionListener(new CancelActionListener()); 
//		{
//            @Override
//            public void actionPerformed(ActionEvent e) {
//               
//            	int opcion = JOptionPane.showConfirmDialog(null, RocheButtonCancel.this.getDialogBoxText(), RocheButtonCancel.this.getDialogBoxTitle(), JOptionPane.YES_NO_OPTION);
//                
//                if (opcion == 0) { //YES
//                	InstallationAction installAc = new InstallationAction();
//                	installAc.rollback((InstallerContext)getContext());
//                } else { //NO
//                	Util.showMessage("no");
//                }
//            }
//        });
		return rocheButton;
	}

	/**
	 * 
	 */
	@Override
	public boolean isFillCenterHorizontal() {		
		return false;
	}
}
