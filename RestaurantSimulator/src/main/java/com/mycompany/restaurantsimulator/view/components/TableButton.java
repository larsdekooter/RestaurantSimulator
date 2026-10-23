package com.mycompany.restaurantsimulator.view.components;

import com.mycompany.restaurantsimulator.models.GlobalEvents;

/**
 * The class for the tables. TableButton
 */
public class TableButton extends RoundedButton {
    private int tableNumber;

    public TableButton(int tableNumber) {
        this.tableNumber = tableNumber;
        super();
        setBorderRadius(20);
        setForeground(new java.awt.Color(0, 0, 0));
        setBorderWidth(4);
        setFill(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GlobalEvents.growButton(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                GlobalEvents.shrinkButton(evt);
            }

        });
    }

    public int getTableNumber() {
        return this.tableNumber;
    }

}
