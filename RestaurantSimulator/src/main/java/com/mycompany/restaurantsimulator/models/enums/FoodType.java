package com.mycompany.restaurantsimulator.models.enums;

public enum FoodType {
    All(0), Stove(1), Furnace(2), Cold(3);

    private final int type;

    FoodType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
