package Controller;

import Domain.GameDomain.Item;
import Domain.GameDomain.Room;
import GameControls.Direction;
import lombok.extern.java.Log;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
@Log
public class MapController {
    private Room currentRoom;
    GameCreator creator= new GameCreator();
    public MapController() {
        this.currentRoom = creator.getAllRooms().get(creator.randomRoom());
    }
    public void changeRoom(@NotNull String directionString) {
            if(directionString.isEmpty()){
                log.info("Direction not valid. Introduce right direction. ");
            }else {
                Direction direction = Direction.valueOf(directionString.trim().toUpperCase());
                if (Arrays.stream(Direction.values()).anyMatch(a -> direction.name().equalsIgnoreCase(a.name())) && currentRoom.getAdjacentRoom(direction) != null ) {
                        System.out.println("You moved from the room " + currentRoom.getName() + " to room " + currentRoom.getAdjacentRoom(direction).getName());
                        currentRoom = currentRoom.getAdjacentRoom(direction);
                } else {
                    log.info("Direction not valid. Introduce right direction. ");
                    currentRoom.nearbyRoom();
                }
            }
    }
    public void showRoomInformation(){
        currentRoom.showRoomInformation();
    }
    public Item getItemFromRoom(String itemName){
       return currentRoom.getItemFromRoom(itemName);
    }
    public void addItemToRoom(Item itemFromBag) {
            currentRoom.addItem(itemFromBag);
    }
    public void dropItemFromRoom(Item itemFromRoom){
            currentRoom.dropItem(itemFromRoom);
    }
}
