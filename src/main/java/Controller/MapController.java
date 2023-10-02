package Controller;

import Domain.GameDomain.Item;
import Domain.GameDomain.Room;
import GameControls.Direction;
import lombok.extern.java.Log;

import java.util.Arrays;
@Log
public class MapController {
    private Room currentRoom;
    GameCreator creator= new GameCreator();
    public MapController() {
        this.currentRoom = creator.getAllRooms().get(creator.randomRoom());
    }
    public void changeRoom(String directionString) {
        if(Arrays.stream(Direction.values()).anyMatch(a -> directionString.equalsIgnoreCase(a.name()))) {
            Direction direction = Direction.valueOf(directionString.trim().replaceAll("\\s+", "").toUpperCase());
            Room adjacentRoom = currentRoom.getAdjacentRoom(direction);
            if (adjacentRoom != null) {
                System.out.println("You moved from the room " + currentRoom.getName() + " to room " + adjacentRoom.getName());
                currentRoom = adjacentRoom;
            }
            else {
                System.out.println("You cannot move in this direction.");
                currentRoom.nearbyRoom();
            }
        }
        else{
            log.info("Direction not valid. Introduce right direction. ");
        }
    }
    public void showRoomInformation(){
        currentRoom.showRoomInformation();
    }
    public Item getItemFromRoom(String itemName){
       return currentRoom.getItemFromRoom(itemName);
    }
    public void addItemToRoom(Item itemFromBag) {
        if (itemFromBag != null) {
            currentRoom.addItem(itemFromBag);
        }
    }
    public void dropItemFromRoom(Item itemFromRoom){
        if (itemFromRoom != null) {
            currentRoom.dropItem(itemFromRoom);
        }
    }
}
