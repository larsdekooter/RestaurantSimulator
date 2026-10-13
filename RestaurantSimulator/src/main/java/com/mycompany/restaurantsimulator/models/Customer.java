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
    public Order getOrder() {
        if (order == null) {
            order = new Order(id, makeNewOrder());
        }
        return order;
    }

    private Food[] makeNewOrder() {
        Food[] newOrder = new Food[partySize];

        Random rand = new Random();
        for (int i = 0; i < partySize; i++) {
            newOrder[i] = Menu.menu[rand.nextInt(Menu.menu.length)];
        }

        return newOrder;
    }
}
