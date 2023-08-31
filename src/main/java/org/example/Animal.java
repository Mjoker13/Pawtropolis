package org.example;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Animal {
    private String name;
    private String favoriteFood;
    private int age;
    private LocalDate entryDate;
    private float weight;
    private float height;

    protected Animal(String name, String favoriteFood, int age, LocalDate entryDate, float weight, float height) {
        this.name = name;
        this.favoriteFood = favoriteFood;
        this.age = age;
        this.entryDate = entryDate;
        this.weight = weight;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
    @Override // è solo un controllo fatto dal compilatore a tempo statico, si può anche omettere
    public String toString() {
        return
                getClass().getSimpleName()+ " :" +
                "Animal{" +
                "name='" + name + '\'' +
                ", favoriteFood='" + favoriteFood + '\'' +
                ", age=" + age +
                ", entryDate=" + entryDate +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal animal)) return false;
        return getAge() == animal.getAge()
                && Float.compare(getWeight(), animal.getWeight()) == 0
                && Float.compare(getHeight(), animal.getHeight()) == 0
                && Objects.equals(getName(), animal.getName())
                && Objects.equals(getFavoriteFood(), animal.getFavoriteFood())
                && Objects.equals(getEntryDate(), animal.getEntryDate());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getFavoriteFood(), getAge(), getEntryDate(), getWeight(), getHeight());
    }

}
