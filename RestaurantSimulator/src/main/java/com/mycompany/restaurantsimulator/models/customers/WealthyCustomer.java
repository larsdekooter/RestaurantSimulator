package com.mycompany.restaurantsimulator.models.customers;

import com.mycompany.restaurantsimulator.models.Menu;
import com.mycompany.restaurantsimulator.models.menuItems.MenuItem;
import java.util.Arrays;
import java.util.Comparator;

public class WealthyCustomer extends Customer {
    public WealthyCustomer(int id, int partySize) {
        super(id, partySize);
    }

    @Override
    public MenuItem[] makeNewOrder(Menu menu) {
        MenuItem[] order = new MenuItem[partySize * 2];

        for (int i = 0; i < partySize; i++) {
            order[i] = Arrays.stream(menu.foods)
                    .max(Comparator.comparingDouble(f -> f.price))
                    .orElseThrow();

            order[i + partySize] = Arrays.stream(menu.drinks)
                    .max(Comparator.comparingDouble(d -> d.price))
                    .orElseThrow();
        }

        return order;
    }

    @Override
    public double calculateCheck() {
        if (!receivedOrder) return 0.0;
        return order.calculatePrice() * 2;
    }
}
