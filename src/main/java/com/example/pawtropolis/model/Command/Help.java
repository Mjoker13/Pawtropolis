package com.example.pawtropolis.model.Command;


import lombok.extern.log4j.Log4j2;

@Log4j2
public class Help extends Command{
    @Override
    public void runCommand() {
        log.info("-Go <direction> \n-Look \n-Bag \n-Get <item> \n-Drop <item> \n-Exit");
    }

    @Override
    public String classTriggerName() {
        return "Help";
    }
}
