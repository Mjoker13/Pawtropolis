package com.example.pawtropolis.model.Animal;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public abstract class Animal {
    private String name;
    private String favoriteFood;
    private int age;
    private LocalDate entryDate;
    private float weight;
    private float height;
}
