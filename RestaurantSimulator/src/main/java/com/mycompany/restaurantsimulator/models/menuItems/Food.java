package com.mycompany.restaurantsimulator.models.menuItems;

public class Food extends MenuItem {

    public int cookingTime;

    public Food(String name, double price, int cookingTime) {
        super(name, price);
    }
}
