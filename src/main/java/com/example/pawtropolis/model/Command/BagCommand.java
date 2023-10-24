package com.example.pawtropolis.model.Command;

public class BagCommand extends Command{
    @Override
    public void runCommand() {
        getPlayerController().getPlayer().showsBagInformation();
    }
}
