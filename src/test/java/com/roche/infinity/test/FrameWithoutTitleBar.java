package com.roche.infinity.test;

import javax.swing.*;

@SuppressWarnings("serial")
public class FrameWithoutTitleBar extends JFrame {

	// FirstFrame properties

	public FrameWithoutTitleBar() {

		setTitle("Stacker");
		setSize(720, 540);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
		setResizable(false);
		setVisible(true); // move setVisible to the end

	}

	public static void main(String[] args) {
		new FrameWithoutTitleBar();
	}
}