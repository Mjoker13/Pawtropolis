package Controller;

import Domain.CommandDomain.CommandClass;
import Domain.CommandDomain.Go;
import GameControls.CommandType;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;


@Getter
@Setter
@Log
public class GameController {
    private boolean exitGame = false;
    private String input;
    private String[] inputTokens;
    private String name;

    PlayerController playerController = new PlayerController();
    MapController mapController = new MapController();
    CommandController commandController= new CommandController();


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
            CommandClass commandClass= new CommandClass(inputTokens[0], mapController, playerController) { };

            if (CommandType.isCommandValid(inputTokens[0])) {
                commandController.getClass(commandClass.getClass(),inputTokens);

            } else {
                log.info("Command not valid, for more information write help");
            }
        } while (!exitGame);
    }
//TODO creare una classe per ogni comando, con una classe padre comando e le sotto classi con i vari command type, con un metodo runcommand() che verrà implementato in ogni classe.
//TODO obiettivo: se dovessi creare un nuovo comando, non devo modificare il codice, ma creare solo la classe. plus: se riusciamo aggiumgere un nuovo comando e utilizzarlo senza ricompilare.

    private void runCommand() {
        switch (Objects.requireNonNull(CommandType.convertString(inputTokens[0]))) {
            case GO -> {

            }
            case LOOK -> mapController.showsRoomInformation();
            case BAG -> playerController.showsBagInformation();
            case GET -> {
                input = input.replace("get", "");
                if (mapController.getItemFromRoom(input.replaceAll("\\s+", "")) == null) {
                    log.info("Item not present;");
                } else {
                    playerController.addItemToBag(mapController.getItemFromRoom(input.replaceAll("\\s+", "")));
                    mapController.dropItemFromRoom(mapController.getItemFromRoom(input.replaceAll("\\s+", "")));
                }
            }
            case DROP -> {
                input = input.replace("drop", "");
                if (playerController.getItemFromBag(input.replaceAll("\\s+", "")) == null) {
                    log.info("Item not present;");
                } else {
                    mapController.addItemToRoom(playerController.getItemFromBag(input.replaceAll("\\s+", "")));
                    playerController.dropItemFromBag(playerController.getItemFromBag(input.replaceAll("\\s+", "")));
                }
            }
            case HELP -> System.out.println("\n-Go <direction> \n-Look \n-Bag \n-Get <item> \n-Drop <item> \n-Exit");
            case EXIT -> {
                exitGame = true;
                log.info("Thank you for your time, GoodBye " + name);
            }
            default -> log.info("Action not available, for more information write help");
        }
    }
}
