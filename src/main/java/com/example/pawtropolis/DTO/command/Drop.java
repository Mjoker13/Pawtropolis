package com.example.pawtropolis.DTO.command;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Drop extends Command {
    @Override
    public void runCommand() {

        if (getInput().isEmpty()) {
            log.info("Item not present");
        } else {
            if (getPlayerController().getPlayer().getItemFromBag(getInput()) != null) {
                getMapController().addItemToRoom(getPlayerController().getPlayer().getItemFromBag(getInput()));
                getPlayerController().getPlayer().dropItemFromBag(getPlayerController().getPlayer().getItemFromBag(getInput()));
            } else {
                log.info("Item incorrect or not present");
            }
        }
    }
    @Override
    public String classTriggerName() {
        return "Drop";
    }
}
