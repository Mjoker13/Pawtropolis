package com.example.pawtropolis.Domain.GameDomain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;

@Setter
@Getter
@ToString
@Log
public class Player {
    private String name;
    private final int lifePoints;
    private BagPlayer bagPlayer;

    public Player(String name, BagPlayer bagPlayer) {
        this.name = name;
        this.lifePoints = 100;
        this.bagPlayer = bagPlayer;
    }

    public void showBagInformation() {
        bagPlayer.showItemsInformation();
    }

    public void addItemToBag(Item item) {
        bagPlayer.addItem(item);
    }

    public void dropItemFromBag(Item item) {
        bagPlayer.dropItem(item);
    }

    public Item getItemFromBag(String itemName) {
        return bagPlayer.getItemFromBag(itemName);
    }
}
