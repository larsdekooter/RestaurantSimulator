package controllers;

import com.mycompany.restaurantsimulator.models.Restaurant;
import com.mycompany.restaurantsimulator.models.Table;
import com.mycompany.restaurantsimulator.models.customers.Customer;
import com.mycompany.restaurantsimulator.models.customers.WealthyCustomer;
import com.mycompany.restaurantsimulator.models.enums.FoodType;
import com.mycompany.restaurantsimulator.view.GUIContainer;
import com.mycompany.restaurantsimulator.view.components.CustomerContainer;
import com.mycompany.restaurantsimulator.view.components.FoodSelectionContainer;
import com.mycompany.restaurantsimulator.view.components.OrderContainer;
import com.mycompany.restaurantsimulator.view.components.TableButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

public class RestaurantController {

    public Restaurant model;
    public FoodSelectionContainer foodSelectionContainer;
    public OrderContainer orderContainer;
    public GUIContainer view;
    public CustomerContainer customerContainer;
    private int seatingCustomer;

    public RestaurantController(Restaurant model, GUIContainer view) {
        this.model = model;
        this.view = view;
        this.foodSelectionContainer = new FoodSelectionContainer(model.getMenu());
        this.orderContainer = new OrderContainer(model.getTables().length);
        this.customerContainer = new CustomerContainer(view);
        this.seatingCustomer = -1;

        view.getStove1().addActionListener((e) -> {
            foodSelectionContainer.setVisible(true);
            foodSelectionContainer.setFoodType(FoodType.Stove);
        });
        view.getStove2().addActionListener((e) -> {
            foodSelectionContainer.setVisible(true);
            foodSelectionContainer.setFoodType(FoodType.Furnace);
        });

        view.getNewCustomersButton().addActionListener(this::seatCustomer);
        view.getOrderButton()
                .addActionListener((e) -> orderContainer.setVisible(true));

        for (TableButton table : view.getTables()) {
            table.addActionListener(e -> {
                tableClicked(e, table);
            });
        }
    }

    private void seatCustomer(ActionEvent e) {
        Customer customer = new WealthyCustomer(model.nextCustomerId(), 6);
        boolean added = model.addCustomer(customer);
        if (!added) return;
        seatingCustomer = customer.id;

        for (Table table : model.getTables()) {
            if (table.customer == null && table.seats >= customer.partySize) {
                view.turnTableGreen(table.id);
            } else {
                view.turnTableRed(table.id);
            }
        }
    }

    private void tableClicked(ActionEvent e, TableButton table) {
        if (seatingCustomer == -1) {
            customerContainer.setVisible(true);
            customerContainer.setTitle("Table " + table.getTableNumber());
            customerContainer.getLabel().setText("Table " + table.getTableNumber());
            view.setEnabled(false);
            customerContainer.setLocationRelativeTo(table);
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

    public void setRectangularStoveProgress(int progress) {
        view.setStove1Progress(progress);
    }

    public void setCircularStoveProgress(int progress) {
        view.setStove2Progress(progress);
    }

}
