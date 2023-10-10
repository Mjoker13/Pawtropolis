package Domain.CommandDomain;

import Controller.GameController;
import Controller.MapController;
import Controller.PlayerController;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public abstract class CommandClass {

    private String name;

    private MapController mapController;
    private PlayerController playerController;

    public CommandClass(String name) {
    }

    public CommandClass(String name, MapController mapController) {
        this.name = name;
        this.mapController = mapController;
    }

    public CommandClass(String name, PlayerController playerController) {
        this.name = name;
        this.playerController = playerController;
    }

    public void runCommand(){
    }
    public void checkInput(String[] input){
          if(input.length<2){
            CommandClassWithoutInput commandClassWithoutInput= new CommandClassWithoutInput(name,mapController,playerController);
            commandClassWithoutInput.runCommand();
        }else{
            CommandClassWithInput commandClassWithInput= new CommandClassWithInput(name,mapController,playerController,input[1]);
            commandClassWithInput.runCommand();
        }

    }




}
