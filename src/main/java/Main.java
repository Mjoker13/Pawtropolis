import Controller.GameController;
import Controller.GameCreator;
import Domain.GameDomain.Bag;
import Domain.GameDomain.Player;
import Domain.GameDomain.Room;
import lombok.extern.java.Log;

import java.util.Scanner;


@Log
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController();
        Player player1 = gameController.getPlayer();
        Bag bag1 = gameController.getPlayer().getBag();
        Room room1 = gameController.getPlayer().getActuallyRoom();
        boolean conferme = false;

        gameController.printAllRooms();

        System.out.println(gameController.getRooms());

        System.out.println("Welcome to the Pawtropolis city; What's your name? ");
        String name = scanner.nextLine();
        player1.setName(name);
        System.out.println("Hello " + name + " do you want play? (yes/no) ");
        String doYouWantPlay = scanner.nextLine();
        if (doYouWantPlay.equalsIgnoreCase("yes")) {
            conferme = true;
        } else {
            System.out.println("Goodbye ");
        }
        while (conferme) {
            System.out.println("\n" + "Your player has life points :" + player1.getLifePoints() + " and a bag with some free starter gadgets " + bag1.getItemsInBag());
            System.out.println("\n" + "Each gadget occupies a space inside the bag, which has a maximum space of 20 " + "\n" +
                    "by removing the space occupied by your gadgets, your remaining space is " + bag1.getSlotAvailable());
            System.out.println(name + " your actually room is :");
            gameController.getInformationInRoom(player1.getActuallyRoom());
            System.out.println("\n" + "These are item present in the actually room :");
            System.out.println(room1.getItemsPresentInRoom());
            while(conferme) {
                System.out.println("\n" + "Do you want to add an item from bag? (yes/no)");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("yes")) {
                    System.out.println("Which item?");
                    String chosenItem = scanner.nextLine();
                    gameController.addItemBag(player1, chosenItem);
                }else{
                    conferme= false;
                }
                System.out.println("Room Item now: ");
                System.out.println(room1.getItemsPresentInRoom());
                gameController.getInformationBag(bag1);
            }
            conferme = false;
        }
    }
}

