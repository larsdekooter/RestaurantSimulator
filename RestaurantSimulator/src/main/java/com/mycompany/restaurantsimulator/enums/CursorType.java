package com.mycompany.restaurantsimulator.enums;

import java.awt.Cursor;

public enum CursorType {
    DEFAULT(Cursor.DEFAULT_CURSOR),
    HAND(Cursor.HAND_CURSOR),
    CROSSHAIR(Cursor.CROSSHAIR_CURSOR),
    TEXT(Cursor.TEXT_CURSOR),
    WAIT(Cursor.WAIT_CURSOR),
    MOVE(Cursor.MOVE_CURSOR);

    private final int type;

    CursorType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
