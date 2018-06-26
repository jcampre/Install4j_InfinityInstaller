package com.roche.infinity.test.lookandfeel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

import com.roche.infinity.installer.install4j.component.button.ui.DefaultButtonUI2;



@SuppressWarnings("serial")
public class LookAndFeelCreate extends JFrame {

	// FirstFrame properties

	public LookAndFeelCreate() {

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(null, "after this dialog");
				System.exit(0);
			}
		});

		UIManager.put("ButtonUI", DefaultButtonUI2.class.getName()); // Here is the relevant line

		UIManager.put("Panel.background", Color.LIGHT_GRAY);

		UIManager.put("OptionPane.background", Color.LIGHT_GRAY);

		UIManager.put("TitledBorder.font", new Font(Font.SANS_SERIF, Font.BOLD, 12));
		
		setSize(600, 400);
		setPreferredSize(new Dimension(600, 400));
		setTitle("tksfd!");
		setLocationRelativeTo(null);
		setResizable(false);
		pack();
		setVisible(true);

	}

	public static void main(String[] args) {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				System.out.println(info.getName());
//				if ("Windows".equals(info.getName())) {
//					UIManager.setLookAndFeel(info.getClassName());
//					break;
//				}
			}
		} catch (Exception e) {

		}

		new LookAndFeelCreate();
	}
}