package org.example;

import java.time.LocalDate;

public class Eagle extends AnimalsWithWings {
    public Eagle(String name, String favoriteFood, int age, LocalDate entryDate, double weight, int height, int wingspan) {
        super(name, favoriteFood, age, entryDate, weight, height, wingspan);
    }
    @Override
    public String toString() {
        return "Eagle{" +
                "name='" + super.getName() + '\'' +
                ", favoriteFood='" + super.getFavoriteFood() + '\'' +
                ", age=" + super.getAge() +
                ", entryDate=" + super.getEntryDate() +
                ", weight=" + super.getWeight() +
                ", height=" + super.getHeight() +
                ", wingspan=" + super.getWingspan() +
                '}' + '\n';
    }
}
