package Controller;

import Domain.GameDomain.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Log
@ToString
public class GameController {
    private Player player;
    private Bag bag;
    private List<Room> rooms;
    private List<Item> itemList;

    public GameController() {
        this.player = gameCreator.createPlayer();
        this.bag = gameCreator.createBag();
        this.rooms = gameCreator.getAllRooms();
        this.itemList = gameCreator.createItem();
    }

    GameCreator gameCreator = new GameCreator();




    public Room changeRoom(Player player, String direction) {
        GameCreator gameCreator= new GameCreator();
        List<ArrayList<Room>> roomList=gameCreator.createRooms();
        String room ;
        Room roomNord= null;
        Room roomSud= null;
        Room roomWest= null;
        Room roomEast= null;
        int riga=0;




            for (List<Room> row : roomList) {
                int colonna = 0;
                for (Room room1 : row) {
                    room = room1.getName();
                    if (room.equalsIgnoreCase(player.getActuallyRoom().getName())) {
                        try {
                            switch (direction.toLowerCase()) {
                                case "go north" -> {
                                    roomNord = roomList.get(riga-1).get(colonna);
                                    player.setActuallyRoom(roomNord);
                                    log.info("Now you are in the North Room " + roomNord.getName());
                                    break;
                                }
                                case "go south" -> {
                                    roomSud = roomList.get(riga+1).get(colonna);
                                    player.setActuallyRoom(roomSud);
                                    log.info("Now you are in the South Room " + roomSud.getName());
                                    break;
                                }
                                case "go east" -> {
                                    roomEast = roomList.get(riga).get(colonna-1);
                                    player.setActuallyRoom(roomEast);
                                    log.info("Now you are in the East Room "+ roomEast.getName());
                                    break;
                                }
                                case "go west" -> {
                                    roomWest = roomList.get(riga).get(colonna+1);
                                    player.setActuallyRoom(roomWest);
                                    log.info("Now you are in the West Room "+roomWest.getName());
                                    break;
                                }
                                default -> log.info("Direction not found.");
                            }
                        } catch (IndexOutOfBoundsException e) {
                            direction = direction.replace("go ", "").toUpperCase();
                            System.err.println("A room at: '" + direction+"' is not found. \nNow you are into: "+ room);
                        }
                        break;
                    }
                    colonna++;
                }
            }
        return player.getActuallyRoom();
        }
    public void getInformationInRoom(@NotNull Room room){
        System.out.println("The name of room is: " + room.getName());
        System.out.println("Item present in room : " + room.getItemsPresentInRoom());
        System.out.println("Animal present in room " + room.getAnimals());
    }
    public void addItemRoom(@NotNull Room room, Item item){
        room.getItemsPresentInRoom().add(item);
    }
    private void removeItemRoom(@NotNull Room room, Item item){
        room.getItemsPresentInRoom().remove(item);
    }
    private void addItemBag(@NotNull Bag bag, Item item){
        bag.getItemsInBag().add(item);
    }
    private void removeItemBag(@NotNull Bag bag, Item item){
        bag.getItemsInBag().remove(item);
    }

    // da sistemare
    public void dropAndAddItem(Item itemPresentInRoom){
        for (Item currentItem:player.getBag().getItemsInBag()) {
            if(currentItem == itemPresentInRoom){
                addItemRoom(player.getActuallyRoom(),itemPresentInRoom);
                removeItemBag(bag,itemPresentInRoom);
            }else{
                addItemBag(bag,itemPresentInRoom);
                removeItemRoom(player.getActuallyRoom(),itemPresentInRoom);
            }
        }
    }
}

