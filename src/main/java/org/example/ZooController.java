package org.example;

import java.util.List;

public class ZooController{
    ZooCreator zooCreator = new ZooCreator();
    private List<Animal> animals;
    public ZooController() {
        this.animals = zooCreator.getAnimals();
    }
    // getter & setter
    public List<Animal> getAnimals() {
        return animals;
    }
    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    // management methods generic
    public <T extends Animal> T getHighestAnimalByClass(Class<T> animalClass){
        if(animals.isEmpty()){
            return null;
        }
        T hightest = null;
        for (Animal currentAnimal: this.animals) {
            if(animalClass.isInstance(currentAnimal) && (hightest == null || hightest.getHeight() < currentAnimal.getHeight())){
                    hightest = (T) currentAnimal;
            }
        }return  hightest;
    }
    public <T extends Animal> T getShortestAnimalByClass(Class<T> animalClass){
        if(animals.isEmpty()){
            return null;
        }
        T shortest = null;
        for (Animal currentAnimal: this.animals) {
            if(animalClass.isInstance(currentAnimal) && (shortest == null || shortest.getHeight() > currentAnimal.getHeight())){
                shortest = (T) currentAnimal;
            }
        }return  shortest;
    }
    public <T extends Animal> T getHeaviestAnimalByClass(Class<T> animalClass){
        if(animals.isEmpty()){
            return null;
        }
        T heaviest = null;
        for (Animal currentAnimal: this.animals) {
            if(animalClass.isInstance(currentAnimal) && (heaviest == null || heaviest.getWeight() < currentAnimal.getWeight())){
                heaviest = (T) currentAnimal;
            }
        }return  heaviest;
    }
    public <T extends Animal> T getLightestAnimalByClass(Class<T> animalClass){
        if(animals.isEmpty()){
            return null;
        }
        T lightest = null;
        for (Animal currentAnimal: this.animals) {
            if(animalClass.isInstance(currentAnimal) && (lightest == null || lightest.getWeight() > currentAnimal.getWeight())){
                lightest = (T) currentAnimal;
            }
        }return  lightest;
    }

    public AnimalsWithTail getLongestTail() {
        if (animals.isEmpty()) {
            return null;
        }
        AnimalsWithTail animalWithLongestTail = null;
        for (Animal currentAnimal : this.animals) {
                if (currentAnimal instanceof AnimalsWithTail && (animalWithLongestTail == null || animalWithLongestTail.getTailLength() < ((AnimalsWithTail) currentAnimal).getTailLength())) {
                    animalWithLongestTail = (AnimalsWithTail) currentAnimal;
                }
        }
        return animalWithLongestTail;
    }
    public AnimalsWithWings getWidestWingspan() {
        if (this.animals.isEmpty()) {
            return  null;
        }
        AnimalsWithWings animalgreaterWingspan = null;
        for (Animal currentAnimal : this.animals) {
            if (currentAnimal instanceof AnimalsWithWings && (animalgreaterWingspan== null || animalgreaterWingspan.getWingspan() < ((AnimalsWithWings) currentAnimal).getWingspan())) {
                animalgreaterWingspan = (AnimalsWithWings) currentAnimal;
            }
        }
            return animalgreaterWingspan;
    }
}