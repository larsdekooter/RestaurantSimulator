package com.mycompany.restaurantsimulator.models.customers;

import com.mycompany.restaurantsimulator.models.Order;

public class AverageCustomer extends Customer {
    public AverageCustomer(int id, int partySize) {
        super(id, partySize);
    }

    @Override
    public double calculateCheck(Order order) {
        return order.calculatePrice() * 1.10;
    }
}
