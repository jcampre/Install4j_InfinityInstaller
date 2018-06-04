import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.roche.infinity.install4j.utils.Utilidades.StyleProperties;
import com.roche.infinity.install4j.utils.Utilidades.StyleProperties.ButtonSizes;
import com.roche.infinity.screen.component.button.RocheButton;
import com.roche.infinity.screen.component.ui.button.RocheButtonUI;

public class SimpleRocheButtonUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static RocheButtonUI m_buttonUI = new RocheButtonUI();

	public static void main(String argv[]) {
		JFrame f = new JFrame();
		f.setSize(400, 300);
		f.getContentPane().setLayout(new FlowLayout());

		JPanel p = new JPanel();
		JButton bt1 = new RocheButton(StyleProperties.BUTTON_WIDTH_MEDIUM_SIZE, StyleProperties.BUTTON_HEIGHT_MEDIUM_SIZE, "Click Me", "Això és un botó", 
				StyleProperties.BUTTON_FONT, null, false);
		
		bt1.setUI(m_buttonUI);
		bt1.setFont(StyleProperties.BUTTON_FONT);
		
//		ButtonSizes b = ButtonSizes.MEDIUM;
//		Dimension d = new Dimension(StyleProperties.buttonSizesList.get(b.name()));
		
		p.add(bt1);
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