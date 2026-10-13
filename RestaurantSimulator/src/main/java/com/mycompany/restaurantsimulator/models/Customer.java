package com.mycompany.restaurantsimulator.models;

import java.util.Random;

public class Customer {
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

    private Food[] makeNewOrder(Menu menu) {
        Food[] newOrder = new Food[partySize];

        Random rand = new Random();
        for (int i = 0; i < partySize; i++) {
            newOrder[i] = menu.menu[rand.nextInt(menu.menu.length)];
        }

        return newOrder;
    }
}
