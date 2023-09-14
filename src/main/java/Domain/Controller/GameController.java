package Domain.Controller;

import GameDomain.*;
import lombok.extern.java.Log;

@Log
public class GameController {
    public void changeRoom(Player player, String direction) {
        String room;
        room= player.getStartedPositionInToMap().getName().replace("GameDomain.Room","");

        switch (direction.toLowerCase()) {
            case "nord" -> {
                if (room.equalsIgnoreCase("nord")) {
                    log.info("Sei gia' nella stanza Nord");
                } else {
                    player.setStartedPositionInToMap(RoomNord.class);
                    log.info("Spostamento completato, ora ti trovi nella stanza Nord");
                }
            }
            case "sud" -> {
                if (room.equalsIgnoreCase("sud")) {
                    log.info("Sei gia' nella stanza Sud");
                } else {
                    player.setStartedPositionInToMap(RoomSud.class);
                    log.info("Spostamento completato, ora ti trovi nella stanza Sud");
                }
            }
            case "est" -> {
                if (room.equalsIgnoreCase("est")) {
                    log.info("Sei gia' nella stanza Est");
                } else {
                    player.setStartedPositionInToMap(RoomEst.class);
                    log.info("Spostamento completato, ora ti trovi nella stanza Est");
                }
            }
            case "ovest" -> {
                if (room.equalsIgnoreCase("ovest")) {
                    log.info("Sei gia' nella stanza Ovest");
                } else {
                    player.setStartedPositionInToMap(RoomOvest.class);
                    log.info("Spostamento completato, ora ti trovi nella stanza Ovest");
                }
            }
            default -> log.info("Direzione non valida.");
        }
    }
}
