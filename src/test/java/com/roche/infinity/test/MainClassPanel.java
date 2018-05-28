package com.roche.infinity.test;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainClassPanel extends JPanel {

  public void paint(Graphics g) {
      g.drawRoundRect(25, 50, 100, 100, 25, 50);
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.getContentPane().add(new MainClassPanel());

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200,200);
    frame.setVisible(true);
  }
}
 