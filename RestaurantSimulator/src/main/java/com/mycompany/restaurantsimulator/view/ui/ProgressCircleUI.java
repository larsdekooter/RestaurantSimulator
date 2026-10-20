package com.mycompany.restaurantsimulator.view.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicProgressBarUI;

public class ProgressCircleUI extends BasicProgressBarUI {
    private static int BAR_WIDTH = 5;
    // Mutliplier to calculate the diameter for the inner circles diameter.
    private float multiplier = 0.9f;

    private int diameter;
    private double xCenter;
    private double yCenter;
    private double outerRadius;
    private double innerRadius;

    public void calculateMultiplier() {
        int diameter = Math.min(progressBar.getWidth(), progressBar.getHeight());
        if (diameter == 0)
            return;
        float innerCircleDiameter = diameter - BAR_WIDTH;
        multiplier = innerCircleDiameter / diameter;
    }

    private void calculateCircleValues(Insets insets, int barRecHeight, int barRecWidth) {
        diameter = Math.min(barRecWidth, barRecHeight);
        xCenter = insets.left + barRecWidth * .5;
        yCenter = insets.top + barRecHeight * .5;
        outerRadius = diameter * .5;
        innerRadius = outerRadius * multiplier;
    }

    @Override
    public Dimension getPreferredSize(JComponent c) {
        Dimension d = super.getPreferredSize(c);
        int v = Math.max(d.width, d.height);
        d.setSize(v, v);
        return d;
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        Insets b = progressBar.getInsets();
        int barRecWidth = progressBar.getWidth();
        int barRecHeight = progressBar.getHeight();
        if (barRecWidth <= 0 || barRecHeight <= 0)
            return;

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(progressBar.getForeground());

        double degrees = 360 * progressBar.getPercentComplete();
        calculateMultiplier();
        calculateCircleValues(b, barRecHeight, barRecWidth);
        Shape inner = new Ellipse2D.Double(xCenter - innerRadius, yCenter - innerRadius, innerRadius * 2,
                innerRadius * 2);
        Shape outer = new Arc2D.Double(xCenter - outerRadius, yCenter - outerRadius, diameter, diameter, 90 - degrees,
                degrees, Arc2D.PIE);

        Area area = new Area(outer);
        // This area is now the circle, with a width of BAR_WIDTH and a transparent
        // center.
        area.subtract(new Area(inner));

        g2.fill(area);
        g2.dispose();

        if (progressBar.isStringPainted()) {
            paintString(g, b.left, b.top, barRecWidth, barRecHeight, 0, b);
        }

    }

    @Override
    protected void installDefaults() {
        super.installDefaults();
        progressBar.setOpaque(false);
    }
}
