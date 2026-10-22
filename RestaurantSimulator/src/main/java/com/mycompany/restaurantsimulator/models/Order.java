package com.mycompany.restaurantsimulator.models;

import com.mycompany.restaurantsimulator.models.menuItems.MenuItem;
import java.util.Arrays;

public class Order {
    // Take the ID from the customer
    public int id;
    public MenuItem[] items;
    public double check;

    public Order(int id, MenuItem[] items) {
        this.id = id;
        this.items = items;
    }

    public double calculatePrice() {
        check = Arrays.stream(items).mapToDouble(num -> num.price).sum();
        return check;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (MenuItem item : items) {
            builder.append(item);
            builder.append("\n");
        }

        return builder.toString();
    }
}
