
package com.mycompany.restaurantsimulator.view.components;

import com.mycompany.restaurantsimulator.models.menuItems.MenuItem;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class InventoryContainer extends javax.swing.JDialog {

    /**
     * Creates new form InventoryScreen
     */
    public InventoryContainer() {
        setVisible(false);
        initComponents();
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        jList1.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        jList1.setModel(new DefaultListModel<String>());
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout
                    .createSequentialGroup().addContainerGap().addComponent(jScrollPane1,
                        javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addContainerGap()));
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1));

        pack();
    }

    // Repopulates the list
    public void updateList(ArrayList<MenuItem> items) {
        DefaultListModel<String> model = (DefaultListModel<String>) jList1.getModel();
        model.clear();
        for (MenuItem item : items) {
            model.addElement(item.name);
        }
    }

    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
}
