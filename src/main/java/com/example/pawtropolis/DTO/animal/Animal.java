package com.example.pawtropolis.DTO.animal;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@NoArgsConstructor
@Getter
@Component
public abstract class Animal {
    private String name;
    private String favoriteFood;
    private int age;
    private LocalDate entryDate;
    private float weight;
    private float height;

    public Animal(@NotNull String name, @NotNull String favoriteFood, int age, @NotNull LocalDate entryDate, float weight, float height) {
        this.name = name;
        this.favoriteFood = favoriteFood;
        this.age = age;
        this.entryDate = entryDate;
        this.weight = weight;
        this.height = height;
    }
}
