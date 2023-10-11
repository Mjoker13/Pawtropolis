package Domain.CommandDomain;

import Controller.MapController;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

@Log
public class Go extends CommandWithInput {

    public Go(MapController mapController, String[] input) {
        super("go",mapController, input);
    }

    @Override
    public void runCommand() {
        if(getInput().length<2){
            log.info("Command not valid, for more information write help");
        }else{
            getMapController().changeRoom(getInput()[1].trim().replace("go", ""));
        }
    }
}
