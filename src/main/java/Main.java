import Controller.GameController;
import Domain.GameDomain.Player;
import lombok.extern.java.Log;
import java.util.Scanner;

@Log
public class Main {
    private static String pess;


    public static void main(String[] args) {

        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);
        Player player = gameController.getPlayer();
        boolean confirm = false;
        String chosenItem="";

        System.out.println("Welcome to the Pawtropolis city; \nWhat's your name? ");
        String name = scanner.nextLine().toUpperCase();

        while (!confirm){
            System.out.println("Hello " + name + " do you want play? (yes/no) ");
            String doYouWantPlay = scanner.nextLine();

            if (doYouWantPlay.equalsIgnoreCase("yes")) {
            System.out.println("Hi "+name+", Welcome to Pawtropolis");
            System.out.println("\n" + "You have " + player.getLifePoints() + " life points");
            System.out.println("\n" + "You have a bag that it can contain many item, with maximum slot of "+player.getBag().getMaxCapacity() + "\n" +
                    "The item in your bag take up space, actually have a " + player.getBag().getSlotAvailable() + " slot available");
            System.out.println(name + " your actually room is : "+ player.getActuallyRoom().getName());
            while (!confirm) {
                System.out.println("\n" + "Now "+name+", What would you like to do? ");
                System.out.println("1 -> change room? \n2 -> look around? \n3 -> look bag? \n4 -> get items from the room? \n5 -> drop items from the bag? \n6 -> Exit from the game?");
                String action;
                action=scanner.nextLine();
                switch (action.toLowerCase()) {
                    case "1"->{
                        System.out.println("\n" + "These are a rooms, you are in : " + '"' + player.getActuallyRoom().getName() + '"');
                        gameController.printAllRooms(player.getActuallyRoom().getName());
                        System.out.println("Which direction do you want to go? \n1 -> go south ↓ \n2 -> go north ↑ \n3 -> go east → \n4 -> go west ←");
                        String room= scanner.nextLine();
                        gameController.changeRoom(player,room);
                    }
                    case "2" -> gameController.getInformationInRoom(player.getActuallyRoom());
                    case "3" -> gameController.getInformationBag(player.getBag());
                    case "4" -> {
                        System.out.println("In this room is present: " + player.getActuallyRoom().getItemsPresentInRoom());
                        System.out.println("Which item?");
                        chosenItem = scanner.nextLine();
                        player.addItemToBagAndDropItemToRoom(player.getItemInRoom(chosenItem));
                        gameController.getInformationInRoom(player.getActuallyRoom());
                        gameController.getInformationBag(player.getBag());
                    }
                    case "5" -> {
                        System.out.println("In this bag is present: ");
                        gameController.getInformationBag(player.getBag());
                        System.out.println("Which item do you remove?");
                        chosenItem = scanner.nextLine();
                        player.addItemToRoomAndDropItemToBag(player.getItemInBag(chosenItem));
                        gameController.getInformationInRoom(player.getActuallyRoom());
                        gameController.getInformationBag(player.getBag());
                    }
                    case "6"->{
                        confirm=true;
                        log.info("Thank you for your time, GoodBye "+ name);
                    }
                    default ->
                        log.info("Action not present");
                }
            }
        } else if(doYouWantPlay.equalsIgnoreCase("no")){
            System.out.println("Goodbye ");
                confirm=true;
        } else{
            log.info("Error command not found. \nRetry\n\n");
        }
    }
}
}
