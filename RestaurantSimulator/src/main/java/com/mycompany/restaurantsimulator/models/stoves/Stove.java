package com.mycompany.restaurantsimulator.models.stoves;

import com.mycompany.restaurantsimulator.models.menuItems.Food;

public class Stove {
    public int id;
    public Food cooking; // Can be null
    public double timeCooking;

    public Stove(int id, Food cooking, int timeCooking) {
        this.id = id;
        this.cooking = cooking;
        this.timeCooking = timeCooking;
    }

    public boolean setCooking(Food cooking) {
        if (this.cooking != null && this.timeCooking != this.cooking.getCookingTime()) {
            // If the current food is not done cooking yet, don't set the food
            return false;
        }
        this.cooking = cooking;
        return true;
    }

    public void removeItem() {
        this.cooking = null;
        this.timeCooking = 0;
    }

    /**
     * Get the percentage of cooking time
     * 
     * @return The percentage as 0-100
     */
    public int getPercentageDone() {
        if (this.cooking == null) {
            return 0;
        }
        return (int) Math
            .round((this.timeCooking * 100.0) / this.cooking.getCookingTime());
    }

    public boolean checkTimer() {
        return timeCooking >= this.cooking.getCookingTime();
    }

    /**
     * Adds time to the time the food is cooking
     */
    public void addTime(double time) {
        this.timeCooking += time;
    }
}
