package com.example.pawtropolis.controller;

import com.example.pawtropolis.DTO.game.Item;
import com.example.pawtropolis.DTO.game.Room;
import com.example.pawtropolis.gameControls.Direction;
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
            log.error("Direction not valid. Introduce right direction. ");
        } else {
            Optional<Direction> validDirection = Arrays.stream(Direction.values())
                    .filter(a -> direction.name().equalsIgnoreCase(a.name()))
                    .findFirst();
            if (validDirection.isPresent() && getAdjacentRooms(direction) != null) {
                log.info("You moved from the room " + currentRoom.getName() + " to room " + getAdjacentRooms(direction).getName() +"\n");
                currentRoom = getAdjacentRooms(direction);
            } else {
                log.error("Direction not valid. Introduce right direction. ");
            }
        }
    }

    public void showRoomInformation() {
        log.info("You are in: " + currentRoom.getName());
        log.info("Items present in room: " + currentRoom.getItems().stream().filter(Objects::nonNull).map(Item::getName).toList());
        log.info("NPC: " + currentRoom.getAnimals().stream().filter(Objects::nonNull).map(animal -> animal.getName() + " (" + animal.getClass().getSimpleName() + ")").toList());
        log.info("Adiacent rooms: ");
        for(Direction adiacentRoom: currentRoom.getAdjacentRooms().keySet()){
           log.info("at " +adiacentRoom.getDirectionType() +" - "+ currentRoom.getAdjacentRooms().get(adiacentRoom).getName() );
       }

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
                        log.info("You can move at direction " + d.name().toLowerCase() + " to " + getAdjacentRooms(d).getName() + " ");
                });
    }

    public Item getItemFromRoom(String itemName) {
        return currentRoom.getItems().stream()
                .filter(item -> item.getName().equalsIgnoreCase(itemName))
                .findFirst().orElse(null);
    }

    public void linkRoomByDirection(Direction direction, Room adjacentRoom, @NotNull Room actualRoom) {
        actualRoom.getAdjacentRooms().put(direction, adjacentRoom);
        adjacentRoom.getAdjacentRooms().put(Direction.getOppositeDirection(direction), actualRoom);
    }
}
