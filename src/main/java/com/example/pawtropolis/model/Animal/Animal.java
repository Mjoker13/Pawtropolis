package com.example.pawtropolis.model.Animal;

import com.example.pawtropolis.model.Game.Room;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Past;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public abstract class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String favoriteFood;
    @Max(100)
    @Min(0)
    private int age;
    @Past
    private LocalDate entryDate;
    private float weight;
    private float height;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;

    public Animal(@NotNull String name, @NotNull String favoriteFood, int age, @NotNull LocalDate entryDate, float weight, float height) {
        this.name = name;
        this.favoriteFood = favoriteFood;
        this.age = age;
        this.entryDate = entryDate;
        this.weight = weight;
        this.height = height;
    }
}
