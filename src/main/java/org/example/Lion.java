package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Lion extends AnimalsWithTail {
    public Lion() {
    }

    public Lion(String name, String favoriteFood, int age, LocalDate entryDate, float weight, float height, float tailLength) {
        super(name, favoriteFood, age, entryDate, weight, height, tailLength);
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
                ", tailLength=" + super.getTailLength() +
                '}'+ '\n';
    }
    @Override
    Animal getHighestAnimal(List<Animal> animals) {
        List<Lion> lions = new ArrayList<>();
        for (Animal a : animals) {
            if (a instanceof Lion) {
                lions.add((Lion) a);
            }
        }
        if (lions.isEmpty()) {
            return null;
        }
            Lion lionLongest = lions.get(0);
            for (Lion currentAnimal : lions) {
                if (lionLongest.getHeight() < currentAnimal.getHeight()) {
                    lionLongest = currentAnimal;
                }
            }
            return lionLongest;
    }
    @Override
    Animal getTheShortestAnimal(List<Animal> animals) {
        List<Lion> lions = new ArrayList<>();
        for (Animal a : animals) {
            if (a instanceof Lion) {
                lions.add((Lion) a);
            }
        }
        if (lions.isEmpty()) {
            return null;
        }
        Lion lionShortest = lions.get(0);
        for (Lion currentAnimal : lions) {
            if (lionShortest.getHeight() > currentAnimal.getHeight()) {
                lionShortest = currentAnimal;
            }
        }
        return lionShortest;
    }
    @Override
    Animal getTheHeaviestAnimal(List<Animal> animals) {
        List<Lion> lions = new ArrayList<>();
        for (Animal a : animals) {
            if (a instanceof Lion) {
                lions.add((Lion) a);
            }
        }
        if (lions.isEmpty()) {
            return null;
        }
        Lion lionHeaviest = lions.get(0);
        for (Lion currentAnimal : lions) {
            if (lionHeaviest.getWeight() < currentAnimal.getWeight()) {
                lionHeaviest = currentAnimal;
            }
        }
        return lionHeaviest;
    }
    @Override
    Animal getTheLightestAnimal(List<Animal> animals) {
        List<Lion> lions = new ArrayList<>();
        for (Animal a : animals) {
            if (a instanceof Lion) {
                lions.add((Lion) a);
            }
        }
        if (lions.isEmpty()) {
            return null;
        }
        Lion lionLightest = lions.get(0);
        for (Lion currentAnimal : lions) {
            if (lionLightest.getWeight() > currentAnimal.getWeight()) {
                lionLightest = currentAnimal;
            }
        }
        return lionLightest;
    }
}
