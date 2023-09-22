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
    private Room switchBetweenRooms(@NotNull String direction, int rowIndex, int columnIndex, List<ArrayList<Room>> roomsList){
        Room switchableRoom = null;
        try {
            switch (direction.toLowerCase()) {
                case "1" -> {
                    switchableRoom = roomsList.get(rowIndex +1).get(columnIndex);
                    player.setActuallyRoom(switchableRoom);
                    log.info("Now you are in the South Room " + switchableRoom.getName());
                }
                case "2"-> {
                    switchableRoom = roomsList.get(rowIndex -1).get(columnIndex);
                    player.setActuallyRoom(switchableRoom);
                    log.info("Now you are in the North Room " + switchableRoom.getName());
                }
                case "3" -> {
                    switchableRoom = roomsList.get(rowIndex).get(columnIndex +1);
                    player.setActuallyRoom(switchableRoom);
                    log.info("Now you are in the East Room "+ switchableRoom.getName());
                }
                case "4" -> {
                    switchableRoom = roomsList.get(rowIndex).get(columnIndex -1);
                    player.setActuallyRoom(switchableRoom);
                    log.info("Now you are in the West Room "+ switchableRoom.getName());
                }
                default -> log.info("Direction not found. ChangeRoom");
            }
        } catch (IndexOutOfBoundsException e) {
            switchableRoom = roomsList.get(rowIndex).get(columnIndex);
            System.err.println("There are no rooms in this direction. \nNow you are into: "+ switchableRoom.getName() + "\n");
            printAllRooms(player.getActuallyRoom().getName());

        }
        return switchableRoom;
    }
    public void changeRoom(Player player, String direction) {
        Room switchableRoom =null;
        int rowIndex =0;
            for (List<Room> rowRoomList :gameCreator.createRooms()) {
                int columnIndex = 0;
                for (Room room1 : rowRoomList) {
                    String room = room1.getName();
                    if (room.equalsIgnoreCase(player.getActuallyRoom().getName())) {
                         switchableRoom = switchBetweenRooms(direction, rowIndex, columnIndex, gameCreator.createRooms());
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
        System.out.println("\nItem present in room : " + room.getItemsPresentInRoom().stream().filter(Objects::nonNull).map(item -> item.getName() + " (x" + item.getQuantity() + ")").toList());
        System.out.println("Animal in room are :" + room.getAnimals().stream().filter(Objects::nonNull).map(animal -> animal.getName() + " (" + animal.getClass().getSimpleName() + ")").toList() + "\n");
    }
    public void getInformationBag(@NotNull Bag bag){
        System.out.println("Item present in bag : " + bag.getItemsInBag().stream().filter(Objects::nonNull).map(item -> item.getName() + " (x" + item.getQuantity() + ")").toList());
        System.out.println("Slot available :" + bag.getSlotAvailable());
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

