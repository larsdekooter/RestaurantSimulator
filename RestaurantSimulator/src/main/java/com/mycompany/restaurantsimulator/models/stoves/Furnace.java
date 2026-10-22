package com.mycompany.restaurantsimulator.models.stoves;

import com.mycompany.restaurantsimulator.models.menuItems.Food;

public class Furnace extends Stove {
    public Furnace(int id, Food food, int timeCooking) {
        super(id, food, timeCooking);
    }
}
