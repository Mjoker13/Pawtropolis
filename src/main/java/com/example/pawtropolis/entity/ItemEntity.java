package com.example.pawtropolis.entity;

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
@Table(name = "item")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String name;
    @NotNull
    @Size(max = 100, min = 3)
    private String description;
    @Min(0)
    @Max(20)
    private int slotRequired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_bag_id", referencedColumnName = "id")
    private PlayerBagEntity player_bag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room", referencedColumnName = "id")
    private RoomEntity room;
}

