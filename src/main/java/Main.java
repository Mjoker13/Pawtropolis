import Controller.GameController;
import Controller.GameCreator;
import Domain.GameDomain.Bag;
import Domain.GameDomain.Item;
import Domain.GameDomain.Player;
import Domain.GameDomain.Room;
import lombok.extern.java.Log;

import java.util.Locale;
import java.util.Scanner;


@Log
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController();
        Player player1 = gameController.getPlayer();
        Bag bag1 = gameController.getPlayer().getBag();
        boolean conferme = false;
        String action=null;
        String room;

        System.out.println("Welcome to the Pawtropolis city; \nWhat's your name? ");
        String name = scanner.nextLine().toUpperCase();


        while (!conferme){
            System.out.println("Hello " + name + " do you want play? (yes/no) ");
            String doYouWantPlay = scanner.nextLine();

            if (doYouWantPlay.equalsIgnoreCase("yes")) {
            System.out.println("Hi "+player1.getName()+", Welcome to Powtropolis");
            System.out.println("\n" + "You has " + player1.getLifePoints() + "life points and a bag with some free starter gadgets " + bag1.getItemsInBag());
            System.out.println("\n" + "Each gadget occupies a space inside the bag, which has a maximum space of 20 " + "\n" +
                    "by removing the space occupied by your gadgets, your remaining space is " + bag1.getSlotAvailable());
            System.out.println(name + " your actually room is : "+ player1.getActuallyRoom().getName());
            while (!conferme) {

                System.out.println("Now "+player1.getName()+", What would you like to do? ");
                System.out.println("-1: change room? \n-2: look around? \n-3: look bag? \n-4: get items from the room? \n-5: drop items from the bag? \n-6: Exit from the game?");
                action=scanner.nextLine();
                switch (action.toLowerCase()){
                    case "1"->{
                        System.out.println("Which direction do you want to go? \n-1: go south \n-2: go north \n-3: go east \n-4: go west");
                        room=scanner.nextLine();
                        if(room.equalsIgnoreCase("1"))
                            room="go south";
                        else if(room.equalsIgnoreCase("2"))
                            room="go north";
                        else if(room.equalsIgnoreCase("3"))
                            room="go east";
                        else
                            room="go west";
                        gameController.changeRoom(player1,room);
                    }
                    case "2"->{
                        gameController.getInformationInRoom(player1.getActuallyRoom());
                    }
                    case "3"->{
                        gameController.getInformationBag(player1.getBag());
                    }
                    case "4"->{
                        System.out.println("In this room is present: ");
                        gameController.getInformationInRoom(player1.getActuallyRoom());
                        System.out.println("Which item?");
                        String chosenItem = scanner.nextLine();
                        gameController.addItemBag(player1, chosenItem);

                    }
                    case "5"->{
                        System.out.println("In this bag is present: ");
                        gameController.getInformationBag(bag1);
                        System.out.println("Which item do you remove?");
                        String chosenItem = scanner.nextLine();
                        gameController.removeItemBag(player1, chosenItem);
                    }
                    case "6"->{
                        conferme=true;
                        log.info("Thank's for your time, GoodBye "+ player1.getName());
                        break;
                    }
                    default -> {
                        log.info("Action not present");
                    }
                }

            }
        } else if(doYouWantPlay.equalsIgnoreCase("no")){
            System.out.println("Goodbye ");
            conferme=true;
        } else{
            log.info("Error command not found. \nRetry\n\n");
        }
        }
    }
}

