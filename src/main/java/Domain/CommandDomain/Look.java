package Domain.CommandDomain;

import Controller.MapController;
import Controller.PlayerController;

public class Look extends CommandClassWithoutInput{
    public Look(MapController mapController) {
        super("look", mapController);
    }

    @Override
   public void runCommand() {
        getMapController().showsRoomInformation();
    }
}
