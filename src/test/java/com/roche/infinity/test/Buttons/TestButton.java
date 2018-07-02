package com.roche.infinity.test.Buttons;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestButton {

	public TestButton() {
		JFrame f = new JFrame();
		f.setSize(new Dimension(200, 200));
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());

		final JButton stop = new JButton("Stop");
		final JButton start = new JButton("Start");
		p.add(start);
		p.add(stop);
		f.getContentPane().add(p);
		stop.setEnabled(false);
		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start.setEnabled(true);
				stop.setEnabled(false);

			}
		});

		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start.setEnabled(false);
				stop.setEnabled(true);

			}
		});
		f.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TestButton();

	}
}