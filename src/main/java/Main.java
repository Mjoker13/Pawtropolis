import Controller.GameController;
import Domain.GameDomain.Bag;
import Domain.GameDomain.Player;
import lombok.extern.java.Log;

import java.util.Scanner;

@Log
public class Main {
    public static void main(String[] args) {

        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);
        Player actuallyPlayer = gameController.getPlayer();
        Bag playerBag = gameController.getPlayer().getBag();
        boolean confirm = false;

        System.out.println("Welcome to the Pawtropolis city; \nWhat's your name? ");
        String name = scanner.nextLine().toUpperCase();

        while (!confirm){
            System.out.println("Hello " + name + " do you want play? (yes/no) ");
            String doYouWantPlay = scanner.nextLine();

            if (doYouWantPlay.equalsIgnoreCase("yes")) {
            System.out.println("Hi "+name+", Welcome to Pawtropolis");
            System.out.println("\n" + "You has " + actuallyPlayer.getLifePoints() + " life points and a bag with some free starter gadgets " + playerBag.getItemsInBag());
            System.out.println("\n" + "Each gadget occupies a space inside the bag, which has a maximum space of 20 " + "\n" +
                    "by removing the space occupied by your gadgets, your remaining space is " + playerBag.getSlotAvailable());
            System.out.println(name + " your actually room is : "+ actuallyPlayer.getActuallyRoom().getName());
            while (!confirm) {

                System.out.println("\n" + "Now "+name+", What would you like to do? ");
                System.out.println("1 -> change room? \n2 -> look around? \n3 -> look bag? \n4 -> get items from the room? \n5 -> drop items from the bag? \n6 -> Exit from the game?");
                String action;
                action=scanner.nextLine();
                switch (action.toLowerCase()){
                    case "1"->{
                        System.out.println("\n"+"These are a rooms, you are in :" + actuallyPlayer.getActuallyRoom().getName());
                        gameController.printAllRooms();
                        System.out.println();
                        System.out.println("Which direction do you want to go? \n1 -> go south \u2193 \n2 -> go north \u2191 \n3 -> go east \u2192 \n4 -> go west \u2190");
                        String room = scanner.nextLine();
                        if(room.equalsIgnoreCase("1"))
                            room="go south";
                        else if(room.equalsIgnoreCase("2"))
                            room="go north";
                        else if(room.equalsIgnoreCase("3"))
                            room="go east";
                        else
                            room="go west";
                        gameController.changeRoom(actuallyPlayer,room);
                    }
                    case "2"->
                        gameController.getInformationInRoom(actuallyPlayer.getActuallyRoom());
                    case "3"->
                        gameController.getInformationBag(actuallyPlayer.getBag());
                    case "4"->{
                        System.out.println("In this room is present: ");
                        gameController.getInformationInRoom(actuallyPlayer.getActuallyRoom());
                        System.out.println("Which item?");
                        String chosenItem = scanner.nextLine();
                        gameController.addItemBag(actuallyPlayer, chosenItem);
                        System.out.println("Item "+ chosenItem.toUpperCase() +" taken, Now your bag has :");
                        gameController.getInformationBag(playerBag);
                    }
                    case "5"->{
                        System.out.println("In this bag is present: ");
                        gameController.getInformationBag(playerBag);
                        System.out.println("Which item do you remove?");
                        String chosenItem = scanner.nextLine();
                        gameController.removeItemBag(actuallyPlayer, chosenItem);
                        System.out.println("Item "+ chosenItem.toUpperCase() +" removed, Now your bag has :");
                        gameController.getInformationBag(playerBag);
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

