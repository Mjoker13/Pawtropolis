package org.example;

import java.util.ArrayList;
import java.util.List;

public class ZooController{

    // creare i metodi generici per riutilizzarli sugli animali specifici
    ZooCreator zooCreator = new ZooCreator();
    private List<Animal> animals;
    public ZooController() {
        this.animals = zooCreator.getAnimals();
    }
    public ZooController(List<Animal> animals) {
        this.animals = animals;
    }

    // getter & setter
    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    // Tiger management block
    public Tiger getTheHighestTiger() {
        Tiger tiger= new Tiger();
        return (Tiger) tiger.getHighestAnimal(this.animals);
    }

    public Tiger getTheShortestTiger() {
        Tiger tiger= new Tiger();
        return (Tiger) tiger.getTheShortestAnimal(this.animals);
    }

    public Tiger getTheHeaviestTiger() {
        Tiger tiger= new Tiger();
        return (Tiger) tiger.getTheHeaviestAnimal(this.animals);
    }

    public Tiger getTheLightestTiger() {
        Tiger tiger= new Tiger();
        return (Tiger) tiger.getTheLightestAnimal(this.animals);
    }

    // Lion management block
    public Lion getTheHighestLion() {
        Lion lion= new Lion();
        return (Lion) lion.getHighestAnimal(this.animals);
    }

    public Lion getTheShortestLion() {
        Lion lion= new Lion();
        return (Lion) lion.getTheShortestAnimal(this.animals);
    }

    public Lion getTheHeaviestLion() {
        Lion lion= new Lion();
        return (Lion) lion.getTheHeaviestAnimal(this.animals);
    }

    public Lion getTheLightestLion() {
        Lion lion= new Lion();
        return (Lion) lion.getTheLightestAnimal(this.animals);
    }

    // Eagle management block
    public Eagle getTheHighestEagle() {
        Eagle eagle= new Eagle();
        return (Eagle) eagle.getHighestAnimal(this.animals);
    }

    public Eagle getTheShortestEagle() {
        Eagle eagle= new Eagle();
        return (Eagle) eagle.getTheShortestAnimal(this.animals);
    }

    public Eagle getTheHeaviestEagle() {
        Eagle eagle= new Eagle();
        return (Eagle) eagle.getTheHeaviestAnimal(this.animals);
    }

    public Eagle getTheLightestEagle() {
        Eagle eagle= new Eagle();
        return (Eagle) eagle.getTheLightestAnimal(this.animals);
    }

    // management other methods
    public AnimalsWithTail getLongestTail() { // unico metodo corretto
        List<AnimalsWithTail> animalsWithTail = new ArrayList<>();
        for (Animal a : this.animals) {
            if (a instanceof AnimalsWithTail) {
                animalsWithTail.add((AnimalsWithTail) a);
            }
        }
        if (animalsWithTail.isEmpty()) {
            return null;
        }
        AnimalsWithTail animalWithLongestTail = animalsWithTail.get(0);
        for (AnimalsWithTail currentAnimal : animalsWithTail) {
            if (animalWithLongestTail.getTailLength() < currentAnimal.getTailLength()) {
                animalWithLongestTail = currentAnimal;
            }
        }
        return animalWithLongestTail;
    }

    public AnimalsWithWings getWidestWingspan() {
        List<AnimalsWithWings> animalsWithWings = new ArrayList<>();
        for (Animal a : this.animals) {
            if (a instanceof AnimalsWithWings) {
                animalsWithWings.add((AnimalsWithWings) a);
            }
        }
        if (!animalsWithWings.isEmpty()) {
            AnimalsWithWings animalgreaterWingspan = animalsWithWings.get(0);
            for (AnimalsWithWings currentAnimal : animalsWithWings) {
                if (animalgreaterWingspan.getWingspan() < currentAnimal.getWingspan()) {
                    animalgreaterWingspan = currentAnimal;
                }
            }
            return animalgreaterWingspan;
        } else return null;
    }
}