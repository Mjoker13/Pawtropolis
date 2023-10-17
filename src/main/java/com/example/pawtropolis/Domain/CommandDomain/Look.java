package com.example.pawtropolis.Domain.CommandDomain;

public class Look extends Command{
    @Override
   public void runCommand() {
      getMapController().showsRoomInformation();
    }
}
