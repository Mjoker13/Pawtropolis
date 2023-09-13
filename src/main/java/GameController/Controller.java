package GameController;

import GameDomain.*;

public class Controller {
    public void changeRoom(Player player,String direction) {
        switch (direction.toLowerCase()) {
            case "nord" -> {
                if (player.getStartedPositionInToMap().getName().equalsIgnoreCase("nord")) {
                    System.out.println("Sei già nella stanza Nord");
                } else {
                    player.setStartedPositionInToMap(RoomNord.class);
                }
            }
            case "sud" -> {
                if (player.getStartedPositionInToMap().getName().equalsIgnoreCase("sud")) {
                    System.out.println("Sei già nella stanza Sud");
                } else {
                    player.setStartedPositionInToMap(RoomSud.class);
                }
            }
            case "est" -> {
                if (player.getStartedPositionInToMap().getName().equalsIgnoreCase("est")) {
                    System.err.print("Sei già nella stanza Est");
                } else {
                    player.setStartedPositionInToMap(RoomEst.class);
                }
            }
            case "ovest" -> {
                if (player.getStartedPositionInToMap().getName().equalsIgnoreCase("ovest")) {
                    System.err.print("Sei già nella stanza Ovest");
                } else {
                    player.setStartedPositionInToMap(RoomOvest.class);
                }
            }
            default -> System.out.println("Direzione non valida.");
        }
    }
}
