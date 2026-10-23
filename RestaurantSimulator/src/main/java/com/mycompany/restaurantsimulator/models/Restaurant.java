package com.mycompany.restaurantsimulator.models;

import com.mycompany.restaurantsimulator.models.customers.AverageCustomer;
import com.mycompany.restaurantsimulator.models.customers.Customer;
import com.mycompany.restaurantsimulator.models.customers.ImpatientCustomer;
import com.mycompany.restaurantsimulator.models.customers.WealthyCustomer;
import com.mycompany.restaurantsimulator.models.enums.FoodType;
import com.mycompany.restaurantsimulator.models.menuItems.Drink;
import com.mycompany.restaurantsimulator.models.menuItems.Food;
import com.mycompany.restaurantsimulator.models.menuItems.MenuItem;
import com.mycompany.restaurantsimulator.models.stoves.Stove;

import java.util.*;

public class Restaurant {
    private String name;
    private Menu menu;
    private Table[] tables;
    private Customer[] customers;
    private Stove[] stove;
    private Map<Integer, Order> orders;
    private double profit;
    private ArrayList<MenuItem> inventory = new ArrayList<>();

    public Restaurant(String name, int numberOfTables, int numberOfStoves) {
        this.name = name;
        this.tables = new Table[numberOfTables + 1];
        this.customers = new Customer[1000];
        this.stove = new Stove[numberOfStoves];
        this.menu = new Menu();
        this.orders = new HashMap<Integer, Order>();
        this.profit = 0.0;

        createTables();
        setupCustomers();
    }

    private void setupCustomers() {
        for (int i = 0; i < this.customers.length; i++) {
            switch (i % 3) {
            case 0:
                customers[i] = new AverageCustomer(i, i + 1);
                break;
            case 1:
                customers[i] = new ImpatientCustomer(i, i);
                break;
            case 2:
                customers[i] = new WealthyCustomer(i, i);
                break;
            default:
                customers[i] = new AverageCustomer(i, i);
            }
        }
    }

    private void createTables() {
        for (int i = 0; i < tables.length - 1; i++) {
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

    public void settleTable(int tableId) {
        Table table = getTable(tableId);
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
        Customer customer = Arrays.stream(customers).filter(c -> c != null && c.id == customerId).findFirst()
            .orElse(null);

        Table table = Arrays.stream(tables).filter(t -> t.id == tableId).findFirst().orElse(null);

        if (customer == null || table == null)
            return false;

        return table.seatCustomers(customer);
    }

    public int nextCustomerId() {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] == null)
                return i;
        }
        return -1;
    }

    public Map<Integer, Order> getOrders() {
        return this.orders;
    }

    public void addOrder(int tableNumber, Order order) {
        this.orders.put(tableNumber, order);
    }

    public void removeOrder(int tableNumber) {
        this.orders.put(tableNumber, null);
    }

    public Table getTable(int tableNumber) {
        return tables[tableNumber - 1];
    }

    public void addItemToInventory(MenuItem item) {
        this.inventory.add(item);
    }

    public int getItemIndexInInventory(MenuItem item) {
        return this.inventory.indexOf(item);
    }

    public void removeItemFromInventory(MenuItem item) {
        int index = getItemIndexInInventory(item);
        if (index > -1)
            inventory.remove(index);
    }

    public ArrayList<MenuItem> getInventory() {
        return this.inventory;
    }

    public Customer getNextCustomer() {
        Customer next = null;
        for (Customer customer : customers) {
            if (customer != null && !customer.seated) {
                next = customer;
                customer.seated = true;
                break;
            }
        }
        return next;
    }

    public boolean checkReadyToServe(int tableNumber) {
        Order order = orders.get(tableNumber);
        if (order == null) {
            return false;
        }

        for (int i = 0; i < order.items.length; i++) {
            MenuItem item = order.items[i];
            if (item.getClass() == Drink.class)
                continue;
            if (item.getClass() == Food.class
                && (((Food) item).getFoodType() == FoodType.All || ((Food) item).getFoodType() == FoodType.Cold))
                continue;

            int amountInOrder = Math
                .toIntExact(Arrays.stream(order.items).filter(orderItem -> orderItem.name.equals(item.name)).count());
            int amountInInventory = Math
                .toIntExact(inventory.stream().filter(inventoryItem -> inventoryItem.name.equals(item.name)).count());

            if (amountInOrder > amountInInventory)
                return false;

            i += amountInOrder;
        }
        return true;
    }

    public void serveTable(int tableNumber) {
        Order order = orders.get(tableNumber);

        for (int j = 0; j < order.items.length; j++) {
            MenuItem item = order.items[j];
            if (item.getClass() == Drink.class)
                continue;
            if (item.getClass() == Food.class
                && (((Food) item).getFoodType() == FoodType.All || ((Food) item).getFoodType() == FoodType.Cold))
                continue;

            removeItemFromInventory(item);
        }

        Table table = getTable(tableNumber);
        table.customer.receivedOrder = true;
        orders.remove(tableNumber);
    }

    public double getProfit() {
        return profit;
    }
}
