package com.example.pawtropolis.Domain.CommandDomain;

import lombok.extern.java.Log;

@Log
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
