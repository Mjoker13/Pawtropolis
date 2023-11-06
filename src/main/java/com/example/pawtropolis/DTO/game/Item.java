package com.example.pawtropolis.DTO.game;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class Item {

    private final String name;
    private final String description;
    private final int slotRequired;

    public Item(String name,String description, int slotRequired) {
        this.name = name;
        this.description = description;
        if (slotRequired < 20) {
            this.slotRequired = slotRequired;
        } else throw new RuntimeException("The slot required cannot overcome 20.");
    }
}
