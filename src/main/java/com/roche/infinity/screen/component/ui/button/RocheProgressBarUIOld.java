package com.roche.infinity.screen.component.ui.button;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.BasicProgressBarUI;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

/**
 * 
 * UI for default progressbar.
 * 
 * Can be used with:
 * 
 * UIManager.put("ButtonUI", RocheProgressBarUI.class.getName());
 * 
 * Or:
 * 
 * myProgressBar.setUI(new DefaultButtonUI());
 * 
 */

public class RocheProgressBarUIOld extends BasicProgressBarUI {

	// public static final int BUTTON_WIDTH = 180;
	//
	// public static final int BUTTON_HEIGHT = 64;

	private static final RocheProgressBarUIOld INSTANCE = new RocheProgressBarUIOld();
	//
	// private static final int MARGIN_VALUE = 30;
	//
	// private static final Insets BUTTON_MARGIN = new Insets(MARGIN_VALUE, 0,
	// MARGIN_VALUE, 0);
	//
	// private static final Border BUTTON_BORDER =
	// BorderFactory.createLineBorder(Color.GRAY);

	private int cachedPercent;
	private int cellLength, cellSpacing;
	// The "selectionForeground" is the color of the text when it is painted
	// over a filled area of the progress bar. The "selectionBackground"
	// is for the text over the unfilled progress bar area.
	private Color selectionForeground, selectionBackground;

	private Animator animator;

	protected JProgressBar progressBar;
	protected ChangeListener changeListener;
	private Handler handler;
    private double renderProgress = 0;
    private double targetProgress = 0;
    private double progressDelta = 0.04;
    private Timer repaintTimer;
    private Timer paintTimer;

	/**
	 * The current state of the indeterminate animation's cycle. 0, the initial
	 * value, means paint the first frame. When the progress bar is indeterminate
	 * and showing, the default animation thread updates this variable by invoking
	 * incrementAnimationIndex() every repaintInterval milliseconds.
	 */
	private int animationIndex = 0;

	/**
	 * The number of frames per cycle. Under the default implementation, this
	 * depends on the cycleTime and repaintInterval. It must be an even number for
	 * the default painting algorithm. This value is set in the
	 * initIndeterminateValues method.
	 */
	private int numFrames; // 0 1|numFrames-1 ... numFrames/2

	/**
	 * Interval (in ms) between repaints of the indeterminate progress bar. The
	 * value of this method is set (every time the progress bar changes to
	 * indeterminate mode) using the "ProgressBar.repaintInterval" key in the
	 * defaults table.
	 */
	private int repaintInterval;

	/**
	 * The number of milliseconds until the animation cycle repeats. The value of
	 * this method is set (every time the progress bar changes to indeterminate
	 * mode) using the "ProgressBar.cycleTime" key in the defaults table.
	 */
	private int cycleTime; // must be repaintInterval*2*aPositiveInteger

	// performance stuff
	private static boolean ADJUSTTIMER = true; // makes a BIG difference;
												// make this false for
												// performance tests

	/**
	 * Used to hold the location and size of the bouncing box (returned by getBox)
	 * to be painted.
	 *
	 * @since 1.5
	 */
	protected Rectangle boxRect;

	/**
	 * The rectangle to be updated the next time the animation thread calls repaint.
	 * For bouncing-box animation this rect should include the union of the
	 * currently displayed box (which needs to be erased) and the box to be
	 * displayed next. This rectangle's values are set in the setAnimationIndex
	 * method.
	 */
	private Rectangle nextPaintRect;

	// cache
	/** The component's painting area, not including the border. */
	private Rectangle componentInnards; // the current painting area
	private Rectangle oldComponentInnards; // used to see if the size changed

	/** For bouncing-box animation, the change in position per frame. */
	private double delta = 0.0;

	private int maxPosition = 0; // maximum X (horiz) or Y box location

	public static ComponentUI createUI(JComponent b) {

		return INSTANCE;

	}

	public void installUI(JComponent c) {
		progressBar = (JProgressBar) c;
		installDefaults();
		installListeners();
		if (progressBar.isIndeterminate()) {
			initIndeterminateValues();
		}
	}

	public void uninstallUI(JComponent c) {
		if (progressBar.isIndeterminate()) {
			cleanUpIndeterminateValues();
		}
		uninstallDefaults();
		uninstallListeners();
		progressBar = null;
	}

	protected void installDefaults() {
		LookAndFeel.installProperty(progressBar, "opaque", Boolean.TRUE);
		LookAndFeel.installBorder(progressBar, "ProgressBar.border");
		LookAndFeel.installColorsAndFont(progressBar, "ProgressBar.background", "ProgressBar.foreground",
				"ProgressBar.font");
		cellLength = UIManager.getInt("ProgressBar.cellLength");
		if (cellLength == 0)
			cellLength = 1;
		cellSpacing = UIManager.getInt("ProgressBar.cellSpacing");
		selectionForeground = UIManager.getColor("ProgressBar.selectionForeground");
		selectionBackground = UIManager.getColor("ProgressBar.selectionBackground");
	}

	protected void uninstallDefaults() {
		LookAndFeel.uninstallBorder(progressBar);
	}

	protected void installListeners() {
		// Listen for changes in the progress bar's data.
		changeListener = getHandler();
		progressBar.addChangeListener(changeListener);

		// Listen for changes between determinate and indeterminate state.
		progressBar.addPropertyChangeListener(getHandler());
	}

	private Handler getHandler() {
		if (handler == null) {
			handler = new Handler();
		}
		return handler;
	}

	/**
	 * Starts the animation thread, creating and initializing it if necessary. This
	 * method is invoked when an indeterminate progress bar should start animating.
	 * Reasons for this may include:
	 * <ul>
	 * <li>The progress bar is determinate and becomes displayable
	 * <li>The progress bar is displayable and becomes determinate
	 * <li>The progress bar is displayable and determinate and this UI is installed
	 * </ul>
	 * If you implement your own animation thread, you must override this method.
	 *
	 * @since 1.4
	 * @see #stopAnimationTimer
	 */
	protected void startAnimationTimer() {
		if (animator == null) {
			animator = new Animator();
		}

		animator.start(getRepaintInterval());
	}

	/**
	 * Stops the animation thread. This method is invoked when the indeterminate
	 * animation should be stopped. Reasons for this may include:
	 * <ul>
	 * <li>The progress bar changes to determinate
	 * <li>The progress bar is no longer part of a displayable hierarchy
	 * <li>This UI in uninstalled
	 * </ul>
	 * If you implement your own animation thread, you must override this method.
	 *
	 * @since 1.4
	 * @see #startAnimationTimer
	 */
	protected void stopAnimationTimer() {
		if (animator != null) {
			animator.stop();
		}
	}

	/**
	 * Removes all listeners installed by this object.
	 */
	protected void uninstallListeners() {
		progressBar.removeChangeListener(changeListener);
		progressBar.removePropertyChangeListener(getHandler());
		handler = null;
	}

	/**
	 * Returns the baseline.
	 *
	 * @throws NullPointerException
	 *             {@inheritDoc}
	 * @throws IllegalArgumentException
	 *             {@inheritDoc}
	 * @see javax.swing.JComponent#getBaseline(int, int)
	 * @since 1.6
	 */
	public int getBaseline(JComponent c, int width, int height) {
		super.getBaseline(c, width, height);
		if (progressBar.isStringPainted() && progressBar.getOrientation() == JProgressBar.HORIZONTAL) {
			FontMetrics metrics = progressBar.getFontMetrics(progressBar.getFont());
			Insets insets = progressBar.getInsets();
			int y = insets.top;
			height = height - insets.top - insets.bottom;
			return y + (height + metrics.getAscent() - metrics.getLeading() - metrics.getDescent()) / 2;
		}
		return -1;
	}

	/**
	 * Returns an enum indicating how the baseline of the component changes as the
	 * size changes.
	 *
	 * @throws NullPointerException
	 *             {@inheritDoc}
	 * @see javax.swing.JComponent#getBaseline(int, int)
	 * @since 1.6
	 */
	public Component.BaselineResizeBehavior getBaselineResizeBehavior(JComponent c) {
		super.getBaselineResizeBehavior(c);
		if (progressBar.isStringPainted() && progressBar.getOrientation() == JProgressBar.HORIZONTAL) {
			return Component.BaselineResizeBehavior.CENTER_OFFSET;
		}
		return Component.BaselineResizeBehavior.OTHER;
	}

	// Many of the Basic*UI components have the following methods.
	// This component does not have these methods because *ProgressBarUI
	// is not a compound component and does not accept input.
	//
	// protected void installComponents()
	// protected void uninstallComponents()
	// protected void installKeyboardActions()
	// protected void uninstallKeyboardActions()

	protected Dimension getPreferredInnerHorizontal() {
		Dimension horizDim = (Dimension) progressBar.getPreferredSize();
		if (horizDim == null) {
			horizDim = new Dimension(146, 12);
		}
		return horizDim;
	}

	protected Dimension getPreferredInnerVertical() {
		Dimension vertDim = (Dimension) progressBar.getPreferredSize();
		if (vertDim == null) {
			vertDim = new Dimension(12, 146);
		}
		return vertDim;
	}

	/**
	 * The "selectionForeground" is the color of the text when it is painted over a
	 * filled area of the progress bar.
	 */
	protected Color getSelectionForeground() {
		return selectionForeground;
	}

	/**
	 * The "selectionBackground" is the color of the text when it is painted over an
	 * unfilled area of the progress bar.
	 */
	protected Color getSelectionBackground() {
		return selectionBackground;
	}

	private int getCachedPercent() {
		return cachedPercent;
	}

	private void setCachedPercent(int cachedPercent) {
		this.cachedPercent = cachedPercent;
	}

	/**
	 * Returns the width (if HORIZONTAL) or height (if VERTICAL) of each of the
	 * individual cells/units to be rendered in the progress bar. However, for text
	 * rendering simplification and aesthetic considerations, this function will
	 * return 1 when the progress string is being rendered.
	 *
	 * @return the value representing the spacing between cells
	 * @see #setCellLength
	 * @see JProgressBar#isStringPainted
	 */
	protected int getCellLength() {
		if (progressBar.isStringPainted()) {
			return 1;
		} else {
			return cellLength;
		}
	}

	protected void setCellLength(int cellLen) {
		this.cellLength = cellLen;
	}

	/**
	 * Returns the spacing between each of the cells/units in the progress bar.
	 * However, for text rendering simplification and aesthetic considerations, this
	 * function will return 0 when the progress string is being rendered.
	 *
	 * @return the value representing the spacing between cells
	 * @see #setCellSpacing
	 * @see JProgressBar#isStringPainted
	 */
	protected int getCellSpacing() {
		if (progressBar.isStringPainted()) {
			return 0;
		} else {
			return cellSpacing;
		}
	}

	protected void setCellSpacing(int cellSpace) {
		this.cellSpacing = cellSpace;
	}

	/**
	 * This determines the amount of the progress bar that should be filled based on
	 * the percent done gathered from the model. This is a common operation so it
	 * was abstracted out. It assumes that your progress bar is linear. That is, if
	 * you are making a circular progress indicator, you will want to override this
	 * method.
	 */
	protected int getAmountFull(Insets b, int width, int height) {
		int amountFull = 0;
		BoundedRangeModel model = progressBar.getModel();

		if ((model.getMaximum() - model.getMinimum()) != 0) {
			if (progressBar.getOrientation() == JProgressBar.HORIZONTAL) {
				amountFull = (int) Math.round(width * progressBar.getPercentComplete());
			} else {
				amountFull = (int) Math.round(height * progressBar.getPercentComplete());
			}
		}
		return amountFull;
	}

	/**
	 * Delegates painting to one of two methods: paintDeterminate or
	 * paintIndeterminate.
	 */
	public void paint(Graphics g, JComponent c) {
		if (progressBar.isIndeterminate()) {
			paintIndeterminate(g, c);
		} else {
			paintDeterminate(g, c);
		}
	}

	/**
	 * Stores the position and size of the bouncing box that would be painted for
	 * the current animation index in <code>r and returns r. Subclasses that add to
	 * the painting performed in this class's implementation of
	 * <code>paintIndeterminate -- to draw an outline around the bouncing box, for
	 * example -- can use this method to get the location of the bouncing box that
	 * was just painted. By overriding this method, you have complete control over
	 * the size and position of the bouncing box, without having to reimplement
	 * <code>paintIndeterminate.
	 *
	 * @param r
	 *            the Rectangle instance to be modified; may be <code>null
	 * @return <code>null if no box should be drawn; otherwise, returns the
	 *         passed-in rectangle (if non-null) or a new rectangle
	 *
	 * @see #setAnimationIndex
	 * @since 1.4
	 */
	protected Rectangle getBox(Rectangle r) {
		int currentFrame = getAnimationIndex();
		int middleFrame = numFrames / 2;

		if (sizeChanged() || delta == 0.0 || maxPosition == 0.0) {
			updateSizes();
		}

		r = getGenericBox(r);

		if (r == null) {
			return null;
		}
		if (middleFrame <= 0) {
			return null;
		}

		// assert currentFrame >= 0 && currentFrame < numFrames
		if (progressBar.getOrientation() == JProgressBar.HORIZONTAL) {
			if (currentFrame < middleFrame) {
				r.x = componentInnards.x + (int) Math.round(delta * (double) currentFrame);
			} else {
				r.x = maxPosition - (int) Math.round(delta * (currentFrame - middleFrame));
			}
		} else { // VERTICAL indeterminate progress bar
			if (currentFrame < middleFrame) {
				r.y = componentInnards.y + (int) Math.round(delta * currentFrame);
			} else {
				r.y = maxPosition - (int) Math.round(delta * (currentFrame - middleFrame));
			}
		}
		return r;
	}

	/**
	 * Updates delta, max position. Assumes componentInnards is correct (e.g. call
	 * after sizeChanged()).
	 */
	private void updateSizes() {
		int length = 0;

		if (progressBar.getOrientation() == JProgressBar.HORIZONTAL) {
			length = getBoxLength(componentInnards.width, componentInnards.height);
			maxPosition = componentInnards.x + componentInnards.width - length;

		} else { // VERTICAL progress bar
			length = getBoxLength(componentInnards.height, componentInnards.width);
			maxPosition = componentInnards.y + componentInnards.height - length;
		}

		// If we're doing bouncing-box animation, update delta.
		delta = 2.0 * (double) maxPosition / (double) numFrames;
	}

	/**
	 * Assumes that the component innards, max position, etc. are up-to-date.
	 */
	private Rectangle getGenericBox(Rectangle r) {
		if (r == null) {
			r = new Rectangle();
		}

		if (progressBar.getOrientation() == JProgressBar.HORIZONTAL) {
			r.width = getBoxLength(componentInnards.width, componentInnards.height);
			if (r.width < 0) {
				r = null;
			} else {
				r.height = componentInnards.height;
				r.y = componentInnards.y;
			}
			// end of HORIZONTAL

		} else { // VERTICAL progress bar
			r.height = getBoxLength(componentInnards.height, componentInnards.width);
			if (r.height < 0) {
				r = null;
			} else {
				r.width = componentInnards.width;
				r.x = componentInnards.x;
			}
		} // end of VERTICAL

		return r;
	}

	/**
	 * Returns the length of the "bouncing box" to be painted. This method is
	 * invoked by the default implementation of <code>paintIndeterminate to get the
	 * width (if the progress bar is horizontal) or height (if vertical) of the box.
	 * For example: <blockquote>
	 * 
	 * <pre>
	 * boxRect.width = getBoxLength(componentInnards.width, componentInnards.height);
	 * </pre>
	 * 
	 * </blockquote>
	 *
	 * @param availableLength
	 *            the amount of space available for the bouncing box to move in; for
	 *            a horizontal progress bar, for example, this should be the inside
	 *            width of the progress bar (the component width minus borders)
	 * @param otherDimension
	 *            for a horizontal progress bar, this should be the inside height of
	 *            the progress bar; this value might be used to constrain or
	 *            determine the return value
	 *
	 * @return the size of the box dimension being determined; must be no larger
	 *         than <code>availableLength
	 *
	 * @see javax.swing.SwingUtilities#calculateInnerArea
	 * @since 1.5
	 */
	protected int getBoxLength(int availableLength, int otherDimension) {
		return (int) Math.round(availableLength / 6.0);
	}

	/**
	 * All purpose paint method that should do the right thing for all linear
	 * bouncing-box progress bars. Override this if you are making another kind of
	 * progress bar.
	 *
	 * @see #paintDeterminate
	 *
	 * @since 1.4
	 */
	protected void paintIndeterminate(Graphics g, JComponent c) {
		if (!(g instanceof Graphics2D)) {
			return;
		}

		Insets b = progressBar.getInsets(); // area for border
		int barRectWidth = progressBar.getWidth() - (b.right + b.left);
		int barRectHeight = progressBar.getHeight() - (b.top + b.bottom);

		if (barRectWidth <= 0 || barRectHeight <= 0) {
			return;
		}

		Graphics2D g2 = (Graphics2D) g;

		// Paint the bouncing box.
		boxRect = getBox(boxRect);
		if (boxRect != null) {
			g2.setColor(progressBar.getForeground());
			g2.fillRect(boxRect.x, boxRect.y, boxRect.width, boxRect.height);
		}

		// Deal with possible text painting
		if (progressBar.isStringPainted()) {
			if (progressBar.getOrientation() == JProgressBar.HORIZONTAL) {
				paintString(g2, b.left, b.top, barRectWidth, barRectHeight, boxRect.x, boxRect.width, b);
			} else {
				paintString(g2, b.left, b.top, barRectWidth, barRectHeight, boxRect.y, boxRect.height, b);
			}
		}
	}

	/**
	 * All purpose paint method that should do the right thing for almost all
	 * linear, determinate progress bars. By setting a few values in the defaults
	 * table, things should work just fine to paint your progress bar. Naturally,
	 * override this if you are making a circular or semi-circular progress bar.
	 *
	 * @see #paintIndeterminate
	 *
	 * @since 1.4
	 */
	protected void paintDeterminate(Graphics g, JComponent c) {
		if (!(g instanceof Graphics2D)) {
			return;
		}

		Graphics2D g2d = (Graphics2D) g.create();

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		int iStrokWidth = 3;
		g2d.setStroke(new BasicStroke(iStrokWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g2d.setColor(c.getBackground());
		g2d.setBackground(c.getBackground());

		int width = c.getWidth();
		int height = c.getHeight();

		RoundRectangle2D outline = new RoundRectangle2D.Double((iStrokWidth / 2), (iStrokWidth / 2),
				width - iStrokWidth, height - iStrokWidth, height, height);

		g2d.draw(outline);

		int iInnerHeight = height - (iStrokWidth * 4);
		int iInnerWidth = width - (iStrokWidth * 4);

		iInnerWidth = (int) Math.round(iInnerWidth * renderProgress);

		int x = iStrokWidth * 2;
		int y = iStrokWidth * 2;

		Point2D start = new Point2D.Double(x, y);
		Point2D end = new Point2D.Double(x, y + iInnerHeight);

		float[] dist = { 0.0f, 0.25f, 1.0f };
		Color[] colors = { c.getBackground(), c.getBackground().brighter(), c.getBackground().darker() };
		LinearGradientPaint p = new LinearGradientPaint(start, end, dist, colors);

		g2d.setPaint(p);

		RoundRectangle2D fill = new RoundRectangle2D.Double(iStrokWidth * 2, iStrokWidth * 2, iInnerWidth, iInnerHeight,
				iInnerHeight, iInnerHeight);

		g2d.fill(fill);

		g2d.dispose();
	}

	protected void paintString(Graphics g, int x, int y, int width, int height, int amountFull, Insets b) {
		if (progressBar.getOrientation() == JProgressBar.HORIZONTAL) {
			// if (BasicGraphicsUtils.isLeftToRight(progressBar)) {
			if (progressBar.isIndeterminate()) {
				boxRect = getBox(boxRect);
				paintString(g, x, y, width, height, boxRect.x, boxRect.width, b);
			} else {
				paintString(g, x, y, width, height, x, amountFull, b);
			}
			// } else {
			// paintString(g, x, y, width, height, x + width - amountFull, amountFull, b);
			// }
		} else {
			if (progressBar.isIndeterminate()) {
				boxRect = getBox(boxRect);
				paintString(g, x, y, width, height, boxRect.y, boxRect.height, b);
			} else {
				paintString(g, x, y, width, height, y + height - amountFull, amountFull, b);
			}
		}
	}

	/**
	 * Paints the progress string.
	 *
	 * @param g
	 *            Graphics used for drawing.
	 * @param x
	 *            x location of bounding box
	 * @param y
	 *            y location of bounding box
	 * @param width
	 *            width of bounding box
	 * @param height
	 *            height of bounding box
	 * @param fillStart
	 *            start location, in x or y depending on orientation, of the filled
	 *            portion of the progress bar.
	 * @param amountFull
	 *            size of the fill region, either width or height depending upon
	 *            orientation.
	 * @param b
	 *            Insets of the progress bar.
	 */
	private void paintString(Graphics g, int x, int y, int width, int height, int fillStart, int amountFull, Insets b) {
		if (!(g instanceof Graphics2D)) {
			return;
		}

		Graphics2D g2 = (Graphics2D) g;
		String progressString = progressBar.getString();
		g2.setFont(progressBar.getFont());
		Point renderLocation = getStringPlacement(g2, progressString, x, y, width, height);
		Rectangle oldClip = g2.getClipBounds();

		if (progressBar.getOrientation() == JProgressBar.HORIZONTAL) {
			g2.setColor(getSelectionBackground());
			g2.drawString(progressString, renderLocation.x, renderLocation.y);
			g2.setColor(getSelectionForeground());
			g2.clipRect(fillStart, y, amountFull, height);
			g2.drawString(progressString, renderLocation.x, renderLocation.y);
		} else { // VERTICAL
			g2.setColor(getSelectionBackground());
			AffineTransform rotate = AffineTransform.getRotateInstance(Math.PI / 2);
			g2.setFont(progressBar.getFont().deriveFont(rotate));
			renderLocation = getStringPlacement(g2, progressString, x, y, width, height);
			g2.drawString(progressString, renderLocation.x, renderLocation.y);
			g2.setColor(getSelectionForeground());
			g2.clipRect(x, fillStart, width, amountFull);
			g2.drawString(progressString, renderLocation.x, renderLocation.y);
		}
		g2.setClip(oldClip);
	}

	/**
	 * Designate the place where the progress string will be painted. This
	 * implementation places it at the center of the progress bar (in both x and y).
	 * Override this if you want to right, left, top, or bottom align the progress
	 * string or if you need to nudge it around for any reason.
	 */
	protected Point getStringPlacement(Graphics g, String progressString, int x, int y, int width, int height) {
		FontMetrics fontSizer = g.getFontMetrics();

		int stringWidth = fontSizer.stringWidth(progressString);

		if (progressBar.getOrientation() == JProgressBar.HORIZONTAL) {
			return new Point(x + Math.round(width / 2 - stringWidth / 2),
					y + ((height + fontSizer.getAscent() - fontSizer.getLeading() - fontSizer.getDescent()) / 2));
		} else { // VERTICAL
			return new Point(
					x + ((width - fontSizer.getAscent() + fontSizer.getLeading() + fontSizer.getDescent()) / 2),
					y + Math.round(height / 2 - stringWidth / 2));
		}
	}

	public Dimension getPreferredSize(JComponent c) {
		Dimension size;
		Insets border = progressBar.getInsets();
		FontMetrics fontSizer = progressBar.getFontMetrics(progressBar.getFont());

		if (progressBar.getOrientation() == JProgressBar.HORIZONTAL) {
			size = new Dimension(getPreferredInnerHorizontal());
			// Ensure that the progress string will fit
			if (progressBar.isStringPainted()) {
				// I'm doing this for completeness.
				String progString = progressBar.getString();
				int stringWidth = c.getGraphics().getFontMetrics().stringWidth(progString);
				if (stringWidth > size.width) {
					size.width = stringWidth;
				}
				// This uses both Height and Descent to be sure that
				// there is more than enough room in the progress bar
				// for everything.
				// This does have a strange dependency on
				// getStringPlacememnt() in a funny way.
				int stringHeight = fontSizer.getHeight() + fontSizer.getDescent();
				if (stringHeight > size.height) {
					size.height = stringHeight;
				}
			}
		} else {
			size = new Dimension(getPreferredInnerVertical());
			// Ensure that the progress string will fit.
			if (progressBar.isStringPainted()) {
				String progString = progressBar.getString();
				int stringHeight = fontSizer.getHeight() + fontSizer.getDescent();
				if (stringHeight > size.width) {
					size.width = stringHeight;
				}
				// This is also for completeness.
				int stringWidth = fontSizer.stringWidth(progString);
				if (stringWidth > size.height) {
					size.height = stringWidth;
				}
			}
		}

		size.width += border.left + border.right;
		size.height += border.top + border.bottom;
		return size;
	}

	/**
	 * The Minimum size for this component is 10. The rationale here is that there
	 * should be at least one pixel per 10 percent.
	 */
	public Dimension getMinimumSize(JComponent c) {
		Dimension pref = getPreferredSize(progressBar);
		if (progressBar.getOrientation() == JProgressBar.HORIZONTAL) {
			pref.width = 10;
		} else {
			pref.height = 10;
		}
		return pref;
	}

	public Dimension getMaximumSize(JComponent c) {
		Dimension pref = getPreferredSize(progressBar);
		if (progressBar.getOrientation() == JProgressBar.HORIZONTAL) {
			pref.width = Short.MAX_VALUE;
		} else {
			pref.height = Short.MAX_VALUE;
		}
		return pref;
	}

	/**
	 * Gets the index of the current animation frame.
	 *
	 * @since 1.4
	 */
	protected int getAnimationIndex() {
		return animationIndex;
	}

	/**
	 * Returns the number of frames for the complete animation loop used by an
	 * indeterminate JProgessBar. The progress chunk will go from one end to the
	 * other and back during the entire loop. This visual behavior may be changed by
	 * subclasses in other Look and Feels.
	 *
	 * @return the number of frames
	 * @since 1.6
	 */
	// protected int getFrameCount() {
	// return numFrames;
	// }

	/**
	 * Sets the index of the current animation frame to the specified value and
	 * requests that the progress bar be repainted. Subclasses that don't use the
	 * default painting code might need to override this method to change the way
	 * that the <code>repaint method is invoked.
	 *
	 * @param newValue
	 *            the new animation index; no checking is performed on its value
	 * @see #incrementAnimationIndex
	 *
	 * @since 1.4
	 */
	protected void setAnimationIndex(int newValue) {
		if (animationIndex != newValue) {
			if (sizeChanged()) {
				animationIndex = newValue;
				maxPosition = 0; // needs to be recalculated
				delta = 0.0; // needs to be recalculated
				progressBar.repaint();
				return;
			}

			// Get the previous box drawn.
			nextPaintRect = getBox(nextPaintRect);

			// Update the frame number.
			animationIndex = newValue;

			// Get the next box to draw.
			if (nextPaintRect != null) {
				boxRect = getBox(boxRect);
				if (boxRect != null) {
					nextPaintRect.add(boxRect);
				}
			}
		} else { // animationIndex == newValue
			return;
		}

		if (nextPaintRect != null) {
			progressBar.repaint(nextPaintRect);
		} else {
			progressBar.repaint();
		}
	}

	private boolean sizeChanged() {
		if ((oldComponentInnards == null) || (componentInnards == null)) {
			return true;
		}

		oldComponentInnards.setRect(componentInnards);
		componentInnards = SwingUtilities.calculateInnerArea(progressBar, componentInnards);
		return !oldComponentInnards.equals(componentInnards);
	}

	/**
	 * Sets the index of the current animation frame, to the next valid value, which
	 * results in the progress bar being repainted. The next valid value is, by
	 * default, the current animation index plus one. If the new value would be too
	 * large, this method sets the index to 0. Subclasses might need to override
	 * this method to ensure that the index does not go over the number of frames
	 * needed for the particular progress bar instance. This method is invoked by
	 * the default animation thread every <em>X milliseconds, where <em>X is
	 * specified by the "ProgressBar.repaintInterval" UI default.
	 *
	 * @see #setAnimationIndex
	 * @since 1.4
	 */
	protected void incrementAnimationIndex() {
		int newValue = getAnimationIndex() + 1;

		if (newValue < numFrames) {
			setAnimationIndex(newValue);
		} else {
			setAnimationIndex(0);
		}
	}

	/**
	 * Returns the desired number of milliseconds between repaints. This value is
	 * meaningful only if the progress bar is in indeterminate mode. The repaint
	 * interval determines how often the default animation thread's timer is fired.
	 * It's also used by the default indeterminate progress bar painting code when
	 * determining how far to move the bouncing box per frame. The repaint interval
	 * is specified by the "ProgressBar.repaintInterval" UI default.
	 *
	 * @return the repaint interval, in milliseconds
	 */
	private int getRepaintInterval() {
		return repaintInterval;
	}

	private int initRepaintInterval() {
		// repaintInterval = DefaultLookup.getInt(progressBar, this,
		// "ProgressBar.repaintInterval", 50);
		// repaintInterval = progressBar.getGraphics().getInt( this,
		// "ProgressBar.repaintInterval", 50);
		// return repaintInterval;
		return 50;
	}

	/**
	 * Returns the number of milliseconds per animation cycle. This value is
	 * meaningful only if the progress bar is in indeterminate mode. The cycle time
	 * is used by the default indeterminate progress bar painting code when
	 * determining how far to move the bouncing box per frame. The cycle time is
	 * specified by the "ProgressBar.cycleTime" UI default and adjusted, if
	 * necessary, by the initIndeterminateDefaults method.
	 *
	 * @return the cycle time, in milliseconds
	 */
	@SuppressWarnings("unused")
	private int getCycleTime() {
		return cycleTime;
	}

	private int initCycleTime() {
		// cycleTime = DefaultLookup.getInt(progressBar, this, "ProgressBar.cycleTime",
		// 3000);
		// return cycleTime;
		return 5;
	}

	/** Initialize cycleTime, repaintInterval, numFrames, animationIndex. */
	private void initIndeterminateDefaults() {
		initRepaintInterval(); // initialize repaint interval
		initCycleTime(); // initialize cycle length

		// Make sure repaintInterval is reasonable.
		if (repaintInterval <= 0) {
			repaintInterval = 100;
		}

		// Make sure cycleTime is reasonable.
		if (repaintInterval > cycleTime) {
			cycleTime = repaintInterval * 20;
		} else {
			// Force cycleTime to be a even multiple of repaintInterval.
			int factor = (int) Math.ceil(((double) cycleTime) / ((double) repaintInterval * 2));
			cycleTime = repaintInterval * factor * 2;
		}
	}

	/**
	 * Invoked by PropertyChangeHandler.
	 *
	 * NOTE: This might not be invoked until after the first paintIndeterminate
	 * call.
	 */
	private void initIndeterminateValues() {
		initIndeterminateDefaults();
		// assert cycleTime/repaintInterval is a whole multiple of 2.
		numFrames = cycleTime / repaintInterval;
		initAnimationIndex();

		boxRect = new Rectangle();
		nextPaintRect = new Rectangle();
		componentInnards = new Rectangle();
		oldComponentInnards = new Rectangle();

		// we only bother installing the HierarchyChangeListener if we
		// are indeterminate
		progressBar.addHierarchyListener(getHandler());

		// start the animation thread if necessary
		if (progressBar.isDisplayable()) {
			startAnimationTimer();
		}
	}

	/** Invoked by PropertyChangeHandler. */
	private void cleanUpIndeterminateValues() {
		// stop the animation thread if necessary
		if (progressBar.isDisplayable()) {
			stopAnimationTimer();
		}

		cycleTime = repaintInterval = 0;
		numFrames = animationIndex = 0;
		maxPosition = 0;
		delta = 0.0;

		boxRect = nextPaintRect = null;
		componentInnards = oldComponentInnards = null;

		progressBar.removeHierarchyListener(getHandler());
	}

	// Called from initIndeterminateValues to initialize the animation index.
	// This assumes that numFrames is set to a correct value.
	private void initAnimationIndex() {
		// if ((progressBar.getOrientation() == JProgressBar.HORIZONTAL)
		// && (BasicGraphicsUtils.isLeftToRight(progressBar))) {
		// // If this is a left-to-right progress bar,
		// // start at the first frame.
		setAnimationIndex(0);
		// } else {
		// // If we go right-to-left or vertically, start at the right/bottom.
		// setAnimationIndex(numFrames / 2);
		// }
	}

	//
	// Animation Thread
	//
	/**
	 * Implements an animation thread that invokes repaint at a fixed rate. If
	 * ADJUSTTIMER is true, this thread will continuously adjust the repaint
	 * interval to try to make the actual time between repaints match the requested
	 * rate.
	 */
	private class Animator implements ActionListener {
		private Timer timer;
		private long previousDelay; // used to tune the repaint interval
		@SuppressWarnings("unused")
		private int interval; // the fixed repaint interval
		private long lastCall; // the last time actionPerformed was called
		private int MINIMUM_DELAY = 5;

		/**
		 * Creates a timer if one doesn't already exist, then starts the timer thread.
		 */
		private void start(int interval) {
			previousDelay = interval;
			lastCall = 0;

			if (timer == null) {
				timer = new Timer(interval, this);
			} else {
				timer.setDelay(interval);
			}

			if (ADJUSTTIMER) {
				timer.setRepeats(false);
				timer.setCoalesce(false);
			}

			timer.start();
		}

		/**
		 * Stops the timer thread.
		 */
		private void stop() {
			timer.stop();
		}

		/**
		 * Reacts to the timer's action events.
		 */
		public void actionPerformed(ActionEvent e) {
			if (ADJUSTTIMER) {
				long time = System.currentTimeMillis();

				if (lastCall > 0) { // adjust nextDelay
					// XXX maybe should cache this after a while
					// actual = time - lastCall
					// difference = actual - interval
					// nextDelay = previousDelay - difference
					// = previousDelay - (time - lastCall - interval)
					int nextDelay = (int) (previousDelay - time + lastCall + getRepaintInterval());
					if (nextDelay < MINIMUM_DELAY) {
						nextDelay = MINIMUM_DELAY;
					}
					timer.setInitialDelay(nextDelay);
					previousDelay = nextDelay;
				}
				timer.start();
				lastCall = time;
			}

			incrementAnimationIndex(); // paint next frame
		}
	}

	/**
	 * This class should be treated as a "protected" inner class. Instantiate it
	 * only within subclasses of {@code BasicProgressBarUI}.
	 */
	public class ChangeHandler implements ChangeListener {
		// NOTE: This class exists only for backward compatibility. All
		// its functionality has been moved into Handler. If you need to add
		// new functionality add it to the Handler, but make sure this
		// class calls into the Handler.
		public void stateChanged(ChangeEvent e) {
			getHandler().stateChanged(e);
		}
	}

	private class Handler implements ChangeListener, PropertyChangeListener, HierarchyListener {
		// ChangeListener
		public void stateChanged(ChangeEvent e) {
			BoundedRangeModel model = progressBar.getModel();
			int newRange = model.getMaximum() - model.getMinimum();
			int newPercent;
			int oldPercent = getCachedPercent();

			if (newRange > 0) {
				newPercent = (int) ((100 * (long) model.getValue()) / newRange);
			} else {
				newPercent = 0;
			}

			if (newPercent != oldPercent) {
				setCachedPercent(newPercent);
				progressBar.repaint();
			}
		}

		// PropertyChangeListener
		public void propertyChange(PropertyChangeEvent e) {
			String prop = e.getPropertyName();
			if ("indeterminate" == prop) {
				if (progressBar.isIndeterminate()) {
					initIndeterminateValues();
				} else {
					// clean up
					cleanUpIndeterminateValues();
				}
				progressBar.repaint();
			}
		}

		// we don't want the animation to keep running if we're not displayable
		public void hierarchyChanged(HierarchyEvent he) {
			if ((he.getChangeFlags() & HierarchyEvent.DISPLAYABILITY_CHANGED) != 0) {
				if (progressBar.isIndeterminate()) {
					if (progressBar.isDisplayable()) {
						startAnimationTimer();
					} else {
						stopAnimationTimer();
					}
				}
			}
		}
	}
}

// @Override
//
// public void paint(Graphics g, JComponent c) {
//
// JProgressBar button = (JProgressBar) c;
//
// if (!(g instanceof Graphics2D)) {
// return;
// }
//
// Graphics2D g2d = (Graphics2D) g;
//
//
// Insets b = progressBar.getInsets(); // area for border
// int barRectWidth = progressBar.getWidth() - (b.right + b.left);
// int barRectHeight = progressBar.getHeight() - (b.top + b.bottom);
// if (barRectWidth <= 0 || barRectHeight <= 0) {
// return;
// }
// int cellLength = getCellLength();
// int cellSpacing = getCellSpacing();
//
// int amountFull = getAmountFull(b, barRectWidth, barRectHeight);
//
// if (progressBar.getOrientation() == JProgressBar.HORIZONTAL) {
//
// float x = amountFull / (float) barRectWidth;
// g.setColor(Color.RED);
// g.fillRect(b.left, b.top, amountFull, barRectHeight);
//
// } else { // VERTICAL
//
// }
// if (progressBar.isStringPainted()) {
// paintString(g, b.left, b.top, barRectWidth, barRectHeight, amountFull, b);
// }
//
// super.paint(g, progressBar);
//
// }
