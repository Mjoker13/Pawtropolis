package Controller;

import Domain.AnimalDomain.Animal;
import Domain.AnimalDomain.Eagle;
import Domain.AnimalDomain.Lion;
import Domain.AnimalDomain.Tiger;
import Domain.GameDomain.*;
import lombok.extern.java.Log;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log
public class GameController {
    public void changeRoom(Player player, String direction) {
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
    }
    public void getInformationInRoom(Room room){
        System.out.println("The name of room is: " + room.getName());
        System.out.println("Item present in room : " + room.getItemPresent());
        System.out.println("Animal present in room " + room.getAnimals());
    }
    public void dropItem(){
    }

}
