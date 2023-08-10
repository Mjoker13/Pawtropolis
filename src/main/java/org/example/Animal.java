package org.example;

import java.time.LocalDate;
import java.util.List;

public abstract class Animal {
    private String name;
    private String favoriteFood;
    private int age;
    private LocalDate entryDate;
    private float weight;
    private float height;
    protected Animal() {
    }
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
        return "Animal{" +
                "name='" + name + '\'' +
                ", favoriteFood='" + favoriteFood + '\'' +
                ", age=" + age +
                ", entryDate=" + entryDate +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }

    abstract Animal getHighestAnimal(List<Animal> animals);
    abstract Animal getTheShortestAnimal(List<Animal>animals);
    abstract Animal getTheHeaviestAnimal(List<Animal>animals);
    abstract Animal getTheLightestAnimal(List<Animal>animals);
}
