package com.mycompany.restaurantsimulator.models;

public class Table {

    public int id;
    public int seats;
    public Customer customer; //Can be null

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
}
