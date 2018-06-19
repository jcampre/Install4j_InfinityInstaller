package com.roche.infinity.test.Buttons;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.roche.infinity.install4j.utils.Utilidades.StyleProperties;
import com.roche.infinity.install4j.utils.Utilidades.StyleProperties.ButtonTypes;
import com.roche.infinity.screen.component.button.RocheButton;
import com.roche.infinity.screen.component.ui.button.ActiveRocheButtonUI;
import com.roche.infinity.screen.component.ui.button.NormalRocheButtonUI;
import com.roche.infinity.screen.component.ui.button.RocheButtonUI;

public class SimpleRocheButtonUI {

	public static void main(String argv[]) {
		JFrame f = new JFrame();
		f.setSize(400, 300);
		f.getContentPane().setLayout(new FlowLayout());

		JPanel p = new JPanel();
		JButton bt1 = new RocheButton( ButtonTypes.NORMAL, 
				new Dimension(StyleProperties.BUTTON_WIDTH_LARGE_SIZE, StyleProperties.BUTTON_HEIGHT_LARGE_SIZE), 
				"Click Me", "Això és un botó", 
				StyleProperties.BUTTON_FONT, null, false, false);
		
		JButton bt2 = new RocheButton( ButtonTypes.ACTIVE,
				new Dimension(StyleProperties.BUTTON_WIDTH_LARGE_SIZE, StyleProperties.BUTTON_HEIGHT_LARGE_SIZE), 
				"Click Me", "Això és un botó", 
				StyleProperties.BUTTON_FONT, null, false, false);
		
		
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
}