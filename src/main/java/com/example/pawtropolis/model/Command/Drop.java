package com.example.pawtropolis.model.Command;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Drop extends Command {
    @Override
    public void runCommand() {

        if (getInput()[0].isEmpty()) {
            log.info("Item not present");
        } else {
            if (getPlayerController().getPlayer().getItemFromBag(getInput()[0]) != null) {
                getMapController().addItemToRoom(getPlayerController().getPlayer().getItemFromBag(getInput()[0]));
                getPlayerController().getPlayer().dropItemFromBag(getPlayerController().getPlayer().getItemFromBag(getInput()[0]));
            } else {
                log.info("Item incorrect or not present");
            }
        }

    }

}
