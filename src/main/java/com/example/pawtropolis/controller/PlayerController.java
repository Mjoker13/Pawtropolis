package com.example.pawtropolis.controller;


import com.example.pawtropolis.model.Game.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Data
@Service
public class PlayerController {
    private  Player player;
    @Autowired
    public PlayerController(Player player) {
        this.player = player;
    }

    public void showsBagInformation() {
        player.getBagPlayer().showItemsInformation();
    }
    public void addItemToBag(Item item) {
        player.getBagPlayer().addItem(item);
    }

    public void dropItemFromBag(Item item) {
        player.getBagPlayer().dropItem(item);
    }

    public Item getItemFromBag(String itemName) {
        return player.getBagPlayer().getItemFromBag(itemName);
    }
}

