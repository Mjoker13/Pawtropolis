import Controller.GameController;
import lombok.extern.java.Log;

import java.util.Scanner;
@Log
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       // System.out.println("What do you want to do?");
       // String input = scanner.nextLine();

        GameController gameController= new GameController();
        System.out.println("The player's item in bag are: " + gameController.getPlayer().getBag().getItemsInBag());
        System.out.println("The actually room's item are : " + gameController.getPlayer().getActuallyRoom().getItemsPresentInRoom());
        System.out.println("------------------------------------------------------------------");
        gameController.dropAndAddItem(gameController.getPlayer().getActuallyRoom().getItemsPresentInRoom().get(1));
        System.out.println("The item now, in the bag of player are: "+ gameController.getPlayer().getBag().getItemsInBag());
        System.out.println("The item now in the room are: "+ gameController.getPlayer().getActuallyRoom().getItemsPresentInRoom());

    }
}