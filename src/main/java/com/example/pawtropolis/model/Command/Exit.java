package com.example.pawtropolis.model.Command;


import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Log
@Component
public class Exit extends Command{

    @Override
    public void runCommand() {
        log.info("Thank you for your time, GoodBye " + getPlayerController().getPlayer().getName());
    }
}
