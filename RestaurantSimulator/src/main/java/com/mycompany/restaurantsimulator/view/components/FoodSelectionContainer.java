
package com.mycompany.restaurantsimulator.view.components;

import com.mycompany.restaurantsimulator.models.Menu;
import com.mycompany.restaurantsimulator.models.enums.FoodType;
import com.mycompany.restaurantsimulator.models.menuItems.Food;
import com.mycompany.restaurantsimulator.models.menuItems.MenuItem;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.SwingConstants;

public class FoodSelectionContainer extends javax.swing.JFrame {

    private Menu menu;

    private ArrayList<MenuItem> menuItems = new ArrayList<>();
    private FoodType foodType;

    /**
     * Creates new form FoodSelection
     */
    public FoodSelectionContainer(Menu menu) {
        this.menu = menu;
        initComponents();
        menuItems.addAll(Arrays.asList(menu.foods));
        updateList(menuItems);
    }

    public FoodSelectionContainer(ArrayList<MenuItem> inventory) {
        initComponents();
        menuItems.addAll(inventory);
        updateList(menuItems);

    }

    public FoodSelectionContainer() {
        this.menu = new Menu();
        initComponents();
    }

    /**
     * Repopulates the list
     * 
     * @param type
     */
    public void setFoodType(FoodType type) {
        this.foodType = type;
        menuItems.clear();
        for (Food item : this.menu.foods) {
            if (item.getFoodType() == type) {
                menuItems.add(item);
            }
        }
        updateList(menuItems);
    }

    private void initComponents() {
        setPreferredSize(new Dimension(300, 300));
        jScrollPane1 = new javax.swing.JScrollPane();
        foodList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Food Selection");

        foodList.setModel(new javax.swing.DefaultListModel<>());

        updateList(menuItems);

        DefaultListCellRenderer renderer = (DefaultListCellRenderer) foodList
            .getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        jScrollPane1.setViewportView(foodList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                    .addComponent(jScrollPane1).addContainerGap()));

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout
                    .createSequentialGroup().addContainerGap().addComponent(jScrollPane1,
                        javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addContainerGap()));

        pack();
    }

    private void updateList(ArrayList<MenuItem> menuItems) {
        DefaultListModel<String> model = (DefaultListModel<String>) foodList.getModel();
        model.clear();
        for (MenuItem item : menuItems) {
            model.addElement(item.name);

        }
    }

    public JList<String> getFoodList() {
        return foodList;
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    private javax.swing.JList<String> foodList;
    private javax.swing.JScrollPane jScrollPane1;
}
