package com.mycompany.restaurantsimulator.components;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author lars
 */
import java.beans.BeanProperty;

public class ImagePanel extends javax.swing.JPanel {

    public java.awt.Image image;
    public javax.swing.Icon icon;

    public ImagePanel() {
        super();
    }

    public ImagePanel(java.awt.Image image) {
        System.out.println(image);
        super();
        this.image = image;
        this.icon = image != null ? new javax.swing.ImageIcon(image) : null;
        java.awt.Dimension size = new java.awt.Dimension(image.getHeight(null), image.getWidth(null));
        setPreferredSize(size);
        setSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
    }

    public javax.swing.Icon getIcon() {
        return this.icon;
    }

    @BeanProperty(preferred = true, visualUpdate = true, description
            = "The icon this component will display.")
    public void setIcon(javax.swing.Icon icon) {
        System.out.println(icon);
        this.icon = icon;
        if (icon instanceof javax.swing.ImageIcon) {
            this.image = ((javax.swing.ImageIcon) icon).getImage();
        } else {
            this.image = null;
        }
        repaint();
    }

    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        //TODO: scale image
        if (this.icon != null) {
            this.image = ((javax.swing.ImageIcon) this.icon).getImage();//.getScaledInstance(WIDTH, HEIGHT, java.awt.Image.SCALE_DEFAULT);
            g.drawImage(this.image, 0, 0, this.image.getHeight(null), this.image.getWidth(null), null);
        }
    }
}
