
package com.mycompany.restaurantsimulator.view.components;

import java.awt.Color;

public class SuccesDialog extends javax.swing.JDialog {

    /**
     * Creates new form SuccesDialog
     */
    public SuccesDialog() {
        initComponents();
        setTitle("Succes!");
        setVisible(false);
    }

    private void initComponents() {

        label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        label.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        label.setForeground(new Color(0, 0, 0));
        label.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout
            .setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                        .createSequentialGroup().addContainerGap().addComponent(label,
                            javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                        .addContainerGap()));
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout
                    .createSequentialGroup().addContainerGap().addComponent(label,
                        javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addContainerGap()));

        pack();
    }

    public javax.swing.JLabel label;
}
