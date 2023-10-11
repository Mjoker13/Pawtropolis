package Domain.CommandDomain;

import Controller.MapController;
import Controller.PlayerController;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class CommandWithInput extends Command {
    private String[] input;

    protected CommandWithInput(String name, MapController mapController, PlayerController playerController, String[] input) {
        super(name, mapController, playerController);
        this.input = input;
    }

    protected CommandWithInput(String name, MapController mapController, String[] input) {
        super(name, mapController);
        this.input = input;
    }
}
