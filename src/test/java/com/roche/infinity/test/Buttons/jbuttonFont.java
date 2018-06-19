package com.roche.infinity.test.Buttons;
/**
 * File: jbuttonFont.java
 * Tiltle: Change JButton Font, Font Style, and Font Size
 * Author: http://java-program-sample.blogspot.com
 */

//Java Core Package
import javax.swing.*;
//Java Extension Package
import java.awt.*;

@SuppressWarnings("serial")
public class jbuttonFont extends JFrame {

	// Initializing JButton Array, JPanel, Font Class, and Specified JButton String
	// Label
	private JButton button[];
	private JPanel panel;
	String fontName[] = { "Plain", "Italic", "Bold", "Italic-Bold", "Arial", "Tahoma", "Verdana", "Courier", "SIZE 12",
			"SIZE 14", "SIZE 16", "SIZE 18", "Roboco 12", "Roboco 14", "Roboco 16", "Roboco 18", "Roboco 24",
			"Roboco 32" };
	private Font bPlain, bItalic, bBold, bItalicBold, bArial, bTahoma, bVerdana, bCourier, bSize12, bSize14, bSize16,
			bSize18, Roboco12, Roboco14, Roboco16, Roboco18, Roboco24, Roboco32;

	// Setting up GUI
	public jbuttonFont() {

		// Setting up the Title of the Window
		super("Change JButton Fonts");

		// Set Size of the Window (WIDTH, HEIGHT)
		setSize(275, 400);

		// Exit Property of the Window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Constructing JButton with an array of 12
		button = new JButton[18];

		// Constructing JPanel with a GirdLayout of 12 rows and 1 column (Vertical
		// Position)
		panel = new JPanel();
		panel.setLayout(new GridLayout(button.length, 1));

		// Setting the Font
		bBold = new Font("Arial", Font.BOLD, 14);
		bPlain = new Font("Arial", Font.PLAIN, 14);
		bItalic = new Font("Arial", Font.ITALIC, 14);
		bItalicBold = new Font("Arial", Font.BOLD + Font.ITALIC, 14);

		// Setting the Font Style
		bArial = new Font("Arial", Font.PLAIN, 14);
		bTahoma = new Font("Tahoma", Font.PLAIN, 14);
		bVerdana = new Font("Verdana", Font.PLAIN, 14);
		bCourier = new Font("Courier", Font.PLAIN, 14);

		// Setting the Font Size
		bSize12 = new Font("Arial", Font.PLAIN, 12);
		bSize14 = new Font("Arial", Font.PLAIN, 14);
		bSize16 = new Font("Arial", Font.PLAIN, 16);
		bSize18 = new Font("Arial", Font.PLAIN, 18);

		Roboco12 = new Font("Roboto Lt", Font.BOLD, 12);
		Roboco14 = new Font("Roboto Lt", Font.BOLD, 14);
		Roboco16 = new Font("Roboto Lt", Font.BOLD, 16);
		Roboco18 = new Font("Roboto Lt", Font.PLAIN, 18);
		Roboco24 = new Font("Roboto Lt", Font.PLAIN, 24);
		Roboco32 = new Font("Roboto Lt", Font.PLAIN, 32);

		// Constructing all 12 JButtons using "for loop"
		for (int count = 0; count < button.length; count++) {
			button[count] = new JButton(fontName[count]);
			panel.add(button[count]);
		}

		// Applying Fonts to each JButtons
		button[0].setFont(bPlain);
		button[1].setFont(bItalic);
		button[2].setFont(bBold);
		button[3].setFont(bItalicBold);
		button[4].setFont(bArial);
		button[5].setFont(bTahoma);
		button[6].setFont(bVerdana);
		button[7].setFont(bCourier);
		button[8].setFont(bSize12);
		button[9].setFont(bSize14);
		button[10].setFont(bSize16);
		button[11].setFont(bSize18);

		button[12].setFont(Roboco12);
		button[13].setFont(Roboco14);
		button[14].setFont(Roboco16);
		button[15].setFont(Roboco18);
		button[16].setFont(Roboco24);
		button[17].setFont(Roboco32);
		
		// Setting up the container ready for the components to be added.
		Container pane = getContentPane();
		setContentPane(pane);

		// Adding the JPanel to the container
		pane.add(panel);

		/**
		 * Set all the Components Visible. If it is set to "false", the components in
		 * the container will not be visible.
		 */
		setVisible(true);
	}

	// Main Method
	public static void main(String[] args) {
		jbuttonFont jbf = new jbuttonFont();
	}
}