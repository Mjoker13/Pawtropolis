package com.example.pawtropolis.controller;

import com.example.pawtropolis.DTO.command.Command;
import com.example.pawtropolis.gameControls.CommandType;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.Scanner;
import java.util.ServiceLoader;

@Log4j2
@Controller
public class GameController implements CommandLineRunner {
    private final PlayerController playerController;
    private final MapController mapController;
    private final GameCreator gameCreator;

    @Autowired
    public GameController(PlayerController playerController, MapController mapController, GameCreator gameCreator) {
        this.playerController = playerController;
        this.mapController = mapController;
        this.gameCreator = gameCreator;
    }

    public void startGame() {
        boolean exitGame = false;
        String input;
        String[] inputTokens;
        String name;

        mapController.setCurrentRoom(gameCreator.getAllRooms().get(1));

        Scanner scanner = new Scanner(System.in);
        log.info("\n" +"What's your name?");
        name = scanner.nextLine();
        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        log.info("Hello " + name + " welcome to the Pawtropolis.");

        playerController.getPlayer().setName(name);
        playerController.getPlayer().setLifePoints(100);
        do {
            log.info("\n" + name + " what would you like to do? ");
            input = scanner.nextLine();
            inputTokens = input.trim().split("\\s+");
            ServiceLoader<? extends Command> loader = ServiceLoader.load(Command.class);

            if (CommandType.isCommandValid(inputTokens[0])) {
                for (Command currentCommand : loader) {
                    if (currentCommand.getClass().getSimpleName().equalsIgnoreCase(inputTokens[0])) {
                        currentCommand.setMapController(mapController);
                        currentCommand.setPlayerController(playerController);
                        String parameter= input.replace(inputTokens[0], "").trim();
                        currentCommand.setInput(parameter);
                        currentCommand.runCommand();
                        exitGame = currentCommand.getClass().getSimpleName().equalsIgnoreCase("exit");
                    }
                }
            } else {
                log.error("Command not valid, for more information write help");
            }
        } while (!exitGame);
    }

    @Override
    public void run(String... args) throws Exception {
        startGame();
    }
}