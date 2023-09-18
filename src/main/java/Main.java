import Controller.GameController;
import Domain.GameDomain.Bag;
import Domain.GameDomain.Player;
import Domain.GameDomain.Room;
import lombok.extern.java.Log;

import java.util.Scanner;
@Log
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameController gameController= new GameController();

        Player player1 = gameController.getPlayer();
        Bag bag1= gameController.getPlayer().getBag();
        Room room1= gameController.getPlayer().getActuallyRoom();

        System.out.println("This are item present in the actually room :");
        System.out.println(room1.getItemsPresentInRoom());
        System.out.println("This are item present in the bag :");
        System.out.println(bag1.getItemsInBag());
        System.out.println("Slot available in the bag is :" + bag1.getSlotAvailable() );
        System.out.println("Do you want to remove an item from bag? (S/N)");
        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("s")){
            System.out.println("Which item?");
            String chosenItem = scanner.nextLine();
            gameController.removeItemBag(player1,chosenItem);
            }
        System.out.println("Room Item now: ");
        System.out.println(room1.getItemsPresentInRoom());
        System.out.println("Bag Item now: ");
        System.out.println(bag1.getItemsInBag());
        System.out.println("Slot available in the bag is :" + bag1.getSlotAvailable());
        }
}