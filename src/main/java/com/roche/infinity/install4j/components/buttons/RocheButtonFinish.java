package com.roche.infinity.install4j.components.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

import com.install4j.api.Util;
import com.roche.infinity.screen.components.RocheButton;
import com.roche.infinity.wrapper.RocheButtonWrapper;

public class RocheButtonFinish extends RocheButtonWrapper {

	@Override
	public JComponent createCenterComponent() {
		rocheButton = new RocheButton(this.getWidth(), this.getHeight(), this.getText(), null, null, new ImageIcon(this.getButtonIconFile().getAbsoluteFile().getAbsolutePath()));

		rocheButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int opcion = JOptionPane.showConfirmDialog(null, null, null, JOptionPane.YES_NO_OPTION);
                
                if (opcion == 0) { //YES
                	Util.showMessage("I will go back to the previous screen now.");
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
