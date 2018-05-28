package com.roche.infinity.test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;

public class wwww {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wwww window = new wwww();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public wwww() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setSelectedIcon(new ImageIcon("C:\\Users\\jarenas\\OneDrive - Capgemini\\install4j-external-code\\Styles\\Render\\Buttons\\L\\L_Active Normal button.png"));
		btnNewButton.setFont(new Font("Imago", Font.BOLD, 24));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.RED);
		frame.getContentPane().add(btnNewButton);
	}

}
