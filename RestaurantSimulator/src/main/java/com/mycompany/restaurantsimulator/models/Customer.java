package com.mycompany.restaurantsimulator.models;

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
    /// @return
    public Order getOrder() {
        if(order == null) {
            order = new Order(0, new Food[] {});
        }
        return order;
    }
}
