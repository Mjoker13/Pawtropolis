package com.example.pawtropolis.DTO.command;

public class Bag extends Command{
    @Override
    public void runCommand() {
        getPlayerController().getPlayer().showsBagInformation();
    }
    @Override
    public String classTriggerName() {
        return "Bag";
    }
}
