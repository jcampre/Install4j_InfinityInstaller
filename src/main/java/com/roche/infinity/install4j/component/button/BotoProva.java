package com.roche.infinity.install4j.component.button;

import javax.swing.*;

import com.install4j.api.Util;
import com.install4j.api.context.ControlButtonType;
import com.install4j.api.styles.ControlButton;
import com.roche.infinity.actionlistener.CancelButtonActionListener;
import com.roche.infinity.screen.component.button.RocheButton;
import com.roche.infinity.screen.component.ui.button.RocheButtonUI;
import com.roche.infinity.install4j.wrapper.button.RocheButtonWrapper;

public class BotoProva implements ControlButton {

	@Override
	public void focusControlButton() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ControlButtonType getControlButtonType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setControlButtonText(String arg0) {
		// TODO Auto-generated method stub
		
		this.notify();
	}

	
}
