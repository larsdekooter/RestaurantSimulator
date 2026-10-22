package com.mycompany.restaurantsimulator.models.menuItems;

import com.mycompany.restaurantsimulator.models.enums.FoodType;

public class Food extends MenuItem {

    private final int cookingTime;
    private final FoodType foodType;

    public Food(String name, double price, int cookingTime, FoodType foodType) {
        super(name, price);
        this.cookingTime = cookingTime;
        this.foodType = foodType;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public int getCookingTime() {
        return cookingTime;
    }
}
