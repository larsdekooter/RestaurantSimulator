package com.mycompany.restaurantsimulator.models;

import java.util.Arrays;

public class Order {
    //Take the ID from the customer
    public int id;
    public Food[] food;
    public double check;

    public Order(int id, Food[] food) {
        this.id = id;
        this.food = food;
    }

    public double calculatePrice() {
        check = Arrays.stream(food).mapToDouble(num -> num.price).sum();
        return check;
    }
}
