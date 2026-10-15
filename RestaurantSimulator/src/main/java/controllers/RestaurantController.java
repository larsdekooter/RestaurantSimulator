package controllers;

import com.mycompany.restaurantsimulator.models.Restaurant;
import com.mycompany.restaurantsimulator.view.GUIContainer;
import com.mycompany.restaurantsimulator.view.components.FoodSelectionContainer;
import com.mycompany.restaurantsimulator.view.components.OrderContainer;

public class RestaurantController {

    public Restaurant model;
    public FoodSelectionContainer foodSelectionContainer;
    public OrderContainer orderContainer;
    public GUIContainer view;

    public RestaurantController(Restaurant model, GUIContainer view) {
        this.model = model;
        this.view = view;
        this.foodSelectionContainer = new FoodSelectionContainer(model.getMenu());
        this.orderContainer = new OrderContainer();

        view.getFoodSelectionButton()
                .addActionListener((e) -> foodSelectionContainer.setVisible(true));

        view.getOrderButton()
                .addActionListener((e) -> orderContainer.setVisible(true));
    }

}
