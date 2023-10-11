package Domain.CommandDomain;

import Controller.MapController;
import Controller.PlayerController;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Command {

    private String name;
    private MapController mapController;
    private PlayerController playerController;

    protected Command(String name) {
        this.name = name;
    }

    protected Command(String name, MapController mapController, PlayerController playerController) {
        this.name = name;
        this.mapController = mapController;
        this.playerController = playerController;
    }

    protected Command(String name, MapController mapController) {
        this.name = name;
        this.mapController = mapController;
    }

    protected Command(String name, PlayerController playerController) {
        this.name = name;
        this.playerController = playerController;
    }

    public void runCommand(){
    }
}
