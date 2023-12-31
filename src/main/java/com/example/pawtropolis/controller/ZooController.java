package com.example.pawtropolis.controller;

import com.example.pawtropolis.DTO.animal.Animal;
import com.example.pawtropolis.DTO.animal.AnimalsWithTail;
import com.example.pawtropolis.DTO.animal.AnimalsWithWings;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class ZooController {

    private final Map<Class<? extends Animal>, List<Animal>> animals;

    public ZooController() {
        this.animals = GameCreator.createAnimals();
    }

    public <T extends Animal> List<T> getAllAnimalsForSpecies(Class<T> animalClass) {
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