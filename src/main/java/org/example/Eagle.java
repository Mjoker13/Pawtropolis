package org.example;

import java.time.LocalDate;
import java.util.List;

public class Eagle extends Animal {
    private int wingspan;
    public Eagle(String name, String favoriteFood, int age, LocalDate entryDate, double weight, int height, int wingspan) {
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
        return "Eagle{" +
                "name='" + super.getName() + '\'' +
                ", favoriteFood='" + super.getFavoriteFood() + '\'' +
                ", age=" + super.getAge() +
                ", entryDate=" + super.getEntryDate() +
                ", weight=" + super.getWeight() +
                ", height=" + super.getHeight() +
                ", wingspan=" + wingspan +
                '}';
    }
}
