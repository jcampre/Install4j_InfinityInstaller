package com.roche.infinity.test.progressBar;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;

public class ProgressBarUIDemo {
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		final JProgressBar progressBar = new JProgressBar();
		progressBar.setOpaque(true);
//		progressBar.setBorder(new RoundedBorder(20)); // 10 is the radius
		progressBar.setUI(new MyProgressUI2());

		// progressBar.setPreferredSize(new Dimension(400, 100));

		JPanel p = new JPanel();
		p.add(progressBar);
		p.add(new JButton(new AbstractAction("Start") {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
					@Override
					public Void doInBackground() {
						int current = 0, lengthOfTask = 300;
						while (current <= lengthOfTask && !isCancelled()) {
							try {
								Thread.sleep(50);
							} catch (Exception ie) {
								return null;
							}
							setProgress(100 * current / lengthOfTask);
							current++;
						}
						return null;
					}
				};
				worker.addPropertyChangeListener(new ProgressListener(progressBar));
				worker.execute();
			}
		}));

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().add(p);
		frame.setSize(1200, 900);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
		frame.setVisible(true);

	}
}

class ProgressListener implements PropertyChangeListener {
	private final JProgressBar progressBar;

	ProgressListener(JProgressBar progressBar) {
		this.progressBar = progressBar;
		this.progressBar.setValue(0);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String strPropertyName = evt.getPropertyName();
		if ("progress".equals(strPropertyName)) {
			progressBar.setIndeterminate(false);
			int progress = (Integer) evt.getNewValue();
			progressBar.setValue(progress);
		}
	}
}
