package com.mycompany.restaurantsimulator;

import com.mycompany.restaurantsimulator.models.Restaurant;
import com.mycompany.restaurantsimulator.view.GUIContainer;
import controllers.RestaurantController;

/**
 *
 * @author lars
 */
public class RestaurantSimulator {

    public static void main(String[] args) {
        // Initialize View
        GUIContainer container = new GUIContainer();

        // Initialize Model
        Restaurant restaurant = new Restaurant("De Kooter's", 9, 2);

        // Initialize Controller
        RestaurantController restaurantController = new RestaurantController(restaurant, container);

        container.setVisible(true);

    }
}
