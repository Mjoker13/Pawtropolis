import Controller.GameController;

import Domain.CommandDomain.Command;
import lombok.extern.java.Log;

import java.util.ServiceLoader;


@Log
public class Main {
    public static void main(String[] args) {

        GameController gameController = new GameController();
        gameController.startGame();

    }
}