package com.example.pawtropolis.DTO.command;

import lombok.extern.log4j.Log4j2;


@Log4j2
public class Get extends Command {

    @Override
    public void runCommand() {

        if(getInput().isEmpty()){
            log.info("Item not present");
        }else{
            if(getMapController().getItemFromRoom(getInput())!=null){
                getPlayerController().getPlayer().addItemToBag(getMapController().getItemFromRoom(getInput()));
                getMapController().dropItemFromRoom(getMapController().getItemFromRoom(getInput()));
            }else{
                log.info("Item incorrect or not present");
            }
        }
    }
    @Override
    public String classTriggerName() {
        return "Get";
    }
}

