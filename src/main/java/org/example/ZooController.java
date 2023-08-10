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
        List<Tiger> tigers = new ArrayList<>();
        for (Animal a : this.animals) {
            if (a instanceof Tiger) {
                tigers.add((Tiger) a);
            }
        }
        if (!tigers.isEmpty()) {
            Tiger tigerTallest = tigers.get(0);
            for (Tiger currentAnimal : tigers) {
                if (tigerTallest.getHeight() < currentAnimal.getHeight()) {
                    tigerTallest = currentAnimal;
                }
            }
            return tigerTallest;
        } else return null;
    }

    public Tiger getTheShortestTiger() {
        List<Tiger> tigers = new ArrayList<>();
        for (Animal a : this.animals) {
            if (a instanceof Tiger) {
                tigers.add((Tiger) a);
            }
        }
        if (!tigers.isEmpty()) {
            Tiger tigerShortest = tigers.get(0);
            for (Tiger currentAnimal : tigers) {
                if (tigerShortest.getHeight() > currentAnimal.getHeight()) {
                    tigerShortest = currentAnimal;
                }
            }
            return tigerShortest;
        } else return null;
    }

    public Tiger getTheHeaviestTiger() {
        List<Tiger> tigers = new ArrayList<>();
        for (Animal a : this.animals) {
            if (a instanceof Tiger) {
                tigers.add((Tiger) a);
            }
        }
        if (!tigers.isEmpty()) {
            Tiger tigerHeaviest = tigers.get(0);
            for (Tiger currentAnimal : tigers) {
                if (tigerHeaviest.getWeight() < currentAnimal.getWeight()) {
                    tigerHeaviest = currentAnimal;
                }
            }
            return tigerHeaviest;
        } else return null;
    }

    public Tiger getTheLightestTiger() {
        List<Tiger> tigers = new ArrayList<>();
        for (Animal a : this.animals) {
            if (a instanceof Tiger) {
                tigers.add((Tiger) a);
            }
        }
        if (!tigers.isEmpty()) {
            Tiger tigerLightest = tigers.get(0);
            for (Tiger currentAnimal : tigers) {
                if (tigerLightest.getWeight() > currentAnimal.getWeight()) {
                    tigerLightest = currentAnimal;
                }
            }
            return tigerLightest;
        } else return null;
    }

    // Lion management block
    public Lion getTheHighestLion() {
        List<Lion> lions = new ArrayList<>();
        for (Animal a : this.animals) {
            if (a instanceof Lion) {
                lions.add((Lion) a);
            }
        }
        if (!lions.isEmpty()) {
            Lion lionLightest = lions.get(0);
            for (Lion currentAnimal : lions) {
                if (lionLightest.getHeight() < currentAnimal.getHeight()) {
                    lionLightest = currentAnimal;
                }
            }
            return lionLightest;
        } else return null;
    }

    public Lion getTheShortestLion() {
        List<Lion> lions = new ArrayList<>();
        for (Animal a : this.animals) {
            if (a instanceof Lion) {
                lions.add((Lion) a);
            }
        }
        if (!lions.isEmpty()) {
            Lion lionShortest = lions.get(0);
            for (Lion currentAnimal : lions) {
                if (lionShortest.getHeight() > currentAnimal.getHeight()) {
                    lionShortest = currentAnimal;
                }
            }
            return lionShortest;
        } else return null;
    }

    public Lion getTheHeaviestLion() {
        List<Lion> lions = new ArrayList<>();
        for (Animal a : this.animals) {
            if (a instanceof Lion) {
                lions.add((Lion) a);
            }
        }
        if (!lions.isEmpty()) {
            Lion lionHeaviest = lions.get(0);
            for (Lion currentAnimal : lions) {
                if (lionHeaviest.getWeight() < currentAnimal.getWeight()) {
                    lionHeaviest = currentAnimal;
                }
            }
            return lionHeaviest;
        } else return null;
    }

    public Lion getTheLightestLion() {
        List<Lion> lions = new ArrayList<>();
        for (Animal a : this.animals) {
            if (a instanceof Lion) {
                lions.add((Lion) a);
            }
        }
        if (!lions.isEmpty()) {
            Lion lionLightest = lions.get(0);
            for (Lion currentAnimal : lions) {
                if (lionLightest.getWeight() > currentAnimal.getWeight()) {
                    lionLightest = currentAnimal;
                }
            }
            return lionLightest;
        } else return null;
    }

    // Eagle management block
    public Eagle getTheHighestEagle() {
        List<Eagle> eagles = new ArrayList<>();
        for (Animal a : this.animals) {
            if (a instanceof Eagle) {
                eagles.add((Eagle) a);
            }
        }
        if (!eagles.isEmpty()) {
            Eagle eagleHighest = eagles.get(0);
            for (Eagle currentAnimal : eagles) {
                if (eagleHighest.getHeight() < currentAnimal.getHeight()) {
                    eagleHighest = currentAnimal;
                }
            }
            return eagleHighest;
        } else return null;
    }

    public Eagle getTheShortestEagle() {
        List<Eagle> eagles = new ArrayList<>();
        for (Animal a : this.animals) {
            if (a instanceof Eagle) {
                eagles.add((Eagle) a);
            }
        }
        if (!eagles.isEmpty()) {
            Eagle eagleShortest = eagles.get(0);
            for (Eagle currentAnimal : eagles) {
                if (eagleShortest.getHeight() > currentAnimal.getHeight()) {
                    eagleShortest = currentAnimal;
                }
            }
            return eagleShortest;
        } else return null;
    }

    public Eagle getTheHeaviestEagle() {
        List<Eagle> eagles = new ArrayList<>();
        for (Animal a : this.animals) {
            if (a instanceof Eagle) {
                eagles.add((Eagle) a);
            }
        }
        if (!eagles.isEmpty()) {
            Eagle eagleHeaviest = eagles.get(0);
            for (Eagle currentAnimal : eagles) {
                if (eagleHeaviest.getWeight() < currentAnimal.getWeight()) {
                    eagleHeaviest = currentAnimal;
                }
            }
            return eagleHeaviest;
        } else return null;
    }

    public Eagle getTheLightestEagle() {
        List<Eagle> eagles = new ArrayList<>();
        for (Animal a : this.animals) {
            if (a instanceof Eagle) {
                eagles.add((Eagle) a);
            }
        }
        if (!eagles.isEmpty()) {
            Eagle eagleLightest = eagles.get(0);
            for (Eagle currentAnimal : eagles) {
                if (eagleLightest.getWeight() > currentAnimal.getWeight()) {
                    eagleLightest = currentAnimal;
                }
            }
            return eagleLightest;
        } else return null;
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