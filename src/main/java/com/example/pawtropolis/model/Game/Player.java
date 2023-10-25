package com.example.pawtropolis.model.Game;

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
    private PlayerBag playerBag;

    @Autowired
    public Player(PlayerBag playerBag){
        this.playerBag = playerBag;
    }

    public void showsBagInformation() {
        log.info("In bag: " + playerBag.getItems().stream().filter(Objects::nonNull).map(item -> item.getName() + " (x" + item.getQuantity() + ")").toList());
        log.info("Slot available:" + playerBag.getSlotAvailable());
    }
    public void addItemToBag(@NotNull Item item) {
        playerBag.setSlotAvailable(getSlotAvailable());
        if (playerBag.getSlotAvailable() >= item.getSlotRequired()) {
            playerBag.getItems().add(item);
            increaseSlotAvailable(item);
        } else {
            log.info("\n" +"Maximum capacity exceeded");
        }
    }
    public void dropItemFromBag(Item item) {
        playerBag.getItems().remove(item);
        decreaseSlotAvailable(item);
    }
    public Item getItemFromBag(String itemName) {
        return playerBag.getItems().stream()
                .filter(i -> i.getName().replaceAll("\\s+", "").equalsIgnoreCase(itemName))
                .findFirst().orElse(null);
    }
    public int getSlotAvailable() {
        if (playerBag.getItems().isEmpty()) {
            return playerBag.getMaxCapacity();
        }
        return playerBag.getSlotAvailable();
    }
    public void decreaseSlotAvailable(@NotNull Item item) {
        playerBag.setSlotAvailable(playerBag.getSlotAvailable() + item.getSlotRequired());
    }
    public void increaseSlotAvailable(@NotNull Item item) {
        playerBag.setSlotAvailable(playerBag.getSlotAvailable() - item.getSlotRequired());
    }
}
