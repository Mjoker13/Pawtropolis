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
                                    roomEast = roomList.get(riga).get(colonna+1);
                                    player.setActuallyRoom(roomEast);
                                    log.info("Now you are in the East Room "+ roomEast.getName());
                                    break;
                                }
                                case "go west" -> {
                                    roomWest = roomList.get(riga).get(colonna-1);
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
                if(roomEast!=null || roomSud!=null || roomWest!=null || roomNord!=null )
                    break;
                riga++;
            }
        return player.getActuallyRoom();
        }
    public void getInformationInRoom(@NotNull Room room){
        System.out.println("The name of room is: " + room.getName());
        System.out.println("Item present in room : " + room.getItemsPresentInRoom());
        System.out.println("Animal present in room " + room.getAnimals());
    }
    public void getInformationBag(){
        List<Item> items=  player.getBag().getItemsInBag();
        for (Item item:items){
            System.out.println("In bag: " + item.getName() + ", " + item.getDescription());
        }
    }
    public void addItemBag(Player player,String s){
            for (Item i : itemList) {
                if (i.getName().equalsIgnoreCase(s) && (player.getBag().getSlotAvailable() > i.getSlotRequired())) {
                        player.getBag().getItemsInBag().add(i);
                        removeItemRoom(player,s);
                        player.getBag().setSlotAvailable(player.getBag().getSlotAvailable() - i.getSlotRequired());
                        break;
                }
            }
    }
    public void addItemRoom(Player player,String s){
        for (Item i: itemList) {
            if (i.getName().equalsIgnoreCase(s)) {
                player.getActuallyRoom().getItemsPresentInRoom().add(i);
            }
        }
    }
    public void removeItemBag(@NotNull Player player, String s){
        for (Item i : player.getBag().getItemsInBag()) {
            if (i.getName().equalsIgnoreCase(s)) {
                player.getBag().getItemsInBag().remove(i);
                addItemRoom(player,s);
                player.getBag().setSlotAvailable(player.getBag().getSlotAvailable() + i.getSlotRequired());
                break;
            }
        }
    }
    public void removeItemRoom(@NotNull Player player, String s){
        player.getActuallyRoom().getItemsPresentInRoom().removeIf(i -> i.getName().equalsIgnoreCase(s));
    }
}
