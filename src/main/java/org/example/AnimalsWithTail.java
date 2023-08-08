package org.example;

import java.time.LocalDate;

public abstract class  AnimalsWithTail extends Animal  {
    private int tailLength;
    public AnimalsWithTail(String name, String favoriteFood, int age, LocalDate entryDate, double weight, int height, int tailLength) {
        super(name, favoriteFood, age, entryDate, weight, height);
        this.tailLength = tailLength;
    }
    public int getTailLength() {
        return tailLength;
    }
    public void setTailLength(int tailLength) {
        this.tailLength = tailLength;
    }

    @Override
    public String toString() {
        return "AnimalsWithTail{" +
                "name='" + super.getName() + '\'' +
                ", favoriteFood='" + super.getFavoriteFood() + '\'' +
                ", age=" + super.getAge() +
                ", entryDate=" + super.getEntryDate() +
                ", weight=" + super.getWeight() +
                ", height=" + super.getHeight() +
                "tailLength=" + tailLength +
                '}';
    }
}
