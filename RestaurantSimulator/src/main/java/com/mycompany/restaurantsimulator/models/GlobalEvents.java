package com.mycompany.restaurantsimulator.models;

import java.awt.Dimension;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class GlobalEvents {
    public static int sizeIncrement = 4;

    /**
     * Grow the button on mouseEnter
     */
    public static void growButton(MouseEvent evt) {
        growButton((JButton) evt.getComponent());
    }

    /**
     * Grow the button on mouseEnter
     */
    public static void growButton(JButton button) {
        button.setSize(
                new Dimension(button.getWidth() + sizeIncrement, button.getHeight() + sizeIncrement));
        button.setLocation(button.getLocation().x - sizeIncrement / 2, button.getLocation().y - sizeIncrement / 2);
    }

    /**
     * Shrink the button on mouseEnter
     */
    public static void shrinkButton(MouseEvent evt) {
        shrinkButton((JButton) evt.getComponent());
    }

    /**
     * Grow the button on mouseEnter
     */
    public static void shrinkButton(JButton button) {
        button.setSize(
                new Dimension(button.getWidth() - sizeIncrement, button.getHeight() - sizeIncrement));
        button.setLocation(button.getLocation().x + sizeIncrement / 2, button.getLocation().y + sizeIncrement / 2);
    }
}
