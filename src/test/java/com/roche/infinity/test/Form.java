package com.roche.infinity.test;

import java.awt.EventQueue;

import javax.swing.*;

public class Form {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form window = new Form();
					window.frame.setTitle("Stacker");
					window.frame.setSize(720, 540);
					window.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
					window.frame.setUndecorated(true);
					window.frame.setResizable(false);
					window.frame.setVisible(true); // move setVisible to the end
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Form() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
