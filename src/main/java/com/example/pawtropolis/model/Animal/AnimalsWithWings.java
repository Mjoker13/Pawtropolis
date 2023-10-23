package com.example.pawtropolis.model.Animal;

import lombok.*;

import java.time.LocalDate;

@Data
public abstract class AnimalsWithWings extends Animal {

    private float wingspan;

    protected AnimalsWithWings(String name, String favoriteFood, int age, LocalDate entryDate, float weight, float height, float wingspan) {
        super(name, favoriteFood, age, entryDate, weight, height);
        this.wingspan = wingspan;
    }
}
