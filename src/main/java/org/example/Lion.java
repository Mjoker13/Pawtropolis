package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Lion extends Animal {
    private int tailLength;
    public Lion(String name, String favoriteFood, int age, LocalDate entryDate, double weight, int height, int tailLength) {
        super(name, favoriteFood, age, entryDate, weight, height);
        this.tailLength = tailLength;
    }
    public int getTailLength() {
        return tailLength;
    }
    public void setTailLenght(int tailLength) {
        this.tailLength = tailLength;
    }
    @Override
    public String toString() {
        return "Lion{" +
                "name='" + super.getName() + '\'' +
                ", favoriteFood='" + super.getFavoriteFood() + '\'' +
                ", age=" + super.getAge() +
                ", entryDate=" + super.getEntryDate() +
                ", weight=" + super.getWeight() +
                ", height=" + super.getHeight() +
                ", tailLength=" + tailLength +
                '}';
    }

}
