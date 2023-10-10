package Domain.CommandDomain;

import Controller.MapController;
import Controller.PlayerController;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

import java.util.List;

@Setter
@Getter
public class CommandClassWithInput extends CommandClass{
    private List<CommandClassWithInput> commandClassWithInputList;
    private String input;

    public CommandClassWithInput(String name, MapController mapController, PlayerController playerController,String input) {
        super(name, mapController, playerController);
        this.input=input;
    }

    public CommandClassWithInput(String name, MapController mapController, String input) {
        super(name, mapController);
        this.input = input;
    }

    public CommandClassWithInput(String name, PlayerController playerController, String input) {
        super(name, playerController);
        this.input = input;
    }

    @Override
    public void runCommand() {
        createCommand(getName(),getInput()).runCommand();

    }
    public CommandClass createCommand(String name,String input) {

        switch (name.toLowerCase()) {
            case "go":
                return new Go(getMapController(),input);
            case "get":
                return new Get(getMapController(),getPlayerController(),input);
            case "drop":
                return new Drop(getMapController(),getPlayerController(),input);

            default:
                throw new IllegalArgumentException("Comando sconosciuto: " + name);
        }
    }
}
