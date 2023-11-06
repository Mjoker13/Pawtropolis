package com.example.pawtropolis.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
@Table(name ="player_bag")
public class PlayerBagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany(mappedBy = "player_bag", cascade = CascadeType.ALL)
    private List<ItemEntity> items;
    @Max(20)
    @Min(0)
    private int maxCapacity = 20;
    @OneToOne(mappedBy = "player_bag")
    private PlayerEntity player;
}
