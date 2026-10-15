package controllers;

import com.mycompany.restaurantsimulator.models.Restaurant;
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

    public RestaurantController(Restaurant model, GUIContainer view) {
        this.model = model;
        this.view = view;
        this.foodSelectionContainer = new FoodSelectionContainer(model.getMenu());
        this.orderContainer = new OrderContainer();
        this.customerContainer = new CustomerContainer(view);

        view.getFoodSelectionButton()
                .addActionListener((e) -> foodSelectionContainer.setVisible(true));

        view.getOrderButton()
                .addActionListener((e) -> orderContainer.setVisible(true));

        for (TableButton table : view.getTables()) {
            table.addActionListener(e -> {
                customerContainer.setVisible(true);
                customerContainer.setTitle("Table " + table.getTableNumber());
                customerContainer.getLabel().setText("Table " + table.getTableNumber());
                view.setEnabled(false);
            });
        }
    }

    public void setStoveProgress(int progress) {
        view.getStoveProgressBar().setValue(progress);
    }

}
