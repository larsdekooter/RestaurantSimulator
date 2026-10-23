package controllers;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mycompany.restaurantsimulator.models.Menu;
import com.mycompany.restaurantsimulator.models.Restaurant;
import com.mycompany.restaurantsimulator.models.Table;
import com.mycompany.restaurantsimulator.models.customers.Customer;
import com.mycompany.restaurantsimulator.models.customers.WealthyCustomer;
import com.mycompany.restaurantsimulator.models.enums.FoodType;
import com.mycompany.restaurantsimulator.models.menuItems.Food;
import com.mycompany.restaurantsimulator.models.stoves.Furnace;
import com.mycompany.restaurantsimulator.models.stoves.Stove;
import com.mycompany.restaurantsimulator.view.GUIContainer;
import com.mycompany.restaurantsimulator.view.components.CustomerContainer;
import com.mycompany.restaurantsimulator.view.components.FoodSelectionContainer;
import com.mycompany.restaurantsimulator.view.components.OrderContainer;
import com.mycompany.restaurantsimulator.view.components.TableButton;

public class RestaurantController {

    public Restaurant model;
    public FoodSelectionContainer foodSelectionContainer;
    public OrderContainer orderContainer;
    public GUIContainer view;
    public CustomerContainer customerContainer;
    private int seatingCustomer;
    private Stove stove = new Stove(0, null, 0);
    private Furnace furnace = new Furnace(1, null, 0);

    public RestaurantController(Restaurant model, GUIContainer view) {
        this.model = model;
        this.view = view;
        this.foodSelectionContainer = new FoodSelectionContainer(model.getMenu());
        this.orderContainer = new OrderContainer(model.getTables().length);
        this.customerContainer = new CustomerContainer(view);
        this.seatingCustomer = -1;

        view.getStove().addActionListener((e) -> {
            foodSelectionContainer.setVisible(true);
            foodSelectionContainer.setFoodType(FoodType.Stove);
        });
        view.getFurnace().addActionListener((e) -> {
            foodSelectionContainer.setVisible(true);
            foodSelectionContainer.setFoodType(FoodType.Furnace);
        });

        view.getNewCustomersButton().addActionListener(this::seatCustomer);

        view.getOrderButton().addActionListener((e) -> orderContainer.setVisible(true));

        customerContainer.getRetrieveOrderButton().addActionListener(this::retrieveOrder);

        for (TableButton table : view.getTables()) {
            table.addActionListener(e -> tableClicked(e, table));
        }

        foodSelectionContainer.getFoodList().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                handleFoodSelection(e);
            }
        });
    }

    private void seatCustomer(ActionEvent e) {
        Customer customer = model.getNextCustomer();

        seatingCustomer = customer.id;

        for (Table table : model.getTables()) {
            if (table.customer == null && table.seats >= customer.partySize) {
                view.turnTableGreen(table.id);
            } else {
                view.turnTableRed(table.id);
            }
        }
    }

    private void retrieveOrder(ActionEvent e) {
        int tableNumber = customerContainer.tableNumber;
        Table table = model.getTable(tableNumber);

        if (table == null) {
            throw new Error("No table could be found!");
        }
        model.addOrder(tableNumber, table.customer.getOrder(new Menu()));
        this.orderContainer.setOrders(model.getOrders());
        customerContainer.hideDialog();
    }

    private void tableClicked(ActionEvent e, TableButton table) {
        if (seatingCustomer == -1) {
            Table foundTable = model.getTable(table.getTableNumber());

            if (foundTable == null) {
                throw new Error("No table found");
            }

            if (foundTable.customer == null)
                return;
            setupTableView(table);
        } else {
            boolean seated = model.seatCustomer(seatingCustomer, table.getTableNumber());
            seatingCustomer = -1;

            if (!seated) {
                Toolkit.getDefaultToolkit().beep();
            }

            for (TableButton tableButton : view.getTables()) {
                view.returnTableToNormal(tableButton.getTableNumber());
            }
        }
    }

    private void setupTableView(TableButton table) {
        Table clickedTable = model.getTable(table.getTableNumber());
        customerContainer.openTableView(clickedTable);
        view.setEnabled(false);
        customerContainer.setLocationRelativeTo(table);

        customerContainer.getServeCheckButton().addActionListener((e) -> model.settleTable(table.getTableNumber()));
    }

    public void setRectangularStoveProgress(int progress) {
        view.setStoveProgress(progress);
    }

    public void setCircularStoveProgress(int progress) {
        view.setFurnaceProgress(progress);
    }

    public void handleFoodSelection(ListSelectionEvent e) {
        int foodIndex = foodSelectionContainer.getFoodList().getSelectedIndex();
        if (foodIndex < 0)
            return;
        try {
            Food selectedFood = foodSelectionContainer.getMenuItems().get(foodIndex);
            Stove cooker;
            switch (foodSelectionContainer.getFoodType()) {
            case FoodType.Stove:
                cooker = stove;

                break;
            case FoodType.Furnace:
                cooker = furnace;
                break;
            default:
                // Should never reach, but for typesafety
                cooker = stove;
                break;
            }
            boolean result = cooker.setCooking(selectedFood);
            if (!result)
                return;
            foodSelectionContainer.dispose();
            Timer swingTimer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    cooker.addSecond();
                    view.setCookingProgress(cooker.getPercentageDone(), selectedFood.getFoodType());

                    if (cooker.checkTimer()) {
                        ((javax.swing.Timer) e.getSource()).stop();
                        cooker.removeItem();
                        model.addItemToInventory(selectedFood);
                    }
                }

            });
            swingTimer.start();
        } catch (IndexOutOfBoundsException exc) {
            System.out.println(exc);
        }
    }
}
