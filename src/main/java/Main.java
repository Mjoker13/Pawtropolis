import Controller.GameController;
import Controller.GameCreator;
import Domain.GameDomain.Bag;
import Domain.GameDomain.Player;
import lombok.extern.java.Log;

import java.util.Scanner;
@Log
public class Main {
    public static void main(String[] args) {

        GameCreator gameCreator = new GameCreator();
        GameController gameController = new GameController();
        gameCreator.createRooms();

        Bag bag = new Bag(gameCreator.createItem(), 10);
        Player player = new Player("francesco", 100, gameCreator.getAllRooms().get(1), bag);

        System.out.println(player.getActuallyRoom());
        Scanner scanner = new Scanner(System.in);

      /*-----------------*/
        System.out.println("What do you want to do?");
        String input = scanner.nextLine();

        player.setActuallyRoom(gameController.changeRoom(player, input));
        System.out.println(player.getActuallyRoom());

       /*--------------------*/
        System.out.println("The player's item in bag are: " + gameController.getPlayer().getBag().getItemsInBag());
        System.out.println("The actually room's item are : " + gameController.getPlayer().getActuallyRoom().getItemsPresentInRoom());
        System.out.println("------------------------------------------------------------------");
        gameController.dropAndAddItem(gameController.getPlayer().getActuallyRoom().getItemsPresentInRoom().get(1));
        System.out.println("The item now, in the bag of player are: " + gameController.getPlayer().getBag().getItemsInBag());
        System.out.println("The item now in the room are: " + gameController.getPlayer().getActuallyRoom().getItemsPresentInRoom());
    }
}