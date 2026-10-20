package com.mycompany.restaurantsimulator.models.menuItems;

import com.mycompany.restaurantsimulator.models.enums.FoodType;

public class Food extends MenuItem {

    public int cookingTime;
    public FoodType type;

    public Food(String name, double price, int cookingTime, FoodType type) {
        super(name, price);
        this.type = type;
    }
}
