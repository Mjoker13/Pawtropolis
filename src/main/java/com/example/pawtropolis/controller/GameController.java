package com.example.pawtropolis.controller;

import com.example.pawtropolis.model.Command.Command;
import com.example.pawtropolis.gameControls.CommandType;
import com.example.pawtropolis.model.Game.BagPlayer;
import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.Scanner;
import java.util.ServiceLoader;

@Data
@Log
@Controller
public class GameController implements CommandLineRunner {
    private boolean exitGame = false;
    private String input;
    private String[] inputTokens;
    private String name;
    private PlayerController playerController;

    @Autowired
    public GameController(PlayerController playerController){
        this.playerController= playerController;
    }

    GameCreator creator = new GameCreator();
    MapController mapController = new MapController(creator.getAllRooms().get(1));

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your name?");
        name = scanner.nextLine();
        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        System.out.println("Hello " + name + " welcome to the Pawtropolis.");
        playerController.getPlayer().setBagPlayer(new BagPlayer());
        playerController.getPlayer().setName(name);
        playerController.getPlayer().setLifePoints(100);
        do {
            System.out.println("\n" + name + " what would you like to do? ");
            input = scanner.nextLine();
            inputTokens = input.trim().split("\\s+");

            ServiceLoader<? extends Command> loader = ServiceLoader.load(Command.class);
            if (CommandType.isCommandValid(inputTokens[0])) {
                for (Command currentCommand : loader) {
                    if (currentCommand.getClass().getSimpleName().equalsIgnoreCase(inputTokens[0])) {
                        currentCommand.setMapController(mapController);
                        currentCommand.setPlayerController(playerController);
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

    @Override
    public void run(String... args) throws Exception {
        startGame();
    }
}