import Controller.GameController;
import lombok.extern.java.Log;

@Log
public class Main {
    public static void main(String[] args) {

        GameController gameController = new GameController();
        gameController.startGame();
    }
}