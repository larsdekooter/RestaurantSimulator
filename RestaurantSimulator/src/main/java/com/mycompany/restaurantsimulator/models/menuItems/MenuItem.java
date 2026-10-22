package com.mycompany.restaurantsimulator.models.menuItems;

public abstract class MenuItem {

    public final String name;
    public final double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
