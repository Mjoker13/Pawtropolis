package Domain.CommandDomain;

import Controller.MapController;
import Controller.PlayerController;

import java.util.List;

public class CommandClassWithoutInput extends CommandClass{

    public CommandClassWithoutInput(String name) {
        super(name);
    }

    public CommandClassWithoutInput(String name, MapController mapController) {
        super(name, mapController);
    }

    public CommandClassWithoutInput(String name, PlayerController playerController) {
        super(name, playerController);
    }

    public CommandClassWithoutInput(String name, MapController mapController, PlayerController playerController) {
        super(name, mapController, playerController);
    }

    @Override
    public void runCommand() {

    }



}
