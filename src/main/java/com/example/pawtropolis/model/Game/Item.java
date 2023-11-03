package com.example.pawtropolis.model.Game;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Setter
@Getter
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private final String name;
    @NotNull
    @Size(max = 100, min = 3)
    private final String description;
    @Min(0)
    @Max(20)
    private final int slotRequired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_bag_id", referencedColumnName = "id")
    private PlayerBag playerBag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;


    public Item(@NotNull String name, @NotNull String description, int slotRequired) {
        this.name = name;
        this.description = description;
        if (slotRequired < 20) {
            this.slotRequired = slotRequired;
        } else throw new RuntimeException("The slot required cannot overcome 20.");
    }
}
