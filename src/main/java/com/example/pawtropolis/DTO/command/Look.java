package com.example.pawtropolis.DTO.command;

public class Look extends Command{
    @Override
   public void runCommand() {
      getMapController().showRoomInformation();
    }

    @Override
    public String classTriggerName() {
        return "look";
    }
}
