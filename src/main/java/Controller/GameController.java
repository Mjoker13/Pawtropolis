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

    public GameController() {
        this.player = gameCreator.createPlayer();
        this.currentRoom = gameCreator.getAllRooms().get(gameCreator.randomRooms());
    }
    GameCreator gameCreator = new GameCreator();

    public void showRoomInformation(){
        currentRoom.showRoomInformation();
    }
    public void showBagInformation(){
        player.showBagInformation();
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

