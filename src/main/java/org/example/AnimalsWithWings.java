package org.example;

import java.time.LocalDate;
import java.util.Objects;

public abstract class AnimalsWithWings extends Animal{

    private float wingspan;

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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnimalsWithWings that)) return false;
        if (!super.equals(o)) return false;
        return Float.compare(getWingspan(), that.getWingspan()) == 0;
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getWingspan());
    }
}
