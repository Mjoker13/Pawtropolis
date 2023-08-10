package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Eagle extends AnimalsWithWings {
    public Eagle() {
    }

    public Eagle(String name, String favoriteFood, int age, LocalDate entryDate, float weight, float height, float wingspan) {
        super(name, favoriteFood, age, entryDate, weight, height, wingspan);
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
                ", wingspan=" + super.getWingspan() +
                '}' + '\n';
    }

    @Override
    Animal getHighestAnimal(List<Animal> animals) {
        List<Eagle> eagles = new ArrayList<>();
        for (Animal a : animals) {
            if (a instanceof Eagle) {
                eagles.add((Eagle) a);
            }
        }
        if (eagles.isEmpty()) {
            return null;
        }
        Eagle eagleHighest = eagles.get(0);
        for (Eagle currentAnimal : eagles) {
            if (eagleHighest.getHeight() < currentAnimal.getHeight()) {
                eagleHighest = currentAnimal;
            }
        }
        return eagleHighest;
    }
    @Override
    Animal getTheShortestAnimal(List<Animal> animals) {
        List<Eagle> eagles = new ArrayList<>();
        for (Animal a : animals) {
            if (a instanceof Eagle) {
                eagles.add((Eagle) a);
            }
        }
        if (eagles.isEmpty()) {
            return null;
        }
            Eagle eagleShortest = eagles.get(0);
            for (Eagle currentAnimal : eagles) {
                if (eagleShortest.getHeight() > currentAnimal.getHeight()) {
                    eagleShortest = currentAnimal;
                }
            }
            return eagleShortest;
          }
    @Override
    Animal getTheHeaviestAnimal(List<Animal> animals) {
        List<Eagle> eagles = new ArrayList<>();
        for (Animal a : animals) {
            if (a instanceof Eagle) {
                eagles.add((Eagle) a);
            }
        }
        if (eagles.isEmpty()) {
            return null;
        }
        Eagle eagleHeaviest = eagles.get(0);
        for (Eagle currentAnimal : eagles) {
            if (eagleHeaviest.getWeight() < currentAnimal.getWeight()) {
                eagleHeaviest = currentAnimal;
            }
        }
        return eagleHeaviest;
    }
    @Override
    Animal getTheLightestAnimal(List<Animal> animals) {
        List<Eagle> eagles = new ArrayList<>();
        for (Animal a : animals) {
            if (a instanceof Eagle) {
                eagles.add((Eagle) a);
            }
        }
        if (eagles.isEmpty()) {
            return null;
        }
        Eagle eagleLightest = eagles.get(0);
        for (Eagle currentAnimal : eagles) {
            if (eagleLightest.getWeight() > currentAnimal.getWeight()) {
                eagleLightest = currentAnimal;
            }
        }
        return eagleLightest;
    }
}
