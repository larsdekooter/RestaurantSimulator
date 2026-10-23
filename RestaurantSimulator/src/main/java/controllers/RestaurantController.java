package controllers;

import java.awt.Component;
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
import com.mycompany.restaurantsimulator.models.enums.FoodType;
import com.mycompany.restaurantsimulator.models.menuItems.Food;
import com.mycompany.restaurantsimulator.models.stoves.Furnace;
import com.mycompany.restaurantsimulator.models.stoves.Stove;
import com.mycompany.restaurantsimulator.view.GUIContainer;
import com.mycompany.restaurantsimulator.view.components.CustomerContainer;
import com.mycompany.restaurantsimulator.view.components.FoodSelectionContainer;
import com.mycompany.restaurantsimulator.view.components.InventoryContainer;
import com.mycompany.restaurantsimulator.view.components.OrderContainer;
import com.mycompany.restaurantsimulator.view.components.SuccesDialog;
import com.mycompany.restaurantsimulator.view.components.TableButton;

public class RestaurantController {
    // The duration of the progress bar animation in ms
    public static int ANIMATION_DURATION = 20;

    public Restaurant model;
    public FoodSelectionContainer foodSelectionContainer;
    public OrderContainer orderContainer;
    public GUIContainer view;
    public CustomerContainer customerContainer;
    public InventoryContainer inventoryContainer;
    public SuccesDialog succesDialog;

    private int seatingCustomer;
    private Stove stove = new Stove(0, null, 0);
    private Furnace furnace = new Furnace(1, null, 0);

    public RestaurantController(Restaurant model, GUIContainer view) {
        this.model = model;
        this.view = view;
        this.foodSelectionContainer = new FoodSelectionContainer(model.getMenu());
        this.inventoryContainer = new InventoryContainer();
        this.orderContainer = new OrderContainer(model.getTables().length, view);
        this.customerContainer = new CustomerContainer(view);
        this.inventoryContainer = new InventoryContainer();
        this.succesDialog = new SuccesDialog();
        this.seatingCustomer = -1;

        view.getStove().addActionListener((e) -> {
            foodSelectionContainer.setVisible(true);
            foodSelectionContainer.setFoodType(FoodType.Stove);
            foodSelectionContainer.setLocationRelativeTo(view.getStove());
        });
        view.getFurnace().addActionListener((e) -> {
            foodSelectionContainer.setVisible(true);
            foodSelectionContainer.setFoodType(FoodType.Furnace);
            foodSelectionContainer.setLocationRelativeTo(view.getFurnace());
        });

        view.getNewCustomersButton().addActionListener(this::seatCustomer);

        view.getOrderButton().addActionListener((e) -> {
            orderContainer.setVisible(true);
            view.setEnabled(false);
        });

        customerContainer.getRetrieveOrderButton().addActionListener(this::retrieveOrder);
        customerContainer.getServeFoodButton().addActionListener(this::serveFood);
        customerContainer.getServeCheckButton().addActionListener(this::serveCheck);

        for (TableButton table : view.getTables()) {
            table.addActionListener(e -> tableClicked(e, table));
        }

        foodSelectionContainer.getFoodList().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                handleFoodSelection(e);
            }
        });

        view.getInventoryButton().addActionListener(this::openInventoryScreen);
    }

    private void serveCheck(ActionEvent actionEvent) {
        double prevProfit = model.getProfit();
        int tableNumber = customerContainer.tableNumber;
        model.settleTable(tableNumber);
        customerContainer.hideDialog();
        view.setProfit(model.getProfit());
        succes("You recieved €" + String.format("%.2f", (double) (model.getProfit() - prevProfit)),
            (Component) actionEvent.getSource());
    }

    private void serveFood(ActionEvent actionEvent) {
        int tableNumber = customerContainer.tableNumber;
        Table table = model.getTable(tableNumber);

        if (table == null) {
            throw new Error("No table found!");
        }

        boolean ready = model.checkReadyToServe(tableNumber);

        if (!ready) {
            Toolkit.getDefaultToolkit().beep();
            succesDialog.setTitle("ERROR!");
            succes("The order is not yet ready!", (Component) actionEvent.getSource());
            succesDialog.setTitle("Succes!");
        } else {
            model.serveTable(tableNumber);
            customerContainer.hideDialog();
            succes("Served food!", (Component) actionEvent.getSource());
        }
    }

    private void seatCustomer(ActionEvent e) {
        Customer customer = model.getNextCustomer();

        seatingCustomer = customer.id;

        for (Table table : model.getTables()) {
            if (table == null)
                continue;
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
        succes("Order added to list!", (Component) e.getSource());
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

            succes("Seated customer at table " + table.getTableNumber(), table);
        }
    }

    private void setupTableView(TableButton table) {
        Table clickedTable = model.getTable(table.getTableNumber());
        customerContainer.openTableView(clickedTable);
        view.setEnabled(false);
        customerContainer.setLocationRelativeTo(table);
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
            Food selectedFood = (Food) foodSelectionContainer.getMenuItems().get(foodIndex);
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
            Timer swingTimer = new Timer(ANIMATION_DURATION, new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    cooker.addTime(ANIMATION_DURATION / 1000.);
                    view.setCookingProgress(cooker.getPercentageDone(), selectedFood.getFoodType());
                    if (cooker.checkTimer()) {
                        // The food is done
                        ((javax.swing.Timer) e.getSource()).stop();
                        cooker.removeItem();
                        model.addItemToInventory(selectedFood);
                        view.setCookingProgress(0, selectedFood.getFoodType());
                    }
                }

            });
            swingTimer.start();
        } catch (IndexOutOfBoundsException exc) {
            System.out.println(exc);
        }
    }

    public void openInventoryScreen(ActionEvent e) {
        inventoryContainer.setVisible(true);
        inventoryContainer.setLocationRelativeTo(view.getInventoryButton());
        inventoryContainer.updateList(model.getInventory());
    }

    public void succes(String message, Component component) {
        succesDialog.label.setText(message);
        succesDialog.setVisible(true);
        succesDialog.setLocationRelativeTo(component);

        Timer timer = new Timer(1000, e -> succesDialog.setVisible(false));
        timer.setRepeats(false);
        timer.start();
    }
}
