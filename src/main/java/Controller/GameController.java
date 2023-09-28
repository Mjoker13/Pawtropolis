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
    private Room currentRoom;

    //todo trovare un modo per utilizzare gli enum

    //TODO aggiungere il map controller ed
    public GameController() {
        this.player = gameCreator.createPlayer();
        this.currentRoom = gameCreator.getAllRooms().get(gameCreator.randomRooms());
    }
    GameCreator gameCreator = new GameCreator();
    private void moveBetweenRooms(@NotNull String direction, int rowIndex, int columnIndex){
        //TODO mettere un controllo prima per evitare di andare in eccezzione

        direction = direction.trim().replace("go", "");
        try {
            switch (direction.toLowerCase()) {
                case "north"-> {
                    currentRoom = gameCreator.createRooms().get(rowIndex -1).get(columnIndex);
                    log.info("Now you are in the North Room " + currentRoom.getName());
                }
                case "south" -> {
                    currentRoom = gameCreator.createRooms().get(rowIndex +1).get(columnIndex);
                    log.info("Now you are in the South Room " + currentRoom.getName());
                }
                case "east" -> {
                    currentRoom = gameCreator.createRooms().get(rowIndex).get(columnIndex +1);
                    log.info("Now you are in the East Room "+ currentRoom.getName());
                }
                case "west" -> {
                    currentRoom = gameCreator.createRooms().get(rowIndex).get(columnIndex -1);
                    log.info("Now you are in the West Room "+ currentRoom.getName());
                }
                default -> log.info("Direction not found.");
            }
        } catch (IndexOutOfBoundsException e) {
            direction = direction.replace("go ", "").toUpperCase();
            log.info("A room at: '" + direction+"' is not found. \nNow you are into: "+ currentRoom.getName() + "\n");
            showAllRooms();
        }
    }
    public void changeRoom(String direction) {
            for (int rowIndex =0;rowIndex<gameCreator.createRooms().size();rowIndex++) {
                for (int columnIndex = 0; columnIndex<gameCreator.createRooms().get(rowIndex).size(); columnIndex++) {
                    if (gameCreator.createRooms().get(rowIndex).get(columnIndex).getName().equalsIgnoreCase(currentRoom.getName())) {
                         moveBetweenRooms(direction, rowIndex, columnIndex);
                         return;
                    }
                }
            }
    }
    public void showRoomInformation(){
        currentRoom.showRoomInformation();
    }
    public void showBagInformation(){
        player.showBagInformation();
    }
    public void showAllRooms(){
        gameCreator.createRooms().forEach(row -> { row.stream()
                .map(Room::getName)
                .forEach(name -> {
                    if(name.equalsIgnoreCase(currentRoom.getName())) {
                        System.out.print('"'+name+'"');
                    }
                    else {
                        System.out.print(" " + name + " ");
                    }
                });
            System.out.println();
        });
    }
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
                for (Item itemCurrent: currentRoom.getItems()) {
                    if(itemCurrent.getName().replaceAll("\\s+","").equalsIgnoreCase(itemFromBag.getName())){
                        itemCurrent.increaseQuantity();
                        existingElement = true;
                        break;
                    }
                }
                if(!existingElement) {
                    currentRoom.getItems().add(itemFromBag);
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
                currentRoom.getItems().remove(itemFromRoom);
            }
        }
    }
}

