package Domain.CommandDomain;

import Controller.MapController;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Go extends CommandClassWithInput{




    public Go(MapController mapController,String direction) {
        super("go", mapController,direction);
    }

    @Override
    public void runCommand() {
        String direction = getInput().trim().replace("go", "");
        getMapController().changeRoom(direction);
    }
}
