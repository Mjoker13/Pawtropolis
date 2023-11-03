package com.example.pawtropolis.model.Game;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class PlayerBag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany(mappedBy = "player_bag", cascade = CascadeType.ALL)
    private List<Item> items = new ArrayList<>();
    @Max(20)
    @Min(0)
    private int maxCapacity = 20;
    @OneToOne(mappedBy = "player_bag")
    private Player player;

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

