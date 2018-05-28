package com.roche.infinity.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
/*from   w  ww.j  av a2  s  . c o  m*/
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Header extends JFrame {

	Header() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900, 600);

		JPanel left = new JPanel();
		left.setBackground(Color.BLUE);

		JPanel right = new JPanel(new BorderLayout());

		JLabel fox = new JLabel("The quick brown fox jumps over the lazy dog.");
		fox.setFont(new Font(null, 0, 50));

		JPanel rightBottom = new JPanel();
		rightBottom.setLayout(new GridLayout(10, 10));
		for (int i = 1; i <= 100; i++) {
			rightBottom.add(new JButton("butt" + i));
		}
		right.add(fox, BorderLayout.NORTH);
		right.add(rightBottom, BorderLayout.CENTER);
		add(right);
		add(left);
	}

	public static void main(String[] args) {
		new Header().setVisible(true);
	}
}
