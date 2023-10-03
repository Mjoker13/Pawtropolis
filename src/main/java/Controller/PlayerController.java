package Controller;

import Domain.GameDomain.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;

@Getter
@Setter
@Log
@ToString
public class PlayerController {
    private Player player;
    GameCreator gameCreator = new GameCreator();

    public PlayerController() {
        this.player = gameCreator.createPlayer();
    }
    public void showBagInformation(){
        player.showBagInformation();
    }
    public Item getItemFromBag(String itemName) {
        return player.getItemFromBag(itemName);
    }
    public void addItemToBag(Item itemFromRoom) {
            player.addItemToBag(itemFromRoom);
    }
    public void dropItemFromBag(Item itemFromBag){
            player.dropItemFromBag(itemFromBag);
    }
}

