package Controller;

import Domain.CommandDomain.Command;
import Domain.CommandDomain.CommandWithInput;
import GameControls.CommandType;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

import java.util.Scanner;

//TODO obiettivo:se riusciamo aggiumgere un nuovo comando e utilizzarlo senza ricompilare.

@Getter
@Setter
@Log
public class GameController {
    private boolean exitGame = false;
    private String input;
    private String[] inputTokens;
    private String name;

    GameCreator creator = new GameCreator();
    PlayerController playerController = new PlayerController(creator.createPlayer());
    MapController mapController = new MapController(creator.getAllRooms().get(1));


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

            if (CommandType.isCommandValid(inputTokens[0])) {
                CommandController commandController = new CommandController(creator.createCommands(inputTokens, mapController, playerController));
                if (inputTokens.length < 2) {
                    commandController.getClass(Command.class, inputTokens).runCommand();
                    if (inputTokens[0].equalsIgnoreCase("exit")) {
                        exitGame = true;
                    }
                } else {
                    commandController.getClass(CommandWithInput.class, inputTokens).runCommand();
                }
            } else {
                log.info("Command not valid, for more information write help");
            }
        } while (!exitGame);
    }

}
