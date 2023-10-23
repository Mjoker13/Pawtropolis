package com.example.pawtropolis.model.Command;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Go extends Command {
    @Override
    public void runCommand() {
        if(getInput().length<2){
            log.info("Command not valid, for more information write help");
        }else{
            getMapController().changeRoom(getInput()[1].trim().replace("go", ""));
        }
    }
}
