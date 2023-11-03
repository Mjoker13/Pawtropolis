package com.example.pawtropolis.model.Game;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

@Getter
@Setter
@Log4j2
@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String name;
    @Min(1)
    @Max(100)
    private int lifePoints;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="player_bag_id",referencedColumnName = "id")
    private PlayerBag playerBag;

    @Autowired
    public Player(PlayerBag playerBag){
        this.playerBag = playerBag;
    }

    public void showsBagInformation() {
        log.info("In bag: " + playerBag.getItems().stream().filter(Objects::nonNull).map(Item::getName).toList());
        log.info("Slot available:" + playerBag.getSlotAvailable());
    }
    public void addItemToBag(@NotNull Item item) {
        if (playerBag.getSlotAvailable() >= item.getSlotRequired()) {
            playerBag.getItems().add(item);
        } else {
            log.info("\n" +"Maximum capacity exceeded");
        }
    }
    public void dropItemFromBag(Item item) {
        playerBag.getItems().remove(item);
    }
    public Item getItemFromBag(String itemName) {
        return playerBag.getItems().stream()
                .filter(i -> i.getName().equalsIgnoreCase(itemName))
                .findFirst().orElse(null);
    }
}
