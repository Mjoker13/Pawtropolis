package com.example.pawtropolis.controller;

import com.example.pawtropolis.model.Game.Item;
import com.example.pawtropolis.model.Game.Room;
import com.example.pawtropolis.gameControls.Direction;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

@Log4j2
@Getter
@Setter
@Service
public class MapController {
    private Room currentRoom;

    @Autowired
    public MapController(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void changeRoom(@NotNull String directionString) {
        Direction direction = Direction.convertingStringToDirection(directionString.trim());
        if (direction == null) {
            log.info("Direction not valid. Introduce right direction. ");
        } else {
            Optional<Direction> validDirection = Arrays.stream(Direction.values())
                    .filter(a -> direction.name().equalsIgnoreCase(a.name()))
                    .findFirst();
            if (validDirection.isPresent() && getAdjacentRooms(direction) != null) {
                System.out.println("You moved from the room " + currentRoom.getName() + " to room " + getAdjacentRooms(direction).getName());
                currentRoom = getAdjacentRooms(direction);
            } else {
                log.info("Direction not valid. Introduce right direction. ");
                showAdjacentRooms();
            }
        }
    }

    public void showRoomInformation() {
        System.out.println("You are in: " + currentRoom.getName());
        System.out.println("Items present in room: " + currentRoom.getItems().stream().filter(Objects::nonNull).map(item -> item.getName() + " (x" + item.getQuantity() + ")").toList());
        System.out.println("NPC: " + currentRoom.getAnimals().stream().filter(Objects::nonNull).map(animal -> animal.getName() + " (" + animal.getClass().getSimpleName() + ")").toList());
    }

    public void addItemToRoom(Item item) {
        currentRoom.getItems().add(item);
    }

    public void dropItemFromRoom(Item item) {
        currentRoom.getItems().remove(item);
    }

    public Room getAdjacentRooms(Direction direction) {
        return currentRoom.getAdjacentRooms().get(direction);
    }

    public void showAdjacentRooms() {
        Arrays.stream(Direction.values()).
                forEach(d -> {
                    if (getAdjacentRooms(d) != null)
                        System.out.println("You can move at direction " + d.name().toLowerCase() + " to " + getAdjacentRooms(d).getName() + " ");
                });
    }

    public Item getItemFromRoom(String itemName) {
        return currentRoom.getItems().stream()
                .filter(item -> item.getName().replaceAll("\\s+", "").equalsIgnoreCase(itemName))
                .findFirst().orElse(null);
    }

    public void linkRoomByDirection(Direction direction, Room adjacentRoom, @NotNull Room actualRoom) {
        actualRoom.getAdjacentRooms().put(direction, adjacentRoom);
        adjacentRoom.getAdjacentRooms().put(Direction.getOppositeDirection(direction), actualRoom);
    }
}
