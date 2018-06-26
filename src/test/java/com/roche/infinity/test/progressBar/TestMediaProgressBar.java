package com.roche.infinity.test.progressBar;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.LinearGradientPaint;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BoundedRangeModel;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicProgressBarUI;

import com.roche.infinity.installer.install4j.component.progressbar.RocheProgressBar;
import com.roche.infinity.installer.install4j.component.progressbar.ui.RocheProgressBarUI;


public class TestMediaProgressBar {

	public static void main(String[] args) {
		new TestMediaProgressBar();
	}

	public TestMediaProgressBar() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException ex) {
				}

				JFrame frame = new JFrame("Testing");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.add(new TestPane());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

	public class TestPane extends JPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = -2160278964056291355L;
		
		private RocheProgressBar pb;
		private int value = 0;
		private int delta = 25;

		public TestPane() {
			// setBackground(Color.BLACK);
			setLayout(new GridBagLayout());
			pb = new RocheProgressBar(200,14, Color.RED, 1 );
			add(pb);
				
			pb.setValue(33);
			
//			Timer timer = new Timer(500, new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					if (value + delta > 100) {
//						delta *= -1;
//						value = 100;
//					} else if (value + delta < 0) {
//						delta *= -1;
//						value = 0;
//					}
//					value += delta;
//					pb.setValue(value);
//				}
//			});
//			timer.start();
		}

		@Override
		public Dimension getPreferredSize() {
			return new Dimension(720, 540);
		}
	}

	public class MediaProgressBar extends JProgressBar {

		private static final int progressBarWidth = 200;
		private static final int progressBarHeigh = 14;
	
		public int width = progressBarWidth;
		public int height = progressBarHeigh;
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1984738288043843896L;

		public MediaProgressBar() {
			setUI(new RocheProgressBarUI());
		}

		@Override
		public Dimension getPreferredSize() {

			return new Dimension(width, height);

		}
	}

	public class MediaProgressBarUI extends BasicProgressBarUI {

		private final Color outlineColor = Color.decode("#A7A7A7");
		private final Color barColor = Color.decode("#0066CC");
		
		private Handler handler;
		private double renderProgress = 0;
		private double targetProgress = 0;
		private double progressDelta = 0.04;
		private Timer repaintTimer;
		private Timer paintTimer;

		public MediaProgressBarUI() {
			repaintTimer = new Timer(25, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					progressBar.repaint();
				}
			});
			repaintTimer.setRepeats(false);
			repaintTimer.setCoalesce(true);

			paintTimer = new Timer(40, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (progressDelta < 0) {

						if (renderProgress + progressDelta < targetProgress) {
							((Timer) e.getSource()).stop();
							renderProgress = targetProgress + progressDelta;
						}

					} else {

						if (renderProgress + progressDelta > targetProgress) {
							((Timer) e.getSource()).stop();
							renderProgress = targetProgress - progressDelta;
						}

					}
					renderProgress += progressDelta;
					requestRepaint();
				}
			});
		}

		protected void requestRepaint() {
			repaintTimer.restart();
		}

		@Override
		protected void installDefaults() {
			super.installDefaults();
			progressBar.setOpaque(false);
			progressBar.setBorder(null);
		}

		public void setRenderProgress(double value) {
			if (value != targetProgress) {
				paintTimer.stop();

				targetProgress = value;
				if (targetProgress < renderProgress && progressDelta > 0) {
					progressDelta *= -1;
				} else if (targetProgress > renderProgress && progressDelta < 0) {
					progressDelta *= -1;
				}
				System.out.println(progressDelta);

				paintTimer.start();
			}
		}

		public double getRenderProgress() {
			return renderProgress;
		}

		@Override
		public void paint(Graphics g, JComponent c) {
			Graphics2D g2d = (Graphics2D) g.create();

			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			float iStrokeWidth = 0.5f;
			g2d.setStroke(new BasicStroke(iStrokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
			g2d.setColor(outlineColor);

			int width = c.getWidth();
			int height = c.getHeight();

			RoundRectangle2D outline = new RoundRectangle2D.Double((iStrokeWidth / 2), (iStrokeWidth / 2),
					width - iStrokeWidth, height - iStrokeWidth, height, height);

			g2d.draw(outline);
			g2d.clip(outline);

			float iInnerHeight = height - (iStrokeWidth * 4);
			float iInnerWidth = width - (iStrokeWidth * 4);

			iInnerWidth = (int) Math.round(iInnerWidth * renderProgress);

			float x = iStrokeWidth * 2;
			float y = iStrokeWidth * 2;

			Point2D start = new Point2D.Double(x, y);
			Point2D end = new Point2D.Double(x, y + iInnerHeight);

			float[] dist = { 0.0f, 0.25f, 1.0f };
//			Color[] colors = { barColor, barColor.brighter(), barColor.darker() };
			Color[] colors = { barColor, barColor, barColor };
			LinearGradientPaint p = new LinearGradientPaint(start, end, dist, colors);
			
			g2d.setPaint(p);

			RoundRectangle2D fill = new RoundRectangle2D.Double(iStrokeWidth * 2, iStrokeWidth * 2, iInnerWidth,
					iInnerHeight, iInnerHeight, iInnerHeight);

			g2d.fill(fill);

			g2d.dispose();
		}

		@Override
		protected void installListeners() {
			super.installListeners();
			progressBar.addChangeListener(getChangeHandler());
		}

		protected ChangeListener getChangeHandler() {

			return getHandler();

		}

		protected Handler getHandler() {

			if (handler == null) {
				handler = new Handler();
			}

			return handler;

		}

		public class Handler implements ChangeListener {

			@Override
			public void stateChanged(ChangeEvent e) {

				BoundedRangeModel model = progressBar.getModel();
				int newRange = model.getMaximum() - model.getMinimum();
				double dProgress = (double) (model.getValue() / (double) newRange);

				if (dProgress < 0) {
					dProgress = 0;
				} else if (dProgress > 1) {
					dProgress = 1;
				}

				setRenderProgress(dProgress);

			}

		}

	}

}