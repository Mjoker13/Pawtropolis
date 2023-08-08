package org.example;

import java.time.LocalDate;

public abstract class AnimalsWithWings extends Animal{
    private int wingspan;
    public AnimalsWithWings(String name, String favoriteFood, int age, LocalDate entryDate, double weight, int height, int wingspan) {
        super(name, favoriteFood, age, entryDate, weight, height);
        this.wingspan = wingspan;
    }
    public int getWingspan() {
        return wingspan;
    }
    public void setWingspan(int wingspan) {
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
