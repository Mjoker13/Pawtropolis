package org.example;

import java.time.LocalDate;


public abstract class  AnimalsWithTail extends Animal  {
    private float tailLength;

    protected AnimalsWithTail() {
    }

    protected AnimalsWithTail(String name, String favoriteFood, int age, LocalDate entryDate, float weight, float height, float tailLength) {
        super(name, favoriteFood, age, entryDate, weight, height);
        this.tailLength = tailLength;
    }
    public float getTailLength() {
        return tailLength;
    }
    public void setTailLength(float tailLength) {
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
