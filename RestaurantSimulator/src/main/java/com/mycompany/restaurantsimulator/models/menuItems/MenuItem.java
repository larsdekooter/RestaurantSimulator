package com.mycompany.restaurantsimulator.models.menuItems;

public abstract class MenuItem {

    public String name;
    public double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
