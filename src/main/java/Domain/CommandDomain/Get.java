package Domain.CommandDomain;

import Controller.MapController;
import Controller.PlayerController;
import lombok.extern.java.Log;

@Log
public class Get extends CommandWithInput {

    public Get(MapController mapController, PlayerController playerController, String[] input) {
        super("get", mapController, playerController, input);
    }

    @Override
    public void runCommand() {
        if (getInput().length < 2) {
            log.info("Command not valid, for more information write help");
        } else {
            if (getMapController().getItemFromRoom(getInput()[1]) == null) {
                log.info("Item not present;");
            } else {
                getPlayerController().addItemToBag(getMapController().getItemFromRoom(getInput()[1].replaceAll("\\s+", "")));
                getMapController().dropItemFromRoom(getMapController().getItemFromRoom(getInput()[1].replaceAll("\\s+", "")));
            }
        }
    }
}
