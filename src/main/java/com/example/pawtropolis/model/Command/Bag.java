package com.example.pawtropolis.model.Command;

import org.springframework.stereotype.Component;

@Component
public class Bag extends Command{
    @Override
    public void runCommand() {
        getPlayerController().showsBagInformation();
    }
}
