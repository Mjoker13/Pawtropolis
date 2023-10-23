package com.example.pawtropolis.controller;


import com.example.pawtropolis.model.Game.*;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Data
@Log4j2
@Service
public class PlayerController {
    private Player player;
    private BagPlayer bagPlayer;

    @Autowired
    public PlayerController(Player player, BagPlayer bagPlayer) {

        this.player = player;
        this.bagPlayer = bagPlayer;
    }

    public void showsBagInformation() {
        System.out.println("In bag: " + bagPlayer.getItems().stream().filter(Objects::nonNull).map(item -> item.getName() + " (x" + item.getQuantity() + ")").toList());
        System.out.println("Slot available:" + bagPlayer.getSlotAvailable());
    }

    public void addItemToBag(Item item) {
        bagPlayer.setSlotAvailable(getSlotAvailable());
        if (bagPlayer.getSlotAvailable() >= item.getSlotRequired()) {
            bagPlayer.getItems().add(item);
            increaseSlotAvailable(item);
        } else {
            log.info("Maximum capacity exceeded");
        }
    }

    public void dropItemFromBag(Item item) {
        bagPlayer.getItems().remove(item);
        decreaseSlotAvailable(item);
    }

    public Item getItemFromBag(String itemName) {
        return bagPlayer.getItems().stream()
                .filter(i -> i.getName().replaceAll("\\s+", "").equalsIgnoreCase(itemName))
                .findFirst().orElse(null);
    }

    public int getSlotAvailable() {
        if (bagPlayer.getItems().isEmpty()) {
            return bagPlayer.getMaxCapacity();
        }
        return bagPlayer.getSlotAvailable();
    }

    public void decreaseSlotAvailable(@NotNull Item item) {
        bagPlayer.setSlotAvailable(bagPlayer.getSlotAvailable() + item.getSlotRequired());
    }

    public void increaseSlotAvailable(@NotNull Item item) {
        bagPlayer.setSlotAvailable(bagPlayer.getSlotAvailable() - item.getSlotRequired());
    }


}

