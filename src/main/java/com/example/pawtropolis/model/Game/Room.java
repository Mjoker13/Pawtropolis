package com.example.pawtropolis.model.Game;

import com.example.pawtropolis.model.Animal.Animal;
import com.example.pawtropolis.gameControls.Direction;
import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.*;

@Log
@Data
@Component
public class Room {

    private String name;
    private List<Item> items;
    private List<Animal> animals;
    private EnumMap<Direction, Room> adjacentRooms;

    public Room() {
    }

    public Room(String name, List<Item> items, List<Animal> animals) {
        this.name = name;
        this.items = Objects.requireNonNullElseGet(items, ArrayList::new);
        this.animals = Objects.requireNonNullElseGet(animals, ArrayList::new);
        this.adjacentRooms = new EnumMap<>(Direction.class);
    }


    public void linkRoomByDirection(Direction direction, Room adjacentRoom) {
        adjacentRooms.put(direction, adjacentRoom);
        adjacentRoom.linkAdjacentRoomToActualRoom(direction, this);
    }

    public void linkAdjacentRoomToActualRoom(Direction direction, Room actualRoom) {
        adjacentRooms.put(Direction.getOppositeDirection(direction), actualRoom);
    }


}
