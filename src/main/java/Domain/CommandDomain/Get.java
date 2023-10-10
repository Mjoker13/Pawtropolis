package Domain.CommandDomain;

import Controller.MapController;
import Controller.PlayerController;
import lombok.extern.java.Log;

@Log
public class Get extends CommandClassWithInput{

    public Get( MapController mapController, PlayerController playerController, String item) {
        super("get", mapController, playerController, item);
    }

    @Override
   public void runCommand() {
        String item = getInput().replace("get", "");
        if (getMapController().getItemFromRoom(item.replaceAll("\\s+", "")) == null) {
            log.info("Item not present;");
        } else {
            getPlayerController().addItemToBag(getMapController().getItemFromRoom(item.replaceAll("\\s+", "")));
            getMapController().dropItemFromRoom(getMapController().getItemFromRoom(item.replaceAll("\\s+", "")));
        }
    }
}
