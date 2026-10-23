
package com.mycompany.restaurantsimulator.view.components;

import com.mycompany.restaurantsimulator.models.Order;
import com.mycompany.restaurantsimulator.models.menuItems.MenuItem;
import com.mycompany.restaurantsimulator.view.GUIContainer;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;

public class OrderContainer extends javax.swing.JDialog implements WindowListener {

    private Map<Integer, Order> orders = new HashMap<>();
    private int nTables;
    private String[] tableNames;
    private GUIContainer frame;

    /**
     * Creates new form OrderContainer
     */
    public OrderContainer(int nTables, GUIContainer frame) {
        this.nTables = nTables;
        this.tableNames = new String[this.nTables];
        this.frame = frame;
        for (int i = 0; i < nTables; i++) {
            orders.put(i, null);
            tableNames[i] = "Table " + (i + 1);
        }

        initComponents();
        addWindowListener(this);
    }

    public void setOrders(Map<Integer, Order> orders) {
        this.orders = orders;
        updateTableSelection(null);
    }

    private void initComponents() {

        jComboBox2 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Orders");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(tableNames));
        jComboBox2.addActionListener(this::updateTableSelection);

        jList1.setModel(new javax.swing.DefaultListModel<String>());
        updateTableSelection(null);
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                    .addGroup(layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jComboBox2, 0, 388, Short.MAX_VALUE)
                        .addComponent(jScrollPane1))
                    .addContainerGap()));
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(11, Short.MAX_VALUE)));

        pack();
    }

    private void updateTableSelection(java.awt.event.ActionEvent evt) {
        int selectedIndex = jComboBox2.getSelectedIndex() + 1;
        DefaultListModel<String> model = (DefaultListModel<String>) jList1.getModel();
        model.clear();
        if (selectedIndex != -1 && orders.containsKey(selectedIndex)) {
            Order order = orders.get(selectedIndex);
            if (order == null) {
                return;
            }
            for (MenuItem item : order.items) {
                model.addElement(item.toString());
            }
        }
    }

    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        frame.setEnabled(true);
        frame.setVisible(true);
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
