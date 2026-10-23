package com.mycompany.restaurantsimulator.models;

import com.mycompany.restaurantsimulator.models.enums.FoodType;
import com.mycompany.restaurantsimulator.models.menuItems.Drink;
import com.mycompany.restaurantsimulator.models.menuItems.Food;

public class Menu {

    public Food[] foods = { new Food("Steak", 25.00, 20, FoodType.Stove),
        new Food("Carpaccio", 12.50, 10, FoodType.Cold),
        new Food("Garlic bread", 7.50, 15, FoodType.Cold),
        new Food("Pasta Pesto", 22.50, 20, FoodType.Stove),
        new Food("Pizza salami", 22.50, 20, FoodType.Furnace),
        new Food("Pizza Italiano", 25.00, 20, FoodType.Furnace),
        new Food("Lasagna", 22.50, 25, FoodType.Furnace),
        new Food("Pizza veggie", 22.50, 20, FoodType.Furnace),
        new Food("Pizza", 22.50, 20, FoodType.Furnace),
        new Food("Pasta", 22.50, 15, FoodType.Stove) };

    public Drink[] drinks = { new Drink("Beer", 4.50), new Drink("Wine", 5.00),
        new Drink("Apple juice", 2.50), new Drink("Cola", 2.50), };
}
