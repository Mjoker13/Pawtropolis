package com.example.pawtropolis.Domain.CommandDomain;

import com.example.pawtropolis.Controller.MapController;
import com.example.pawtropolis.Controller.PlayerController;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Command {

    private MapController mapController;
    private PlayerController playerController;
    private String[] input;

    public abstract void runCommand();
}
