package Controller;

import Domain.GameDomain.*;
import GameControls.Direction;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;

import java.util.Arrays;

@Getter
@Setter
@Log
@ToString
public class GameController {
    private Player player;
    private Room currentRoom;

    public GameController() {
        this.player = gameCreator.createPlayer();
        this.currentRoom = gameCreator.getAllRooms().get(gameCreator.randomRoom());
    }
    GameCreator gameCreator = new GameCreator();

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
              }
        }
        else{
            log.info("Direction not valid. Introduce right direction. ");
        }
    }

    public void showRoomInformation(){
        currentRoom.showRoomInformation();

    }
    public void showBagInformation(){
        player.showBagInformation();
    }
   /* public void showAllRooms(){
        gameCreator.createRooms().forEach(name -> {
                    if(name.getName().equalsIgnoreCase(currentRoom.getName())) {
                        System.out.print('"'+name.getName()+'"');
                        System.out.println("Room at North: " + currentRoom.getAdjacentRoom(Direction.NORTH).getName()+ '\n'+
                                "Room at west: " + currentRoom.getAdjacentRoom(Direction.WEST).getName() +
                                '"'+ currentRoom.getName()+'"'+
                                "Room at East: " + currentRoom.getAdjacentRoom(Direction.EAST).getName() + '\n'+
                                "Room at South: " + currentRoom.getAdjacentRoom(Direction.SOUTH).getName());
                    }
                    else {
                        System.out.print(" " + name + " ");
                    }
                });
            System.out.println();
    }*/
    public Item getItemFromRoom(String itemName){
            return  currentRoom.getItems()
                    .stream()
                    .filter(item -> item.getName().replaceAll("\\s+","").equalsIgnoreCase(itemName))
                    .findFirst().orElse(null);
    }
    public Item getItemFromBag(String itemName){
        return player.getBag().getItems().stream()
                .filter(i-> i.getName().replaceAll("\\s+","").equalsIgnoreCase(itemName))
                .findFirst().orElse(null);
    }
    public void addItemToBag(Item itemFromRoom) {
        if (itemFromRoom == null) {
            log.info("This item does not exist in actual room \n");
        } else {
            player.addItemToBag(itemFromRoom);
        }
    }
    public void dropItemFromBag(Item itemFromBag){
        if (itemFromBag == null) {
            log.info("This item does not exist in the bag \n");
        } else{
            player.dropItemFromBag(itemFromBag);
        }
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

