package com.example.pawtropolis.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@Entity
@Table(name = "adjacent_room")
public class AdjacentRoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String direction;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id",referencedColumnName = "id")
    private RoomEntity room;
}
