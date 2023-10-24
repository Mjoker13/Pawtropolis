package com.example.pawtropolis.model.Command;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Get extends Command {

    @Override
    public void runCommand() {
        if (getInput().length < 2) {
            log.info("Command not valid, for more information write help");
        } else {
            if (getMapController().getItemFromRoom(getInput()[1]) == null) {
                log.info("Item not present;");
            } else {
                getPlayerController().getPlayer().addItemToBag(getMapController().getItemFromRoom(getInput()[1].replaceAll("\\s+", "")));
                getMapController().dropItemFromRoom(getMapController().getItemFromRoom(getInput()[1].replaceAll("\\s+", "")));
            }
        }
    }
}
