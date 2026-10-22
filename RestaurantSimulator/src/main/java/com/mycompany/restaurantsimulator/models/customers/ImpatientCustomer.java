package com.mycompany.restaurantsimulator.models.customers;

///Impatient customers give very little tip
/// if it took too long they won't give any tip at all
public class ImpatientCustomer extends Customer {
    public ImpatientCustomer(int id, int partySize) {
        super(id, partySize);
    }

    @Override
    public double calculateCheck() {
        return order.calculatePrice();
    }
}
