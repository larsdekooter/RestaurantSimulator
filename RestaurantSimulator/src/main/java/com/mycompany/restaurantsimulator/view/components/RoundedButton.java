
package com.mycompany.restaurantsimulator.view.components;

import com.mycompany.restaurantsimulator.models.enums.CursorType;
import java.awt.BasicStroke;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.RoundRectangle2D;
import java.beans.BeanProperty;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 * https://stackoverflow.com/questions/8515601/java-swing-rounded-border-for-jtextfield
 * 
 * @author lars
 */
public class RoundedButton extends JButton {

    private Shape shape;
    public int borderRadius = 200;
    public boolean fill = true;
    public int borderWidth = 1;

    public RoundedButton() {
        super();
        setOpaque(false);
        setContentAreaFilled(false);
    }

    public RoundedButton(int borderRadius) {
        super();
        this.borderRadius = borderRadius;
        setOpaque(false);
        setContentAreaFilled(false);
    }

    public RoundedButton(int borderRadius, Icon icon) {
        super(icon);
        this.borderRadius = borderRadius;
        setOpaque(false);
        setContentAreaFilled(false);
    }

    public RoundedButton(Icon icon) {
        super(icon);
        setOpaque(false);
        setContentAreaFilled(false);
    }

    public RoundedButton(int borderRadius, String text) {
        super(text);
        this.borderRadius = borderRadius;
        setOpaque(false);
        setContentAreaFilled(false);
    }

    public RoundedButton(String text) {
        super(text);
        setOpaque(false);
        setContentAreaFilled(false);
    }

    public RoundedButton(int borderRadius, String text, Icon icon) {
        super(text, icon);
        this.borderRadius = borderRadius;
        setOpaque(false);
        setContentAreaFilled(false);
    }

    public RoundedButton(String text, Icon icon) {
        super(text, icon);
        setOpaque(false);
        setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (!this.fill) {
            return;
        }
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, this.borderRadius,
            this.borderRadius);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        if (!this.isBorderPainted()) {
            return;
        }

        Graphics2D g2 = (Graphics2D) g;
        Stroke oldStroke = g2.getStroke();

        g2.setStroke(new BasicStroke(this.borderWidth));
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, this.borderRadius,
            this.borderRadius);

        g2.setStroke(oldStroke);
    }

    @Override
    public boolean contains(Point p) {
        if (this.shape == null || !this.shape.getBounds().equals(getBounds())) {
            this.shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1,
                this.borderRadius, 15);
        }
        return this.shape.contains(p);
    }

    public int getBorderRadius() {
        return this.borderRadius;
    }

    public void setBorderRadius(int borderRadius) {
        this.borderRadius = borderRadius;
        repaint();
    }

    @BeanProperty(preferred = false, visualUpdate = true, description = "The cursor on hover")
    public void setCursor(CursorType type) {
        this.setCursor(Cursor.getPredefinedCursor(type.getType()));
    }

    public void setFill(boolean filled) {
        this.fill = filled;
    }

    public boolean getFill() {
        return this.fill;
    }

    public void setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
    }

    public int getBorderWidth() {
        return this.borderWidth;
    }
}
