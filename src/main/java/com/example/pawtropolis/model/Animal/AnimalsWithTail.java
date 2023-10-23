package com.example.pawtropolis.model.Animal;

import lombok.*;

import java.time.LocalDate;

@Data
public abstract class AnimalsWithTail extends Animal {
    private float tailLength;

    protected AnimalsWithTail(String name, String favoriteFood, int age, LocalDate entryDate, float weight, float height, float tailLength) {
        super(name, favoriteFood, age, entryDate, weight, height);
        this.tailLength = tailLength;
    }
}



