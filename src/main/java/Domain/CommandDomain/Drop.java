package Domain.CommandDomain;

import Controller.MapController;
import Controller.PlayerController;
import lombok.extern.java.Log;

@Log
public class Drop extends CommandClassWithInput{

    public Drop( MapController mapController, PlayerController playerController, String input) {
        super("drop", mapController, playerController, input);
    }

    @Override
    public void runCommand() {
        String item = getInput().replace("drop", "");
        if (getPlayerController().getItemFromBag(item.replaceAll("\\s+", "")) == null) {
            log.info("Item not present;");
        } else {
            getMapController().addItemToRoom(getPlayerController().getItemFromBag(item.replaceAll("\\s+", "")));
            getPlayerController().dropItemFromBag(getPlayerController().getItemFromBag(item.replaceAll("\\s+", "")));
        }
    }
}
