package com.roche.infinity.install4j.component.button;

import javax.swing.JComponent;
import javax.swing.UIManager;

import com.roche.infinity.actionlistener.CancelActionListener;
import com.roche.infinity.install4j.wrapper.button.RocheButtonWrapper;
import com.roche.infinity.screen.component.button.RocheButton;
//import com.roche.infinity.screen.component.ui.button.DefaultButtonUI;
import com.roche.infinity.screen.component.ui.button.RocheButtonUI;

/**
 * 
 * @author Jordi Campreci�s
 * @date May 2018 Define the roche button cancel
 */
public class RocheButtonCancel extends RocheButtonWrapper {

	/**
	 * Creates the button
	 */
	@Override
	public JComponent createCenterComponent() {
		rocheButton = new RocheButton(this.getWidth(), this.getHeight(), this.getTextLabel(), this.getTextToolTip(),
				null, this.getBorderRaised(), this.getBorderPressed(), this.getBackground(),
				this.getPressedBackground(), this.getForeground(), this.getActiveForeground(), this.getFocusBorder(),
				this.getButtonIconFile());

		// rocheButton.setUI(new RocheButtonUI());
		UIManager.put("ButtonUi", RocheButtonUI.class.getName());
		rocheButton.addActionListener(new CancelActionListener(this.getContext()));

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
