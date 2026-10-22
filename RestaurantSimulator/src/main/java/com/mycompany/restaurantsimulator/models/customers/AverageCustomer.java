package com.mycompany.restaurantsimulator.models.customers;

public class AverageCustomer extends Customer {
    public AverageCustomer(int id, int partySize) {
        super(id, partySize);
    }

    @Override
    public double calculateCheck() {
        return order.calculatePrice() * 1.10;
    }
}
