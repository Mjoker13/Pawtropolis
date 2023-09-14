package Controller;

import Domain.GameDomain.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;
import org.jetbrains.annotations.NotNull;

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

    /*public void changeRoom(Player player, String direction) {
        String room;
        room= player.getActuallyRoom().getName().replace("Domain.GameDomain.Room","");
        switch (direction.toLowerCase()) {
            case "go nord" -> {
                if (room.equalsIgnoreCase("nord")) {
                    log.info("You are already in the Nord Room");
                } else {
                    player.getActuallyRoom();
                    log.info("Now you are in the Nord Room");
                }
            }
            case "go sud" -> {
                if (room.equalsIgnoreCase("sud")) {
                    log.info("Sei gia' nella stanza Sud");
                } else {
                    player.getActuallyRoom();
                    log.info("Spostamento completato, ora ti trovi nella stanza Sud");
                }
            }
            case "go est" -> {
                if (room.equalsIgnoreCase("est")) {
                    log.info("Sei gia' nella stanza Est");
                } else {
                    player.getActuallyRoom();
                    log.info("Spostamento completato, ora ti trovi nella stanza Est");
                }
            }
            case "go ovest" -> {
                if (room.equalsIgnoreCase("ovest")) {
                    log.info("Sei gia' nella stanza Ovest");
                } else {
                    player.getActuallyRoom();
                    log.info("Spostamento completato, ora ti trovi nella stanza Ovest");
                }
            }
            default -> log.info("Direzione non valida.");
        }
    }*/
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
