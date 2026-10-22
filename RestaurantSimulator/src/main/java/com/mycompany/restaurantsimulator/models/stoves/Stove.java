package com.mycompany.restaurantsimulator.models.stoves;

import com.mycompany.restaurantsimulator.models.menuItems.Food;

public class Stove {
    public int id;
    public Food cooking; //Can be null
    public int timeCooking;

    public Stove(int id, Food cooking, int timeCooking) {
        this.id = id;
        this.cooking = cooking;
        this.timeCooking = timeCooking;
    }
}
