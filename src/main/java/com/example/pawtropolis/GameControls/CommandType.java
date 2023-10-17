package com.example.pawtropolis.GameControls;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum CommandType {
    GO("go"),
    LOOK("look"),
    BAG("bag"),
    GET("get"),
    DROP("drop"),
    HELP("help"),
    EXIT("exit"),
    TEST("test");

    private final String commandName;

    CommandType(String commandName) {
        this.commandName = commandName;
    }

    public static boolean isCommandValid(String text) {
        return Arrays.stream(CommandType.values()).anyMatch(a -> text.equalsIgnoreCase(a.name()));
    }
}
