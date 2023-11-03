package com.example.pawtropolis.model.Game;

import com.example.pawtropolis.model.Animal.Animal;
import com.example.pawtropolis.gameControls.Direction;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String name;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Item> items;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Animal> animals;
    private EnumMap<Direction, Room> adjacentRooms;

    public Room(@NotNull String name, List<Item> items, List<Animal> animals) {
        this.name = name;
        this.items = Objects.requireNonNullElseGet(items, ArrayList::new);
        this.animals = Objects.requireNonNullElseGet(animals, ArrayList::new);
        this.adjacentRooms = new EnumMap<>(Direction.class);
    }
}
