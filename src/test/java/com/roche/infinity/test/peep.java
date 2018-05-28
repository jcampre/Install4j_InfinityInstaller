package com.roche.infinity.test;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class peep extends JPanel {

	/**
	 * Create the panel.
	 */
	public peep() {
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setSelectedIcon(new ImageIcon("C:\\Users\\jarenas\\OneDrive - Capgemini\\install4j-external-code\\Styles\\Render\\Buttons\\L\\L_Active Normal button.png"));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\jarenas\\OneDrive - Capgemini\\install4j-external-code\\Styles\\Render\\Buttons\\L\\L_Active blue button.png"));
		btnNewButton.setFont(new Font("Minion Pro SmBd", Font.PLAIN, 16));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setForeground(Color.WHITE);
		add(btnNewButton);

	}

}
