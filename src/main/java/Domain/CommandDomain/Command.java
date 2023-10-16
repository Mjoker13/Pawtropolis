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

    private MapController mapController;
    private PlayerController playerController;
    private String[] input;

    public abstract void runCommand();
}
