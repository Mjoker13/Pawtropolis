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
    private Bag bag;

    @Autowired
    public Player(Bag bag){
        this.bag= bag;
    }

    public void showsBagInformation() {
        System.out.println("In bag: " + bag.getItems().stream().filter(Objects::nonNull).map(item -> item.getName() + " (x" + item.getQuantity() + ")").toList());
        System.out.println("Slot available:" + bag.getSlotAvailable());
    }
    public void addItemToBag(@NotNull Item item) {
        bag.setSlotAvailable(getSlotAvailable());
        if (bag.getSlotAvailable() >= item.getSlotRequired()) {
            bag.getItems().add(item);
            increaseSlotAvailable(item);
        } else {
            log.info("Maximum capacity exceeded");
        }
    }
    public void dropItemFromBag(Item item) {
        bag.getItems().remove(item);
        decreaseSlotAvailable(item);
    }
    public Item getItemFromBag(String itemName) {
        return bag.getItems().stream()
                .filter(i -> i.getName().replaceAll("\\s+", "").equalsIgnoreCase(itemName))
                .findFirst().orElse(null);
    }
    public int getSlotAvailable() {
        if (bag.getItems().isEmpty()) {
            return bag.getMaxCapacity();
        }
        return bag.getSlotAvailable();
    }
    public void decreaseSlotAvailable(@NotNull Item item) {
        bag.setSlotAvailable(bag.getSlotAvailable() + item.getSlotRequired());
    }
    public void increaseSlotAvailable(@NotNull Item item) {
        bag.setSlotAvailable(bag.getSlotAvailable() - item.getSlotRequired());
    }
}
