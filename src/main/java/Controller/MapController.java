package Controller;

import Domain.GameDomain.Item;
import Domain.GameDomain.Room;
import GameControls.Direction;
import lombok.extern.java.Log;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Optional;

@Log
public class MapController {
    private Room currentRoom;
    GameCreator creator = new GameCreator();
    public MapController() {
        this.currentRoom = creator.getAllRooms().get(1);
    }

    public void changeRoom(@NotNull String directionString) {
        Direction direction = Direction.convertingStringToDirection(directionString.trim());
        if (direction == null) {
            log.info("Direction not valid. Introduce right direction. ");
        } else {
            Optional<Direction> validDirection = Arrays.stream(Direction.values())
                    .filter(a -> direction.name().equalsIgnoreCase(a.name()))
                    .findFirst();
            if (validDirection.isPresent() && currentRoom.getAdjacentRooms(direction) != null) {
                System.out.println("You moved from the room " + currentRoom.getName() + " to room " + currentRoom.getAdjacentRooms(direction).getName());
                currentRoom = currentRoom.getAdjacentRooms(direction);
            } else {
                log.info("Direction not valid. Introduce right direction. ");
                currentRoom.showAdjacentRooms();
            }
        }
    }

    public void showsRoomInformation() {
        currentRoom.showRoomInformation();
    }

    public Item getItemFromRoom(String itemName) {
        return currentRoom.getItemFromRoom(itemName);
    }

    public void addItemToRoom(Item itemFromBag) {
        currentRoom.addItem(itemFromBag);
    }

    public void dropItemFromRoom(Item itemFromRoom) {
        currentRoom.dropItem(itemFromRoom);
    }

}
