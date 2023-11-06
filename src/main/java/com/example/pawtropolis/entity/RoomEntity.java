package com.example.pawtropolis.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.*;
@Getter
@Setter
@Entity
@Table(name = "room")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String name;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<ItemEntity> items;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<AnimalEntity> animals;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<RoomEntity> adjacentRooms;
}
