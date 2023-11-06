package com.example.pawtropolis.DTO.animal;

import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public abstract class AnimalsWithWings extends Animal {

    private float wingspan;

    protected AnimalsWithWings(String name, String favoriteFood, int age, LocalDate entryDate, float weight, float height, float wingspan) {
        super(name, favoriteFood, age, entryDate, weight, height);
        this.wingspan = wingspan;
    }
}
