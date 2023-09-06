package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZooCreator {
    private Map<Class<? extends Animal>, List<Animal>> animals = new HashMap<>();

    public ZooCreator() {
        this.animals = createAnimals();
    }

    public Map<Class<? extends Animal>, List<Animal>> getAnimals() {
        return animals;
    }

    public void setAnimals(Map<Class<? extends Animal>, List<Animal>> animals) {
        this.animals = animals;
    }

    public Map<Class<? extends Animal>, List<Animal>> createAnimals() {

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

        List<Animal> animalList = new ArrayList<>();

        animalList.add(oscar);
        animalList.add(sherkan);
        animalList.add(tigro);
        animalList.add(iris);
        animalList.add(simba);
        animalList.add(alex);
        animalList.add(nala);
        animalList.add(olimpia);
        animalList.add(bianca);
        animalList.add(gigi);
        animalList.add(teresa);

        animals.put(animalList.listIterator().next().getClass(),animalList);

        return animals;
    }
}
