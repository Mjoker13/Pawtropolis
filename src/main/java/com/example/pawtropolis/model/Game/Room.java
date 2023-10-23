package com.example.pawtropolis.model.Game;

import com.example.pawtropolis.model.Animal.Animal;
import com.example.pawtropolis.gameControls.Direction;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;

import java.util.*;

@Log
@Data
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

    public void showRoomInformation() {
        System.out.println("You are in: " + name);
        System.out.println("Items present in room: " + items.stream().filter(Objects::nonNull).map(item -> item.getName() + " (x" + item.getQuantity() + ")").toList());
        System.out.println("NPC: " + animals.stream().filter(Objects::nonNull).map(animal -> animal.getName() + " (" + animal.getClass().getSimpleName() + ")").toList());
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void dropItem(Item item) {
        items.remove(item);
    }

    public Room getAdjacentRooms(Direction direction) {
        return adjacentRooms.get(direction);
    }

    public void showAdjacentRooms() {
        Arrays.stream(Direction.values()).
                forEach(d -> {
                    if (getAdjacentRooms(d) != null)
                        System.out.println("You can move at direction " + d.name().toLowerCase() + " to " + getAdjacentRooms(d).getName() + " ");
                });
    }

    public Item getItemFromRoom(String itemName) {
        return items.stream()
                .filter(item -> item.getName().replaceAll("\\s+", "").equalsIgnoreCase(itemName))
                .findFirst().orElse(null);
    }
    public void linkRoomByDirection(Direction direction, Room adjacentRoom) {
        adjacentRooms.put(direction, adjacentRoom);
        adjacentRoom.linkAdjacentRoomToActualRoom(direction, this);
    }
    private void linkAdjacentRoomToActualRoom(Direction direction, Room actualRoom) {
        adjacentRooms.put(Direction.getOppositeDirection(direction), actualRoom);
    }
}
