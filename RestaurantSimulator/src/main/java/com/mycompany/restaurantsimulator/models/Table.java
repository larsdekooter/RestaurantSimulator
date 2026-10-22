package com.mycompany.restaurantsimulator.models;

import com.mycompany.restaurantsimulator.models.customers.Customer;

public class Table {

    public int id;
    public int seats;
    public Customer customer; // Can be null

    public Table(int id, int seats) {
        this.id = id;
        this.seats = seats;
    }

    public boolean seatCustomers(Customer customer) {
        if (customer == null || customer.partySize > seats) {
            return false;
        }
        this.customer = customer;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Table ");
        builder.append(id);
        builder.append(" Number of seats: ");
        builder.append(seats);
        builder.append(" Customer: ");
        builder.append(customer);

        return builder.toString();
    }

}
