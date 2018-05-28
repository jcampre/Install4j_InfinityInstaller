package com.roche.infinity.screen.component.ui.button;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicProgressBarUI;

/**
 * 
 * UI for default progressbar.
 * 
 * Can be used with:
 * 
 * UIManager.put("ProgressBarUI", RocheProgressBarUI.class.getName());
 * 
 * Or:
 * 
 * myProgressBar.setUI(new RocheProgressBarUI());
 * 
 */

public class RocheProgressBarUI extends BasicProgressBarUI implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private static final RocheProgressBarUI progressBarUI = new RocheProgressBarUI();
	
	private final Color outlineColor = Color.decode("#A7A7A7");
	private final Color barColor = Color.decode("#0066CC");

	private Handler handler;
	private double renderProgress = 0;
	private double targetProgress = 0;
	private double progressDelta = 0.04;
	private Timer repaintTimer;
	private Timer paintTimer;

	protected Color background = UIManager.getColor("ProgressBar.background");
	
	public RocheProgressBarUI() {
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

	public static ComponentUI createUI(JComponent c) {
		return progressBarUI;
	}

	/**
	 * 
	 */
	@Override
	public void installUI(JComponent c) {
		super.installUI(c);
	}

	/**
	 * 
	 */
	@Override
	public void uninstallUI(JComponent c) {
		super.uninstallUI(c);
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
		// Color[] colors = { barColor, barColor.brighter(), barColor.darker() };
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