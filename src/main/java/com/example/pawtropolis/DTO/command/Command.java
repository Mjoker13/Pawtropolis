package com.example.pawtropolis.DTO.command;

import com.example.pawtropolis.controller.MapController;
import com.example.pawtropolis.controller.PlayerController;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Command {

    private MapController mapController;
    private PlayerController playerController;
    private String input;
    private String triggerName;

    public abstract void runCommand();

    public String classTriggerName() {return triggerName;};
}