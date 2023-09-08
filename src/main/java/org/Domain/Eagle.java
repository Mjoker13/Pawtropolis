package org.Domain;

import java.time.LocalDate;

public class Eagle extends AnimalsWithWings {
    public Eagle(String name, String favoriteFood, int age, LocalDate entryDate, float weight, float height, float wingspan) {
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
