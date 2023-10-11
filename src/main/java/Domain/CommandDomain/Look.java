package Domain.CommandDomain;


import Controller.MapController;

public class Look extends Command{

    public Look(MapController mapController) {
        super("look", mapController);
    }

    @Override
   public void runCommand() {
        getMapController().showsRoomInformation();
    }
}
