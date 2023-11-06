package com.example.pawtropolis.DTO.game;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Getter
@Setter
@Log4j2
@Component
public class Player {

    private String name;
    private int lifePoints;
    private PlayerBag player_bag;

    @Autowired
    public Player(PlayerBag player_bag){
        this.player_bag = player_bag;
    }

    public void showsBagInformation() {
        log.info("In bag: " + player_bag.getItems().stream().filter(Objects::nonNull).map(Item::getName).toList());
        log.info("Slot available:" + player_bag.getSlotAvailable());
    }
    public void addItemToBag(@NotNull Item item) {
        if (player_bag.getSlotAvailable() >= item.getSlotRequired()) {
            player_bag.getItems().add(item);
        } else {
            log.info("\n" +"Maximum capacity exceeded");
        }
    }
    public void dropItemFromBag(Item item) {
        player_bag.getItems().remove(item);
    }
    public Item getItemFromBag(String itemName) {
        return player_bag.getItems().stream()
                .filter(i -> i.getName().equalsIgnoreCase(itemName))
                .findFirst().orElse(null);
    }
}
