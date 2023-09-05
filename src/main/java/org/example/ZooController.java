package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ZooController{
    ZooCreator zooCreator = new ZooCreator();
    private Map<Class<? extends Animal>, List<Animal>> animals;
    public ZooController() {
        this.animals = (Map<Class<? extends Animal>, List<Animal>>) zooCreator.getAnimals();
    }
    // getter & setter
    public Map<Class<? extends Animal>, List<Animal>> getAnimals() {
        return animals;
    }
    public void setAnimals(Map<Class<? extends Animal>, List<Animal>> animals) {
        this.animals = animals;
    }

    // management methods generic
    public <T extends Animal> T getHighestAnimalByClass(Class<T> animalClass){
        if(animals.isEmpty()){
            return null;
        }
        return animals.values().stream()
                .filter(animalClass::isInstance)
                .map(animalClass::cast)
                .max(Comparator.comparing(Animal::getHeight))
                .orElse(null);
    }
    public <T extends Animal> T getShortestAnimalByClass(Class<T> animalClass){
        if(animals.isEmpty()){
            return null;
        }
        return animals.values().stream()
                .filter(animalClass::isInstance)
                .map(animalClass::cast)
                .min(Comparator.comparing(Animal::getHeight))
                .orElse(null);
    }
    public <T extends Animal> T getHeaviestAnimalByClass(Class<T> animalClass){
        if(animals.isEmpty()){
            return null;
        }
        return animals.values().stream()
                .filter(animalClass::isInstance)
                .map(animalClass::cast)
                .max(Comparator.comparing(Animal::getWeight))
                .orElse(null);
    }
    public <T extends Animal> T getLightestAnimalByClass(Class<T> animalClass){
        if(animals.isEmpty()){
            return null;
        }
        return animals.values().stream()
                .filter(animalClass::isInstance)
                .map(animalClass::cast)
                .min(Comparator.comparing(Animal::getHeight))
                .orElse(null);
    }

    /*public AnimalsWithTail getLongestTail() {
        if (animals.isEmpty()) {
            return null;
        }

        return (AnimalsWithTail) animals.values().stream()
                .filter(a -> a.equals(AnimalsWithTail.class))
                .max(Comparator.comparing())
                .orElse(null);
    }
    public AnimalsWithWings getWidestWingspan() {
        if (this.animals.isEmpty()) {
            return  null;
        }*/
}