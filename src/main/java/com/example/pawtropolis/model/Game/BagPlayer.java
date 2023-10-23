package com.example.pawtropolis.model.Game;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Component
public class BagPlayer {
    private List<Item> items = new ArrayList<>();
    private int slotAvailable;
    private final int maxCapacity = 20;

}

