package com.example.pawtropolis.mapper;

import com.example.pawtropolis.DTO.animal.Animal;
import com.example.pawtropolis.entity.AnimalEntity;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper
public interface AnimalMapper {
    Animal animalToDto(AnimalEntity animalEntity);
    AnimalEntity animalToAnimalEntity(Animal animal);
    List<Animal> animalListToDto(List<AnimalEntity> animalEntities);
}
