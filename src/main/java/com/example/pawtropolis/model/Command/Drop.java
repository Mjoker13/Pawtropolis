package com.example.pawtropolis.model.Command;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Drop extends Command {
    @Override
    public void runCommand() {
        if (getInput().length < 2) {
            log.info("Command not valid, for more information write help");
        } else {
            if (getPlayerController().getItemFromBag(getInput()[1]) == null) {
                log.info("Item not present;");
            } else {
                getMapController().addItemToRoom(getPlayerController().getItemFromBag(getInput()[1].replaceAll("\\s+", "")));
                getPlayerController().dropItemFromBag(getPlayerController().getItemFromBag(getInput()[1].replaceAll("\\s+", "")));
            }
        }
    }
}
