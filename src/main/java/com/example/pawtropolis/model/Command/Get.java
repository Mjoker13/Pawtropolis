package com.example.pawtropolis.model.Command;

import lombok.extern.log4j.Log4j2;


@Log4j2
public class Get extends Command {

    @Override
    public void runCommand() {

        if(getInput()[0].isEmpty()){
            log.info("Item not present");
        }else{
            if(getMapController().getItemFromRoom(getInput()[0])!=null){
                getPlayerController().getPlayer().addItemToBag(getMapController().getItemFromRoom(getInput()[0]));
                getMapController().dropItemFromRoom(getMapController().getItemFromRoom(getInput()[0]));
            }else{
                log.info("Item incorrect or not present");
            }
        }

    }
}

