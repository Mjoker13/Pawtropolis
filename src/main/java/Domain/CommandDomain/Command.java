package Domain.CommandDomain;

import Controller.MapController;
import Controller.PlayerController;
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
    private String[] input;

    protected Command(String name) {
        this.name = name;
    }

    public void runCommand(){
    }
}
