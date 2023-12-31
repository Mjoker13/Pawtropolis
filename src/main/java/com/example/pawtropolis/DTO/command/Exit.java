package com.example.pawtropolis.DTO.command;


import lombok.extern.log4j.Log4j2;

@Log4j2
public class Exit extends Command{

    @Override
    public void runCommand() {
        log.info("Thank you for your time, GoodBye " + getPlayerController().getPlayer().getName());
    }
    @Override
    public String classTriggerName() {
        return "Exit";
    }
}
