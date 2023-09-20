package Controller;

import Domain.GameDomain.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    private Room switchBetweenRooms(String direction, int rowIndex, int columnIndex, List<ArrayList<Room>> roomsList){
        Room switchableRoom = null;
        try {
            switch (direction.toLowerCase()) {
                case "go north"-> {
                    switchableRoom = roomsList.get(rowIndex -1).get(columnIndex);
                    player.setActuallyRoom(switchableRoom);
                    log.info("Now you are in the North Room " + switchableRoom.getName());
                }
                case "go south" -> {
                    switchableRoom = roomsList.get(rowIndex +1).get(columnIndex);
                    player.setActuallyRoom(switchableRoom);
                    log.info("Now you are in the South Room " + switchableRoom.getName());
                }
                case "go east" -> {
                    switchableRoom = roomsList.get(rowIndex).get(columnIndex +1);
                    player.setActuallyRoom(switchableRoom);
                    log.info("Now you are in the East Room "+ switchableRoom.getName());
                }
                case "go west" -> {
                    switchableRoom = roomsList.get(rowIndex).get(columnIndex -1);
                    player.setActuallyRoom(switchableRoom);
                    log.info("Now you are in the West Room "+ switchableRoom.getName());
                }
                default -> log.info("Direction not found. ChangeRoom");
            }
        } catch (IndexOutOfBoundsException e) {
            direction = direction.replace("go ", "").toUpperCase();
            switchableRoom = roomsList.get(rowIndex).get(columnIndex);
             System.err.println("A room at: '" + direction+"' is not found. \nNow you are into: "+ switchableRoom.getName() + "\n");
            printAllRooms(player.getActuallyRoom().getName());

        }
        return switchableRoom;
    }
    public void changeRoom(Player player, String direction) {
        List<ArrayList<Room>> roomsList =gameCreator.createRooms();
        Room switchableRoom =null;
        int rowIndex =0;
            for (List<Room> rowRoomList : roomsList) {
                int columnIndex = 0;
                for (Room room1 : rowRoomList) {
                    String room = room1.getName();
                    if (room.equalsIgnoreCase(player.getActuallyRoom().getName())) {
                         switchableRoom = switchBetweenRooms(direction, rowIndex, columnIndex, roomsList);
                        break;
                    }
                    columnIndex++;
                }
                if(switchableRoom !=null )
                    break;
                rowIndex++;
            }
    }
    public void getInformationInRoom(@NotNull Room room){
        System.out.println("The name of room is: " + room.getName());
        System.out.println("\nItem present in room : " + room.getItemsPresentInRoom().stream().filter(Objects::nonNull).map(Item::getName ).toList());
        System.out.println("Animal in room are :" + room.getAnimals().stream().filter(Objects::nonNull).map(animal -> animal.getName() + " ( " + animal.getClass().getSimpleName() + " )").toList());
    }
    public void getInformationBag(@NotNull Bag bag){
        System.out.println("Item present in bag : " + bag.getItemsInBag().stream().filter(Objects::nonNull).map(Item::getName).toList());
        System.out.println("Slot available :" + bag.getSlotAvailable());
    }
    public boolean addItemBag(@NotNull Player player, String s){
            for (Item i : player.getActuallyRoom().getItemsPresentInRoom()) {
                if (i.getName().equalsIgnoreCase(s) && (player.getBag().getSlotAvailable() > i.getSlotRequired())) {
                        player.getBag().getItemsInBag().add(i);
                        removeItemRoom(player,s);
                        player.getBag().setSlotAvailable(player.getBag().getSlotAvailable() - i.getSlotRequired());
                        return true;
                }
            }
        return false;
    }
    public void addItemRoom(Player player,String s){
        for (Item i: itemList) {
            if (i.getName().equalsIgnoreCase(s)) {
                player.getActuallyRoom().getItemsPresentInRoom().add(i);
            }
        }
    }
    public boolean removeItemBag(@NotNull Player player, String s){
        // player.getBag().getItemsInBag().removeIf(i -> i.getName().equalsIgnoreCase(s));
        for (Item i : player.getBag().getItemsInBag()) {
            if (i.getName().equalsIgnoreCase(s)) {
                player.getBag().getItemsInBag().remove(i);
                addItemRoom(player,s);
                player.getBag().setSlotAvailable(player.getBag().getSlotAvailable() + i.getSlotRequired());
            return true;
            }
        }
        return false;
    }
    public void removeItemRoom(@NotNull Player player, String s){
        player.getActuallyRoom().getItemsPresentInRoom().removeIf(i -> i.getName().equalsIgnoreCase(s));
    }
    public void printAllRooms(String roomPlayer){
        gameCreator.createRooms().forEach(row -> { row.stream()
                .map(Room::getName)
                .forEach(name -> {if(name.equalsIgnoreCase(roomPlayer)) System.out.print('"'+name+'"'); else System.out.print(" "+name + " ");
                });
            System.out.println();
        });
    }

}
