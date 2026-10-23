package com.mycompany.restaurantsimulator.view;

import com.mycompany.restaurantsimulator.models.GlobalEvents;
import com.mycompany.restaurantsimulator.models.enums.FoodType;
import com.mycompany.restaurantsimulator.view.components.ImagePanel;
import com.mycompany.restaurantsimulator.view.components.RoundedButton;
import com.mycompany.restaurantsimulator.view.components.TableButton;
import com.mycompany.restaurantsimulator.view.ui.ProgressCircleUI;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JProgressBar;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GUIContainer extends javax.swing.JFrame {

    private int stoveProgress = 0;
    private int furnaceProgress = 0;

    /**
     * Creates new form GUIContainer
     */
    public GUIContainer() {
        initComponents();

        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Restaurant Simulator");
    }

    public JButton getStove() {
        return stove;
    }

    public JButton getFurnace() {
        return furnace;
    }

    public RoundedButton getOrderButton() {
        return roundedButton3;
    }

    public JProgressBar getStoveProgressBar() {
        return this.stoveProgressBar;
    }

    public TableButton[] getTables() {
        return this.tables;
    }

    public JButton getNewCustomersButton() {
        return jButton2;
    }

    /**
     * Set the progress of the rectangular stove
     *
     * @param progress Between 0-100
     */
    public void setStoveProgress(int progress) {
        this.stoveProgressBar.setValue(progress);
        this.stoveProgress = progress;
    }

    /**
     * Set the progress of the circular stove
     *
     * @param progress Between 0-100
     */
    public void setFurnaceProgress(int progress) {
        this.furnaceProgressBar.setValue(progress);
        this.furnaceProgress = progress;
    }

    /**
     * Get the progress of the rectangular stove
     *
     * @return The progress, between 0-100
     */
    public int getStoveProgress() {
        return this.stoveProgress;
    }

    /**
     * Get the progress of the circular stove
     *
     * @return The progress, between 0-100
     */
    public int getStove2Progress() {
        return this.furnaceProgress;
    }

    public RoundedButton getInventoryButton() {
        return this.inventoryButton;
    }

    private void initComponents() {

        imagePanel2 = new ImagePanel();
        jButton2 = new javax.swing.JButton();
        roundedButton3 = new RoundedButton();
        stove = new RoundedButton();
        table1 = new TableButton(1);
        table2 = new TableButton(2);
        table3 = new TableButton(3);
        table4 = new TableButton(4);
        table5 = new TableButton(5);
        table6 = new TableButton(6);
        table7 = new TableButton(7);
        table8 = new TableButton(8);
        table9 = new TableButton(9);
        furnace = new RoundedButton();
        stoveProgressBar = new JProgressBar();
        furnaceProgressBar = new JProgressBar();
        furnacePane = new JLayeredPane();
        profitLabel = new JLabel();
        inventoryButton = new RoundedButton();

        tables = new TableButton[] { table1, table2, table3, table4, table5, table6,
            table7, table8, table9 };

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1300, 850));
        setResizable(false);
        setSize(new java.awt.Dimension(1300, 797));

        imagePanel2.setIcon(new ImageIcon(getClass().getResource(
            "/com/mycompany/restaurantsimulator/view/resources/background.jpg"))); // NOI18N
        imagePanel2.setOpaque(false);
        imagePanel2.setPreferredSize(new java.awt.Dimension(1300, 797));

        jButton2.setIcon(new ImageIcon(getClass().getResource(
            "/com/mycompany/restaurantsimulator/view/resources/4415238-200.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GlobalEvents.growButton(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                GlobalEvents.shrinkButton(evt);
            }
        });

        inventoryButton.setIcon(new ImageIcon(getClass().getResource(
            "/com/mycompany/restaurantsimulator/view/resources/backpack.png")));
        inventoryButton.setBorderPainted(false);
        inventoryButton.setContentAreaFilled(false);
        inventoryButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        inventoryButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                GlobalEvents.growButton(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                GlobalEvents.shrinkButton(e);
            }
        });
        inventoryButton.setPreferredSize(new Dimension(80, 80));

        roundedButton3.setBackground(new java.awt.Color(255, 255, 255));
        roundedButton3.setIcon(new javax.swing.ImageIcon(getClass()
            .getResource("/com/mycompany/restaurantsimulator/view/resources/order.png"))); // NOI18N
        roundedButton3.setBorderPainted(false);
        roundedButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        roundedButton3.setPreferredSize(new java.awt.Dimension(80, 80));
        roundedButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GlobalEvents.growButton(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                GlobalEvents.shrinkButton(evt);
            }
        });

        stove.setBorderPainted(true);
        stove.setContentAreaFilled(false);
        stove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stove.setBorderRadius(20);
        stove.setForeground(new java.awt.Color(0, 0, 0));
        stove.setBorderWidth(4);
        stove.setFill(false);
        stove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GlobalEvents.growButton(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                GlobalEvents.shrinkButton(evt);
            }
        });

        furnace.setBorderPainted(true);
        furnace.setContentAreaFilled(false);
        furnace.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        furnace.setBorderRadius(500);
        furnace.setForeground(new java.awt.Color(255, 0, 0));
        furnace.setBorderWidth(4);
        furnace.setFill(false);
        furnace.setPreferredSize(new Dimension(140, 140));
        furnace.setSize(new Dimension(140, 140));
        furnace.setBounds(5, 5, 140, 140);
        furnace.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GlobalEvents.growButton(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                GlobalEvents.shrinkButton(evt);
            }
        });
        furnace.setOpaque(false);

        furnaceProgressBar.setUI(new ProgressCircleUI());
        furnaceProgressBar.setSize(150, 150);
        furnaceProgressBar.setValue(0);
        furnaceProgressBar.setMaximum(100);
        furnaceProgressBar.setForeground(new java.awt.Color(0, 255, 0));
        furnaceProgressBar.setBorderPainted(false);

        furnacePane.setPreferredSize(new Dimension(160, 160));
        furnacePane.setOpaque(false);
        furnacePane.setBorder(null);
        furnacePane.add(furnace, 2, 0);
        furnacePane.add(furnaceProgressBar, 1, 0);

        profitLabel.setText("€" + profit);
        profitLabel.setFont(new Font("Arial", Font.BOLD, 20));

        javax.swing.GroupLayout imagePanel2Layout = new javax.swing.GroupLayout(
            imagePanel2);
        imagePanel2.setLayout(imagePanel2Layout);
        imagePanel2Layout.setHorizontalGroup(
            imagePanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(profitLabel, GroupLayout.PREFERRED_SIZE, 72,
                    GroupLayout.PREFERRED_SIZE)
                .addGroup(GroupLayout.Alignment.TRAILING,
                    imagePanel2Layout.createSequentialGroup()
                        .addGroup(imagePanel2Layout
                            .createParallelGroup(
                                GroupLayout.Alignment.LEADING)
                            .addGroup(imagePanel2Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(table4, GroupLayout.PREFERRED_SIZE, 72,
                                    GroupLayout.PREFERRED_SIZE)
                                .addGap(287, 287, 287)
                                .addComponent(table5, GroupLayout.PREFERRED_SIZE, 72,
                                    GroupLayout.PREFERRED_SIZE)
                                .addGap(277, 277, 277)
                                .addComponent(table6, GroupLayout.PREFERRED_SIZE, 72,
                                    GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87).addComponent(table7,
                                    GroupLayout.PREFERRED_SIZE, 72,
                                    GroupLayout.PREFERRED_SIZE))
                            .addGroup(imagePanel2Layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(table8, GroupLayout.PREFERRED_SIZE, 72,
                                    GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18).addComponent(table9,
                                    GroupLayout.PREFERRED_SIZE, 74,
                                    GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(
                            javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228,
                            Short.MAX_VALUE)
                        .addComponent(jButton2).addGap(26, 26, 26))
                .addGroup(
                    imagePanel2Layout.createSequentialGroup().addGap(
                        20, 20, 20).addComponent(roundedButton3,
                            GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                            GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING,
                    imagePanel2Layout.createSequentialGroup().addGap(335, 335, 335)
                        .addComponent(table3, GroupLayout.PREFERRED_SIZE, 72,
                            GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addComponent(table2, GroupLayout.PREFERRED_SIZE, 72,
                            GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(table1, GroupLayout.PREFERRED_SIZE, 72,
                            GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addGroup(imagePanel2Layout
                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(stove, GroupLayout.PREFERRED_SIZE, 145,
                                GroupLayout.PREFERRED_SIZE)
                            .addComponent(stoveProgressBar, GroupLayout.PREFERRED_SIZE,
                                145, GroupLayout.PREFERRED_SIZE))
                        .addGap(407, 407, 407))
                .addGroup(imagePanel2Layout.createSequentialGroup().addGap(587, 587, 587)
                    .addComponent(furnacePane, GroupLayout.PREFERRED_SIZE,
                        GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(400, 400, 400).addComponent(inventoryButton,
                        GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)));

        imagePanel2Layout.setVerticalGroup(imagePanel2Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(imagePanel2Layout.createSequentialGroup().addGroup(imagePanel2Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(profitLabel, GroupLayout.PREFERRED_SIZE, 20,
                    GroupLayout.PREFERRED_SIZE)
                .addGroup(imagePanel2Layout.createSequentialGroup().addGap(121, 121, 121)
                    .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 105,
                        GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                .addGroup(imagePanel2Layout.createSequentialGroup()
                    .addGroup(imagePanel2Layout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(imagePanel2Layout.createSequentialGroup()
                            .addGap(109, 109, 109).addComponent(table4,
                                GroupLayout.PREFERRED_SIZE, 63,
                                GroupLayout.PREFERRED_SIZE))
                        .addGroup(
                            imagePanel2Layout.createSequentialGroup().addGap(72, 72, 72)
                                .addComponent(table5, GroupLayout.PREFERRED_SIZE, 63,
                                    GroupLayout.PREFERRED_SIZE))
                        .addGroup(
                            imagePanel2Layout.createSequentialGroup().addGap(64, 64, 64)
                                .addGroup(imagePanel2Layout
                                    .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(table6, GroupLayout.PREFERRED_SIZE, 63,
                                        GroupLayout.PREFERRED_SIZE)
                                    .addComponent(table7, GroupLayout.PREFERRED_SIZE, 63,
                                        GroupLayout.PREFERRED_SIZE))))
                    .addGroup(imagePanel2Layout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(imagePanel2Layout.createSequentialGroup()
                            .addGap(107, 107, 107)
                            .addComponent(stove, GroupLayout.PREFERRED_SIZE, 47,
                                GroupLayout.PREFERRED_SIZE)
                            .addComponent(stoveProgressBar))
                        .addGroup(
                            imagePanel2Layout.createSequentialGroup().addGap(47, 47, 47)
                                .addGroup(imagePanel2Layout
                                    .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(table1, GroupLayout.PREFERRED_SIZE, 63,
                                        GroupLayout.PREFERRED_SIZE)
                                    .addComponent(table2, GroupLayout.PREFERRED_SIZE, 63,
                                        GroupLayout.PREFERRED_SIZE)
                                    .addComponent(table3, GroupLayout.PREFERRED_SIZE, 63,
                                        GroupLayout.PREFERRED_SIZE))))))
                .addGap(120, 120, 120)
                .addComponent(furnacePane, GroupLayout.PREFERRED_SIZE,
                    GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(imagePanel2Layout
                    .createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(table8, GroupLayout.PREFERRED_SIZE, 63,
                        GroupLayout.PREFERRED_SIZE)
                    .addComponent(table9, GroupLayout.PREFERRED_SIZE, 63,
                        GroupLayout.PREFERRED_SIZE))

                .addGap(10, 10, 10)
                .addGroup(
                    imagePanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(roundedButton3, GroupLayout.PREFERRED_SIZE,
                            GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(inventoryButton, GroupLayout.PREFERRED_SIZE, 80,
                            GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout
            .setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                    .addComponent(imagePanel2, GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup().addContainerGap()
                .addComponent(imagePanel2, GroupLayout.PREFERRED_SIZE,
                    GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(197, Short.MAX_VALUE)));

        pack();
    }

    private com.mycompany.restaurantsimulator.view.components.ImagePanel imagePanel2;
    private com.mycompany.restaurantsimulator.view.components.RoundedButton stove;
    private javax.swing.JButton jButton2;
    private com.mycompany.restaurantsimulator.view.components.TableButton table1;
    private com.mycompany.restaurantsimulator.view.components.TableButton table5;
    private com.mycompany.restaurantsimulator.view.components.TableButton table6;
    private com.mycompany.restaurantsimulator.view.components.TableButton table7;
    private com.mycompany.restaurantsimulator.view.components.TableButton table8;
    private com.mycompany.restaurantsimulator.view.components.TableButton table9;
    private com.mycompany.restaurantsimulator.view.components.RoundedButton roundedButton3;
    private com.mycompany.restaurantsimulator.view.components.TableButton table2;
    private com.mycompany.restaurantsimulator.view.components.TableButton table3;
    private com.mycompany.restaurantsimulator.view.components.TableButton table4;
    private javax.swing.JProgressBar stoveProgressBar;
    private TableButton[] tables;
    private com.mycompany.restaurantsimulator.view.components.RoundedButton furnace;
    private javax.swing.JProgressBar furnaceProgressBar;
    private javax.swing.JLayeredPane furnacePane;
    private double profit = 0;
    private JLabel profitLabel;
    private RoundedButton inventoryButton;

    public void turnTableGreen(int id) {
        TableButton tableButton = Arrays.stream(tables)
            .filter(t -> t.getTableNumber() == id).findFirst().orElse(null);
        if (tableButton == null) {
            throw new RuntimeException("Table number not found");
        }
        tableButton.setForeground(new java.awt.Color(0, 255, 0));
    }

    public void turnTableRed(int id) {
        TableButton tableButton = Arrays.stream(tables)
            .filter(t -> t.getTableNumber() == id).findFirst().orElse(null);

        if (tableButton == null) {
            throw new RuntimeException("Table number not found");
        }
        tableButton.setForeground(new java.awt.Color(255, 0, 0));
    }

    public void returnTableToNormal(int id) {
        TableButton tableButton = Arrays.stream(tables)
            .filter(t -> t.getTableNumber() == id).findFirst().orElse(null);

        if (tableButton == null) {
            throw new RuntimeException("Table number not found");
        }

        tableButton.setForeground(new java.awt.Color(0, 0, 0));
    }

    public void setProfit(double profit) {
        this.profit = profit;
        updateProfit();
    }

    private void updateProfit() {
        profitLabel.setText("€" + profit);
    }

    public void setCookingProgress(int progress, FoodType foodType) {
        switch (foodType) {
            case FoodType.Stove: {
                setStoveProgress(progress);
                break;
            }
            case FoodType.Furnace: {
                setFurnaceProgress(progress);
                break;
            }
            default: {
                break;
            }
        }
    }

}
