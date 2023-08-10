package org.example;

import java.time.LocalDate;

public abstract class AnimalsWithWings extends Animal{

    private float wingspan;

    protected AnimalsWithWings() {
    }

    protected AnimalsWithWings(String name, String favoriteFood, int age, LocalDate entryDate, float weight, float height, float wingspan) {
        super(name, favoriteFood, age, entryDate, weight, height);
        this.wingspan = wingspan;
    }
    public float getWingspan() {
        return wingspan;
    }
    public void setWingspan(float wingspan) {
        this.wingspan = wingspan;
    }

    @Override
    public String toString() {
        return "AnimalsWithWings{" +
                "name='" + super.getName() + '\'' +
                ", favoriteFood='" + super.getFavoriteFood() + '\'' +
                ", age=" + super.getAge() +
                ", entryDate=" + super.getEntryDate() +
                ", weight=" + super.getWeight() +
                ", height=" + super.getHeight() +
                "wingspan=" + wingspan +
                '}';
    }
}
