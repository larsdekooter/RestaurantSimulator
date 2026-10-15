package com.mycompany.restaurantsimulator.models.customers;

import com.mycompany.restaurantsimulator.models.Order;

///Impatient customers give very little tip
/// if it took too long they won't give any tip at all
public class ImpatientCustomer extends Customer {
    public ImpatientCustomer(int id, int partySize) {
        super(id, partySize);
    }

    @Override
    public double calculateCheck(Order order) {
        return order.calculatePrice();
    }
}
