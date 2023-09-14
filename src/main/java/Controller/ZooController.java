package Controller;

import Domain.AnimalDomain.Animal;
import Domain.AnimalDomain.AnimalsWithTail;
import Domain.AnimalDomain.AnimalsWithWings;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
public class ZooController {

    private Map<Class<? extends Animal>, List<Animal>> animals;

    public ZooController() {
        this.animals = ZooCreator.createAnimals();
    }

    // management methods generic
    public  <T extends Animal> List<T> getAllAnimalsForSpecies(Class<T> animalClass){
        if (animals.isEmpty()) {
            return Collections.emptyList();
        }
        return animals.entrySet().stream()
                .filter(entry -> animalClass.isAssignableFrom(entry.getKey()))
                .map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                .map(animalClass::cast)
                .collect(Collectors.toList());
    }
    public <T extends Animal> T getHighestAnimalByClass(Class<T> animalClass) {
        return getAllAnimalsForSpecies(animalClass).stream()
                .max(Comparator.comparing(Animal::getHeight))
                .orElse(null);
    }
    public <T extends Animal> T getShortestAnimalByClass(Class<T> animalClass) {
        return getAllAnimalsForSpecies(animalClass).stream()
                .min(Comparator.comparing(Animal::getHeight))
                .orElse(null);
    }
    public <T extends Animal> T getHeaviestAnimalByClass(Class<T> animalClass) {
        return getAllAnimalsForSpecies(animalClass).stream()
                .max(Comparator.comparing(Animal::getWeight))
                .orElse(null);
    }
    public <T extends Animal> T getLightestAnimalByClass(Class<T> animalClass) {
        return getAllAnimalsForSpecies(animalClass).stream()
                .min(Comparator.comparing(Animal::getWeight))
                .orElse(null);
    }
    public AnimalsWithTail getLongestTail() {
        return Objects.requireNonNull(getAllAnimalsForSpecies(AnimalsWithTail.class)).stream()
                .max(Comparator.comparing(AnimalsWithTail::getTailLength))
                .orElse(null);
    }
    public AnimalsWithWings getWidestWingspan() {
        return Objects.requireNonNull(getAllAnimalsForSpecies(AnimalsWithWings.class)).stream()
                .max(Comparator.comparing(AnimalsWithWings::getWingspan))
                .orElse(null);
    }
}