package org.example;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ZooController {
    private List<Animal> animals = new ArrayList<>();

    public ZooController() {
        this.animals = createAnimals();
    }

    public ZooController(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Animal> createAnimals() {

        LocalDate dateSherkan = LocalDate.of(2012, 8, 20);
        LocalDate dateTigro = LocalDate.of(2018, 12, 02);
        LocalDate dateOscar = LocalDate.of(2005, 5, 12);
        Tiger oscar = new Tiger("Oscar", "rubbit", 23, dateOscar, 82.5F, 95, 25);
        Tiger sherkan = new Tiger("Sherkan", "man", 13, dateSherkan, 78.5F, 96, 22);
        Tiger tigro = new Tiger("Tigro", "honey", 8, dateTigro, 86.5F, 95, 30);
        Tiger iris = new Tiger("Iris", "gazelles", 8, dateTigro, 82.5F, 89, 45);

        LocalDate dateSimba = LocalDate.of(1994, 8, 03);
        LocalDate dateAlex = LocalDate.of(1982, 10, 05);
        Lion simba = new Lion("Simba", "insect", 12, dateSimba, 85, 120, 35);
        Lion alex = new Lion("Alex", "gazelles", 18, dateAlex, 87, 115.0F, 28);
        Lion nala = new Lion("Nala", "gazelles", 15, dateAlex, 82, 108, 49);

        LocalDate dateOlimpia = LocalDate.of(2008, 9, 13);
        LocalDate dateBianca = LocalDate.of(2000, 3, 22);
        Eagle olimpia = new Eagle("Olimpia", "fish", 22, dateOlimpia, 20, 70, 90);
        Eagle bianca = new Eagle("Bianca", "rubbit", 18, dateBianca, 26, 68, 116);
        Eagle gigi = new Eagle("Gigi", "rubbit", 15, dateBianca, 25, 62, 98.05F);
        Eagle teresa = new Eagle("Teresa", "rubbit", 15, dateOlimpia, 30, 82, 108.9F);

        animals.add(oscar);
        animals.add(sherkan);
        animals.add(tigro);
        animals.add(iris);
        animals.add(simba);
        animals.add(alex);
        animals.add(nala);
        animals.add(olimpia);
        animals.add(bianca);
        animals.add(gigi);
        animals.add(teresa);
        return animals;
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
    public AnimalsWithTail getLongestTail() {
        List<AnimalsWithTail> animalsWithTail = new ArrayList<>();
        for (Animal a : this.animals) {
            if (a instanceof AnimalsWithTail) {
                animalsWithTail.add((AnimalsWithTail) a);
            }
        }
        if (!animalsWithTail.isEmpty()) {
            AnimalsWithTail animalWithLongestTail = animalsWithTail.get(0);
            for (AnimalsWithTail currentAnimal : animalsWithTail) {
                if (animalWithLongestTail.getTailLength() < currentAnimal.getTailLength()) {
                    animalWithLongestTail = currentAnimal;
                }
            }
            return animalWithLongestTail;
        } else return null;
    }

    public AnimalsWithWings getGreaterWingspan() {
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