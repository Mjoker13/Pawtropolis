package com.example.pawtropolis.model.Command;

import org.springframework.stereotype.Component;

@Component
public class Look extends Command{
    @Override
   public void runCommand() {
      getMapController().showsRoomInformation();
    }
}
