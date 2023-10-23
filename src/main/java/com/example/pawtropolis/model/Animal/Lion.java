package com.example.pawtropolis.model.Animal;

import java.time.LocalDate;

public class Lion extends AnimalsWithTail {

    public Lion(String name, String favoriteFood, int age, LocalDate entryDate, float weight, float height, float tailLength) {
        super(name, favoriteFood, age, entryDate, weight, height, tailLength);
    }

    @Override
    public String toString() {
        return "\n-Lion{" +
                "name='" + super.getName() + '\'' +
                ", favoriteFood='" + super.getFavoriteFood() + '\'' +
                ", age=" + super.getAge() +
                ", entryDate=" + super.getEntryDate() +
                ", weight=" + super.getWeight() +
                ", height=" + super.getHeight() +
                ", tailLength=" + super.getTailLength() +
                '}';
    }
}
