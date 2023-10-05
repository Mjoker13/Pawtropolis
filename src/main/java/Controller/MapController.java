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
        if (directionString.isEmpty()) {
            log.info("Direction not valid. Introduce right direction. ");
            return;
        }
        Direction direction = Direction.convertingStringToDirection(directionString.trim());
        Optional<Direction> validDirection = Arrays.stream(Direction.values())
                .filter(a -> {
                    assert direction != null;
                    return direction.name().equalsIgnoreCase(a.name());
                })
                .findFirst();
        if (validDirection.isPresent() && currentRoom.getAdjacentRooms(direction) != null) {
            System.out.println("You moved from the room " + currentRoom.getName() + " to room " + currentRoom.getAdjacentRooms(direction).getName());
            currentRoom = currentRoom.getAdjacentRooms(direction);
        } else {
            log.info("Direction not valid. Introduce right direction. ");
            currentRoom.showNearbyRoom();
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
