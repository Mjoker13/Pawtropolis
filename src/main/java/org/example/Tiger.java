package org.example;

import java.time.LocalDate;

public class Tiger extends AnimalsWithTail {
    public Tiger(String name, String favoriteFood, int age, LocalDate entryDate, float weight, float height, float tailLength) {
        super(name, favoriteFood, age, entryDate, weight, height, tailLength);
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "name='" + super.getName() + '\'' +
                ", favoriteFood='" + super.getFavoriteFood() + '\'' +
                ", age=" + super.getAge() +
                ", entryDate=" + super.getEntryDate() +
                ", weight=" + super.getWeight() +
                ", height=" + super.getHeight() +
                ", tailLength=" + super.getTailLength() +
                '}'+ '\n';
    }

}
