package com.mycompany.restaurantsimulator.models;

public class Restaurant {
    private String name;
    private Menu menu;
    private Table[] tables;
    private Customer[] customers;
    private Stove[] stove;

    public Restaurant(String name, int numberOfTables, int numberOfStoves){
        this.name = name;
        this.tables = new Table[numberOfTables];
        this.customers = new Customer[1000];
        this.stove = new Stove[numberOfStoves];
        this.menu = new Menu();
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

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public Stove[] getStove() {
        return stove;
    }

    public void setStove(Stove[] stove) {
        this.stove = stove;
    }
}
