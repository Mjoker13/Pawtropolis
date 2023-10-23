package com.example.pawtropolis.model.Command;

import com.example.pawtropolis.controller.MapController;
import com.example.pawtropolis.controller.PlayerController;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
public abstract class Command {

    private MapController mapController;
    private PlayerController playerController;
    private String[] input;

    public abstract void runCommand();
}
