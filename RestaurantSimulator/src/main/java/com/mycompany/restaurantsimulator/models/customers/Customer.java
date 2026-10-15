package com.mycompany.restaurantsimulator.models.customers;

import com.mycompany.restaurantsimulator.models.Menu;
import com.mycompany.restaurantsimulator.models.Order;
import com.mycompany.restaurantsimulator.models.menuItems.MenuItem;
import java.util.Random;

public abstract class Customer {
    public int id;
    public int partySize;
    public Order order;

    public Customer(int id, int partySize) {
        this.id = id;
        this.partySize = partySize;
    }

    /// Return the customer's order
    /// or create one if the customer had not ordered yet.
    /// @return the order of the customer
    public Order getOrder(Menu menu) {
        if (order == null) {
            order = new Order(id, makeNewOrder(menu));
        }
        return order;
    }

    public MenuItem[] makeNewOrder(Menu menu) {
        MenuItem[] newOrder = new MenuItem[partySize * 2];

        Random rand = new Random();
        for (int i = 0; i < partySize; i++) {
            newOrder[i] = menu.foods[rand.nextInt(menu.foods.length)];
            newOrder[i + partySize] = menu.drinks[rand.nextInt(menu.drinks.length)];
        }

        return newOrder;
    }

    public abstract double calculateCheck(Order order);
}
