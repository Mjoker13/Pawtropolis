package com.example.pawtropolis.model.Command;

public class Bag extends Command{
    @Override
    public void runCommand() {
        getPlayerController().getPlayer().showsBagInformation();
    }
}
