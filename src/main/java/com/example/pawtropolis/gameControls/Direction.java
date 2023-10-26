package com.example.pawtropolis.gameControls;


import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

@Getter
public enum Direction {
    NORTH("north"),
    SOUTH("south"),
    EAST("east"),
    WEST("west");

    private final String directionType;

    Direction(String direction) {
        this.directionType = direction;
    }

    public static @Nullable Direction convertingStringToDirection(String text) {
        return Arrays.stream(Direction.values()).filter(d -> d.directionType.equalsIgnoreCase(text))
                .findFirst()
                .orElse(null);
    }

    public static Direction getOppositeDirection(@NotNull Direction direction) {
        return switch (direction) {
            case NORTH -> SOUTH;
            case SOUTH -> NORTH;
            case EAST -> WEST;
            case WEST -> EAST;
        };
    }
    public static boolean isCommandValid(String text) {
        return Arrays.stream(Direction.values()).anyMatch(a -> text.equalsIgnoreCase(a.name()));
    }
}
