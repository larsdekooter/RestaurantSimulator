package com.mycompany.restaurantsimulator.models;

import com.mycompany.restaurantsimulator.models.customers.Customer;
import com.mycompany.restaurantsimulator.models.stoves.Stove;
import java.util.Arrays;

public class Restaurant {
    private String name;
    private Menu menu;
    private Table[] tables;
    private Customer[] customers;
    private Stove[] stove;
    private double profit;

    public Restaurant(String name, int numberOfTables, int numberOfStoves) {
        this.name = name;
        this.tables = new Table[numberOfTables + 1];
        this.customers = new Customer[1000];
        this.stove = new Stove[numberOfStoves];
        this.menu = new Menu();
        this.profit = 0.0;

        createTables();
    }

    private void createTables() {
        for (int i = 0; i < tables.length; i++) {
            tables[i] = new Table(i + 1, i + 1);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Table[] getTables() {
        return tables;
    }

    public void setTables(Table[] tables) {
        this.tables = tables;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void settleTable(int tableId){
        Table table  = getTable(tableId);
        profit += table.customer.calculateCheck();

        Customer customer = table.customer;
        customers[customer.id] = null;
        table.customer = null;
    }

    public boolean addCustomer(Customer customer) {
        if (customer == null || customer.id == -1 || customers[customer.id] != null) {
            return false;
        }
        customers[customer.id] = customer;
        return true;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public Stove[] getStove() {
        return stove;
    }

    public void setStove(Stove[] stove) {
        this.stove = stove;
    }

    public boolean seatCustomer(int customerId, int tableId) {
        Customer customer = Arrays.stream(customers)
                .filter(c -> c.id ==  customerId)
                .findFirst().orElse(null);

        Table table = Arrays.stream(tables)
                .filter(t -> t.id == tableId)
                .findFirst().orElse(null);

        if (customer == null || table == null) return false;

        return table.seatCustomers(customer);
    }

    public int nextCustomerId() {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] == null) return i;
        }
        return -1;
    }

    public Table getTable(int tableNumber) {
        return tables[tableNumber - 1];
    }
}
