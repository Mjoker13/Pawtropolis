package com.example.pawtropolis.DTO.command;

import com.example.pawtropolis.gameControls.Direction;
import lombok.extern.log4j.Log4j2;

import java.util.ServiceLoader;

@Log4j2
public class Go extends Command {
    @Override
    public void runCommand() {
        if (Direction.isCommandValid(getInput())) {
            getMapController().changeRoom(getInput().trim());
            ServiceLoader<? extends Command> loader = ServiceLoader.load(Command.class);
            loader.forEach(l -> {
                if (l.classTriggerName().equalsIgnoreCase("look")) {
                    l.setMapController(getMapController());
                    l.runCommand();
                }
            });

        } else {
            log.info("Command not valid, for more information write help");
        }
    }

    @Override
    public String classTriggerName(){return "go";}
}
