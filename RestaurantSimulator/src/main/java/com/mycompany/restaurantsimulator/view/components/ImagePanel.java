package com.mycompany.restaurantsimulator.view.components;

import java.awt.Image;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

    public java.awt.Image image;
    public javax.swing.Icon icon;

    public ImagePanel() {
        super();
    }

    public ImagePanel(Image image) {
        super();
        this.image = image;
        this.icon = image != null ? new javax.swing.ImageIcon(image) : null;
    }

    public javax.swing.Icon getIcon() {
        return this.icon;
    }

    public void setIcon(javax.swing.Icon icon) {
        this.icon = icon;
        if (icon instanceof javax.swing.ImageIcon imageIcon) {
            this.image = imageIcon.getImage();
        } else {
            this.image = null;
        }
        repaint();
    }

    // Paint the picture to the panel and scale it to fit within the panel.
    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        if (this.icon != null) {
            this.image = ((javax.swing.ImageIcon) this.icon).getImage();
            g.drawImage(this.image, 0, 0, this.getWidth(), this.getHeight(), null);
        }
    }
}
