package com.roche.infinity.test.Buttons;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.roche.infinity.installer.install4j.screen.component.button.RocheButton;
import com.roche.infinity.installer.install4j.style.utilities.ButtonFonts;
import com.roche.infinity.installer.install4j.style.utilities.ButtonSizes;
import com.roche.infinity.installer.install4j.style.utilities.Utilities.StyleProperties.ButtonTypes;

public class SimpleRocheButtonUI {

	public SimpleRocheButtonUI()
	{
		JFrame f = new JFrame();
		f.setSize(400, 300);
		f.getContentPane().setLayout(new FlowLayout());

		JPanel p = new JPanel();
				
		JButton bt1 = new RocheButton(ButtonTypes.NORMAL,
				new Dimension(ButtonSizes.BUTTON_WIDTH_LARGE_SIZE.getSize(),
						ButtonSizes.BUTTON_HEIGHT_LARGE_SIZE.getSize()),
						"Click Me", "Això és un botó", ButtonFonts.BUTTON_FONT.getFont(), null, false, true);

		JButton bt2 = new RocheButton(ButtonTypes.ACTIVE,
				new Dimension(ButtonSizes.BUTTON_WIDTH_LARGE_SIZE.getSize(),
						ButtonSizes.BUTTON_HEIGHT_LARGE_SIZE.getSize()),
						"Click Me", "Això és un botó", ButtonFonts.BUTTON_FONT.getFont(), null, false, false);

		p.add(bt1);
		p.add(bt2); 

		f.getContentPane().add(p);
		WindowListener wndCloser = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		f.addWindowListener(wndCloser);
		f.setVisible(true);
	}

	public static void main(String argv[]) {
		SimpleRocheButtonUI mt = new SimpleRocheButtonUI();
	    //mt.setVisible( true );
	    
		
	}
}