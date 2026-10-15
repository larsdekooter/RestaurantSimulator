package com.mycompany.restaurantsimulator.models;

import com.mycompany.restaurantsimulator.models.menuItems.Drink;
import com.mycompany.restaurantsimulator.models.menuItems.Food;

public class Menu {

    public Food[] foods = {
        new Food("Steak", 25.00, 20),
        new Food("Carpaccio", 12.50, 10),
        new Food("Garlic bread", 7.50, 15),
        new Food("Pasta Pesto", 22.50, 20),
        new Food("Pizza salami", 22.50, 20),
        new Food("Pizza Italiano", 25.00, 20),
        new Food("Lasagna", 22.50, 25),
        new Food("Pizza veggie", 22.50, 20),
        new Food("Pizza", 22.50, 20),
        new Food("Pasta", 22.50, 15)
    };

    public Drink[] drinks = {
        new Drink("Beer", 4.50),
        new Drink("Wine", 5.00),
        new Drink("Apple juice", 2.50),
        new Drink("Cola", 2.50),
    };
}
