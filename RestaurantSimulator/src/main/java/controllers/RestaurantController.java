package controllers;

import com.mycompany.restaurantsimulator.models.Restaurant;
import com.mycompany.restaurantsimulator.models.enums.FoodType;
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
        this.orderContainer = new OrderContainer(model.getTables().length);
        this.customerContainer = new CustomerContainer(view);

        view.getStove1().addActionListener((e) -> {
            foodSelectionContainer.setVisible(true);
            foodSelectionContainer.setFoodType(FoodType.Stove);
        });
        view.getStove2().addActionListener((e) -> {
            foodSelectionContainer.setVisible(true);
            foodSelectionContainer.setFoodType(FoodType.Furnace);
        });

        view.getOrderButton()
                .addActionListener((e) -> orderContainer.setVisible(true));

        for (TableButton table : view.getTables()) {
            table.addActionListener(e -> {
                customerContainer.setVisible(true);
                customerContainer.setTitle("Table " + table.getTableNumber());
                customerContainer.getLabel().setText("Table " + table.getTableNumber());
                view.setEnabled(false);
                customerContainer.setLocationRelativeTo(table);
            });
        }
    }

    public void setRectangularStoveProgress(int progress) {
        view.setStove1Progress(progress);
    }

    public void setCircularStoveProgress(int progress) {
        view.setStove2Progress(progress);
    }

}
