package Controller;

import Domain.CommandDomain.Command;
import GameControls.CommandType;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import java.util.Scanner;
import java.util.ServiceLoader;

//TODO implementare l'utilizzo di lombok, spring e maven;

@Getter
@Setter
@Log
public class GameController {
    private boolean exitGame = false;
    private String input;
    private String[] inputTokens;
    private String name;

    GameCreator creator = new GameCreator();
    MapController mapController = new MapController(creator.getAllRooms().get(1));
    PlayerController playerController = new PlayerController(creator.createPlayer());

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your name?");
        name = scanner.nextLine();
        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        System.out.println("Hello " + name + " welcome to the Pawtropolis.");
        do {
            System.out.println("\n" + name + " what would you like to do? ");
            input = scanner.nextLine();
            inputTokens = input.trim().split("\\s+");

            ServiceLoader<? extends Command> loader = ServiceLoader.load(Command.class);
            if (CommandType.isCommandValid(inputTokens[0])) {
                for (Command currentCommand : loader) {
                    if (currentCommand.getClass().getSimpleName().equalsIgnoreCase(inputTokens[0])) {
                        currentCommand.setPlayerController(playerController);
                        currentCommand.setMapController(mapController);
                        currentCommand.setInput(inputTokens);
                        currentCommand.runCommand();
                        exitGame = currentCommand.getClass().getSimpleName().equalsIgnoreCase("exit");
                    }
                }
            } else {
                log.info("Command not valid, for more information write help");
            }
        } while (!exitGame);
    }
}