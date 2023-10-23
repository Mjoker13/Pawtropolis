package com.example.pawtropolis.model.Game;

import lombok.Data;

@Data
public class Item {
    private final String name;
    private final String description;
    private final int slotRequired;
    private int quantity;

    public Item(String name, String description, int slotRequired) {
        this.name = name;
        this.description = description;
        if (slotRequired < 20) {
            this.slotRequired = slotRequired;
        } else throw new RuntimeException("The slot required cannot overcome 20.");
        this.quantity = 1;
    }


}
