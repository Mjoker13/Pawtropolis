package com.example.pawtropolis.model.Game;

import com.example.pawtropolis.model.Animal.Animal;
import com.example.pawtropolis.gameControls.Direction;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.*;

@Getter
@Setter
@Component
@NoArgsConstructor
public class Room {

    private String name;
    private List<Item> items;
    private List<Animal> animals;
    private EnumMap<Direction, Room> adjacentRooms;

    public Room(String name, List<Item> items, List<Animal> animals) {
        this.name = name;
        this.items = Objects.requireNonNullElseGet(items, ArrayList::new);
        this.animals = Objects.requireNonNullElseGet(animals, ArrayList::new);
        this.adjacentRooms = new EnumMap<>(Direction.class);
    }
}
