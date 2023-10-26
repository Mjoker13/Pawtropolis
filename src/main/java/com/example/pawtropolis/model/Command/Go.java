package com.example.pawtropolis.model.Command;

import com.example.pawtropolis.gameControls.Direction;
import lombok.extern.log4j.Log4j2;

import java.util.ServiceLoader;

@Log4j2
public class Go extends Command {
    @Override
    public void runCommand() {
        if (Direction.isCommandValid(getInput()[0])) {
            getMapController().changeRoom(getInput()[0].trim());
            ServiceLoader<? extends Command> loader = ServiceLoader.load(Command.class);
            loader.forEach(l -> {
                if (l.getClass().getSimpleName().equalsIgnoreCase("look")) {
                    l.setMapController(getMapController());
                    l.runCommand();
                }
            });

        } else {
            log.info("Command not valid, for more information write help");

        }
    }
}
