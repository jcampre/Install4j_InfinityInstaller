package com.roche.infinity.install4j.components;

import javax.swing.JFrame;

/**
 * 
 * @author Jordi Arenas
 * @date May 2018 Define the Roche abstract frame
 */
@SuppressWarnings("serial")
public abstract class RocheFrame extends JFrame {

	public RocheFrame() {
		setTitle("NoTitle");
		setSize(720, 540);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
		setResizable(false);
		setVisible(true); // move setVisible to the end
	}
}
