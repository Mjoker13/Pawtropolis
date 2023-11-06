package com.example.pawtropolis.DTO.game;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
public class PlayerBag {
    private List<Item> items;
    private int maxCapacity = 20;

    public int getSlotAvailable() {
        int capacity = 0;
        if (!items.isEmpty()) {
            for (Item i : items) {
                capacity += i.getSlotRequired();
            }
        }
        return maxCapacity - capacity;
    }
}

