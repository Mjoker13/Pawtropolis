package Controller;

import Domain.GameDomain.*;
import GameControls.Direction;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;

import java.util.Arrays;

@Getter
@Setter
@Log
@ToString
public class GameController {
    private Player player;
    GameCreator gameCreator = new GameCreator();

    public GameController() {
        this.player = gameCreator.createPlayer();
    }

    public void showBagInformation(){
        player.showBagInformation();
    }
    public Item getItemFromBag(String itemName){
        return player.getBag().getItems().stream()
                .filter(i-> i.getName().replaceAll("\\s+","").equalsIgnoreCase(itemName))
                .findFirst().orElse(null);
    }
    public void addItemToBag(Item itemFromRoom) {
        if (itemFromRoom == null) {
            log.info("This item does not exist in actual room \n");
        } else {
            player.addItemToBag(itemFromRoom);
        }
    }
    public void dropItemFromBag(Item itemFromBag){
        if (itemFromBag == null) {
            log.info("This item does not exist in the bag \n");
        } else{
            player.dropItemFromBag(itemFromBag);
        }
    }
}

