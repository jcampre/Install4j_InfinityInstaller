package com.roche.infinity.install4j.component.button;

import javax.swing.*;

import com.install4j.api.Util;
import com.roche.infinity.actionlistener.CancelActionListener;
import com.roche.infinity.screen.component.button.RocheButton;
import com.roche.infinity.screen.component.ui.button.RocheButtonUI;
import com.roche.infinity.install4j.wrapper.button.RocheButtonWrapper;

/**
 * 
 * @author Jordi Campreciós
 * @date May 2018 Define the roche button cancel
 */
public class RocheButtonCancel extends RocheButtonWrapper {

//	private final static RocheButtonUI m_buttonUI = new RocheButtonUI();

	/**
	 * Creates the button
	 */
	@Override
	public JComponent createCenterComponent() {
		// Util.showMessage("amplada " + this.getWidth() + " y alçada " +
		// this.getHeight() + " getTextLabel " + this.getTextLabel());

		rocheButton = new RocheButton(this.getType(), this.getWidth(), this.getHeight(), this.getTextLabel(),
				this.getTextToolTip(), this.getFont(), this.getButtonIconFile(), this.isHide(), this.isDisable());

//		
//		rocheButton.setUI(m_buttonUI);
		// rocheButton.addActionListener(new CancelActionListener(this.getContext()));
		return rocheButton;
	}

	/**
	 * 
	 */
	@Override
	public boolean isFillCenterHorizontal() {
		return false;
	}

	@Override
	public void initialize() {
		super.initialize();

		// Texts are applied to the components here rather than in the creation methods,
		// so that variables can be processed
		// each time the screen is shown.
		// label.setText(replaceVariables(labelText));
		// textField.setText(replaceVariables(text));
	}

}
