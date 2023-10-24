package com.example.pawtropolis.model.Game;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
public class Bag {
    private List<Item> items = new ArrayList<>();
    private int slotAvailable;
    private int maxCapacity=20;
}

