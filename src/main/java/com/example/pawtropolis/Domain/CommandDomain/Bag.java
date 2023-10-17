package com.example.pawtropolis.Domain.CommandDomain;

public class Bag extends Command{

    @Override
    public void runCommand() {
        getPlayerController().showsBagInformation();
    }
}
