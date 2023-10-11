package Domain.CommandDomain;

import Controller.MapController;
import Controller.PlayerController;
import lombok.extern.java.Log;

@Log
public class Drop extends CommandWithInput {

    public Drop(MapController mapController, PlayerController playerController, String[] input) {
        super("drop", mapController, playerController, input);
    }

    @Override
    public void runCommand() {
        if (getInput().length < 2) {
            log.info("Command not valid, for more information write help");
        } else {
            if (getPlayerController().getItemFromBag(getInput()[1]) == null) {
                log.info("Item not present;");
            } else {
                getMapController().addItemToRoom(getPlayerController().getItemFromBag(getInput()[1].replaceAll("\\s+", "")));
                getPlayerController().dropItemFromBag(getPlayerController().getItemFromBag(getInput()[1].replaceAll("\\s+", "")));
            }
        }
    }
}
