package com.example.pawtropolis.model.Command;

public class Look extends Command{
    @Override
   public void runCommand() {
      getMapController().showRoomInformation();
    }
}
