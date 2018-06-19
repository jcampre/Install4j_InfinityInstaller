package com.roche.infinity.test;

import java.awt.*;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.roche.infinity.actionlistener.CancelButtonActionListener;

public class Testing {

	public void buildGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame f = new JFrame();
		f.setResizable(false);
		removeMinMaxClose(f);
		JPanel p = new JPanel(new GridBagLayout());
		JButton btn = new JButton("Exit");
		p.add(btn, new GridBagConstraints());
		f.getContentPane().add(p);
		f.setSize(400, 300);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

		btn.addActionListener(new CancelButtonActionListener(null));
	}

	public void removeMinMaxClose(Component comp) {
		if (comp instanceof AbstractButton) {
			comp.getParent().remove(comp);
		}
		if (comp instanceof Container) {
			Component[] comps = ((Container) comp).getComponents();
			for (int x = 0, y = comps.length; x < y; x++) {
				removeMinMaxClose(comps[x]);
			}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Testing().buildGUI();
			}
		});
	}
}
