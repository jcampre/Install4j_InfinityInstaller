package com.roche.infinity.test.lookandfeel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LookAndFeelDemo1 {

	static JFrame frame;
	JLabel label;
	JComboBox<String> combo;

	public Component createComponents() {
		label = new JLabel("Selecciona un L&F");
		combo = new JComboBox<String>();

		// Añado elementos al combo
		combo.addItem("Metal");
		combo.addItem("Nimbus");
		combo.addItem("Windows");
		combo.addItem("Motif");

		combo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				initLookAndFeel(combo.getSelectedItem().toString());
			}
		});

		label.setLabelFor(combo);

		JPanel pane = new JPanel(new GridLayout(0, 1));
		pane.add(label);
		pane.add(combo);
		pane.setBorder(BorderFactory.createEmptyBorder(30, // top
				30, // left
				10, // bottom
				30) // right
		);

		return pane;
	}

	private static void initLookAndFeel(String LaF) {
		String lookAndFeel = null;

		if (LaF != null) {
			if (LaF.equals("Metal")) {
				lookAndFeel = "javax.swing.plaf.metal.MetalLookAndFeel";
			} else if (LaF.equals("Nimbus")) {
				lookAndFeel = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
			} else if (LaF.equals("Windows")) {
				lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
			} else if (LaF.equals("Motif")) {
				lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
			} else {
				lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
			}

			try {
				UIManager.setLookAndFeel(lookAndFeel);
				SwingUtilities.updateComponentTreeUI(frame);
				frame.pack();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 *   * Create the GUI and show it. For thread safety,   * this method should be
	 * invoked from the   * event dispatch thread.   
	 */
	private static void createAndShowGUI() {
		// Make sure we have nice window decorations.
		JFrame.setDefaultLookAndFeelDecorated(true);

		// Create and set up the window.
		frame = new JFrame("Look And Feel Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		LookAndFeelDemo1 app = new LookAndFeelDemo1();
		Component contents = app.createComponents();
		frame.getContentPane().add(contents, BorderLayout.CENTER);

		// Display the window.
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}