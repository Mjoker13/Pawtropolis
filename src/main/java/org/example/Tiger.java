package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tiger extends AnimalsWithTail {
    public Tiger() {
    }
    public Tiger(String name, String favoriteFood, int age, LocalDate entryDate, float weight, float height, float tailLength) {
        super(name, favoriteFood, age, entryDate, weight, height, tailLength);
    }
    @Override
    public String toString() {
        return "Tiger{" +
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
        List<Tiger> tigers = new ArrayList<>();
        for (Animal a : animals) {
            if (a instanceof Tiger) {
                tigers.add((Tiger) a);
            }
        }
        if (tigers.isEmpty()) {
            return null;
        }
            Tiger tigerTallest = tigers.get(0);
            for (Tiger currentAnimal : tigers) {
                if (tigerTallest.getHeight() < currentAnimal.getHeight()) {
                    tigerTallest = currentAnimal;
                }
            }
            return tigerTallest;
    }

    @Override
    Animal getTheShortestAnimal(List<Animal> animals) {
        List<Tiger> tigers = new ArrayList<>();
        for (Animal a : animals) {
            if (a instanceof Tiger) {
                tigers.add((Tiger) a);
            }
        }
        if (tigers.isEmpty()) {
            return null;
        }
        Tiger tigerShortest = tigers.get(0);
        for (Tiger currentAnimal : tigers) {
            if (tigerShortest.getHeight() > currentAnimal.getHeight()) {
                tigerShortest = currentAnimal;
            }
        }
        return tigerShortest;
    }

    @Override
    Animal getTheHeaviestAnimal(List<Animal> animals) {
        List<Tiger> tigers = new ArrayList<>();
        for (Animal a : animals) {
            if (a instanceof Tiger) {
                tigers.add((Tiger) a);
            }
        }
        if (tigers.isEmpty()) {
            return null;
        }
        Tiger tigerHeaviest = tigers.get(0);
        for (Tiger currentAnimal : tigers) {
            if (tigerHeaviest.getWeight() < currentAnimal.getWeight()) {
                tigerHeaviest = currentAnimal;
            }
        }
        return tigerHeaviest;
    }

    @Override
    Animal getTheLightestAnimal(List<Animal> animals) {
        List<Tiger> tigers = new ArrayList<>();
        for (Animal a : animals) {
            if (a instanceof Tiger) {
                tigers.add((Tiger) a);
            }
        }
        if (tigers.isEmpty()) {
            return null;
        }
        Tiger tigerLightest = tigers.get(0);
        for (Tiger currentAnimal : tigers) {
            if (tigerLightest.getWeight() > currentAnimal.getWeight()) {
                tigerLightest = currentAnimal;
            }
        }
        return tigerLightest;
    }

}
