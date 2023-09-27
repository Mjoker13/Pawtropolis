package Controller;

import Domain.GameDomain.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@Getter
@Setter
@Log
@ToString
public class GameController {
    private Player player;
    private Room actualRoom;

    public GameController() {
        this.player = gameCreator.createPlayer();
        this.actualRoom= gameCreator.getAllRooms().get(gameCreator.randomRooms());
    }
    GameCreator gameCreator = new GameCreator();
    private void moveBetweenRooms(@NotNull String direction, int rowIndex, int columnIndex){
        direction = direction.trim().replace("go", "");
        try {
            switch (direction.toLowerCase()) {
                case "north"-> {
                    actualRoom = gameCreator.createRooms().get(rowIndex -1).get(columnIndex);
                    log.info("Now you are in the North Room " + actualRoom.getName());
                }
                case "south" -> {
                    actualRoom = gameCreator.createRooms().get(rowIndex +1).get(columnIndex);
                    log.info("Now you are in the South Room " + actualRoom.getName());
                }
                case "east" -> {
                    actualRoom = gameCreator.createRooms().get(rowIndex).get(columnIndex +1);
                    log.info("Now you are in the East Room "+ actualRoom.getName());
                }
                case "west" -> {
                    actualRoom = gameCreator.createRooms().get(rowIndex).get(columnIndex -1);
                    log.info("Now you are in the West Room "+ actualRoom.getName());
                }
                default -> log.info("Direction not found.");
            }
        } catch (IndexOutOfBoundsException e) {
            direction = direction.replace("go ", "").toUpperCase();
            log.info("A room at: '" + direction+"' is not found. \nNow you are into: "+ actualRoom.getName() + "\n");
            showAllRooms(actualRoom.getName());

        }
    }
    public void changeRoom(String direction) {
        boolean flag=true;
            for (int rowIndex =0;rowIndex<gameCreator.createRooms().size();rowIndex++) {
                for (int columnIndex = 0; columnIndex<gameCreator.createRooms().get(rowIndex).size(); columnIndex++) {
                    if (gameCreator.createRooms().get(rowIndex).get(columnIndex).getName().equalsIgnoreCase(actualRoom.getName()) && flag) {
                         moveBetweenRooms(direction, rowIndex, columnIndex);
                         flag=false;
                        break;
                    }
                }
            }
    }
    public void getInformationFromRoom(){
        System.out.println("You are in: " + actualRoom.getName());
        System.out.println("\nItems present in room: " + actualRoom.getItems().stream().filter(Objects::nonNull).map(item -> item.getName() + " (x" + item.getQuantity() + ")").toList());
        System.out.println("NPC: " + actualRoom.getAnimals().stream().filter(Objects::nonNull).map(animal -> animal.getName() + " (" + animal.getClass().getSimpleName() + ")").toList() + "\n");
    }
    public void getInformationFromBag(){
        System.out.println("In bag: " + player.getBag().getItems().stream().filter(Objects::nonNull).map(item -> item.getName() + " (x" + item.getQuantity() + ")").toList());
        System.out.println("Slot available:" + player.getBag().getSlotAvailable());
    }
    public void showAllRooms(String roomPlayer){
        gameCreator.createRooms().forEach(row -> { row.stream()
                .map(Room::getName)
                .forEach(name -> {if(name.equalsIgnoreCase(roomPlayer)) System.out.print('"'+name+'"'); else System.out.print(" "+name + " ");
                });
            System.out.println();
        });
    }
    public Item getItemFromRoom(String itemName){
            return  actualRoom.getItems()
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
        boolean existingElement = false;
        if (itemFromRoom == null) {
            log.info("This item does not exist in actual room \n");
        } else {
            if (player.getBag().getSlotAvailable() >= itemFromRoom.getSlotRequired()) {
                for (Item itemCurrent : player.getBag().getItems()) {
                    if (itemCurrent.getName().replaceAll("\\s+", "").equalsIgnoreCase(itemFromRoom.getName())) {
                        itemCurrent.increaseQuantity();
                        existingElement= true;
                        break;
                    }
                }
                if (!existingElement) {
                    player.getBag().getItems().add(itemFromRoom);
                }
                player.getBag().setSlotAvailable(player.getBag().getSlotAvailable() - itemFromRoom.getSlotRequired());
            } else {
                log.info("Maximum capacity exceeded");
            }
        }
    }
    public void dropItemFromBag(Item itemFromBag){
        boolean existingElement= false;
        if (itemFromBag == null) {
            log.info("This item does not exist in the bag \n");
        } else{
                for (Item itemCurrent: player.getBag().getItems()) {
                    if(itemCurrent.getName().replaceAll("\\s+","").equalsIgnoreCase(itemFromBag.getName()) && itemFromBag.getQuantity()> 1){
                        itemCurrent.decreaseQuantity();
                        existingElement= true;
                        break;
                    }
                }
                if(!existingElement) {
                    player.getBag().getItems().remove(itemFromBag);
                }
                player.getBag().setSlotAvailable(player.getBag().getSlotAvailable() + itemFromBag.getSlotRequired());

        }
    }
    public void addItemToRoom(Item itemFromBag){
        boolean existingElement= false;
        if (itemFromBag != null) {
                for (Item itemCurrent: actualRoom.getItems()) {
                    if(itemCurrent.getName().replaceAll("\\s+","").equalsIgnoreCase(itemFromBag.getName())){
                        itemCurrent.increaseQuantity();
                        existingElement = true;
                        break;
                    }
                }
                if(!existingElement) {
                    actualRoom.getItems().add(itemFromBag);
                }
        }
    }
    public void dropItemFromRoom(Item itemFromRoom){
        boolean existingElement= false;
        if (itemFromRoom != null) {
            for (Item itemCurrent: player.getBag().getItems()) {
                if(itemCurrent.getName().replaceAll("\\s+","").equalsIgnoreCase(itemFromRoom.getName()) && itemFromRoom.getQuantity()> 1){
                    itemCurrent.decreaseQuantity();
                    existingElement= true;
                    break;
                }
            }
            if(!existingElement) {
                actualRoom.getItems().remove(itemFromRoom);
            }
        }
    }
}

