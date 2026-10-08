/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantsimulator.components;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.beans.BeanProperty;

import javax.swing.Icon;
import javax.swing.JButton;

/**
 *
 * @author lars
 */
public class RoundedButton extends JButton {

    private Shape shape;
    public int borderRadius = 200;

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
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, this.borderRadius, this.borderRadius);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        if (!this.isBorderPainted())
            return;
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, this.borderRadius, this.borderRadius);
    }

    @Override
    public boolean contains(Point p) {
        if (this.shape == null || !this.shape.getBounds().equals(getBounds())) {
            this.shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, this.borderRadius, 15);
        }
        return this.shape.contains(p);
    }

    public int getBorderRadius() {
        return this.borderRadius;
    }

    @BeanProperty(preferred = true, visualUpdate = true, description = "The border radius of the button")
    public void setBorderRadius(int borderRadius) {
        this.borderRadius = borderRadius;
        repaint();
    }

}
