import Controller.GameController;
import lombok.extern.java.Log;

import java.util.Scanner;

@Log
public class Main {
    public static void main(String[] args) {

        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);
        boolean exitGame = false;
        String action;

        System.out.println("What's your name?");
        String name = scanner.nextLine();
        name = name.substring(0,1).toUpperCase()+ name.substring(1).toLowerCase();

            System.out.println("Hello " + name+ " welcome to the Pawtropolis.");
            do{
                System.out.println("Your actual room is : "+ gameController.getCurrentRoom().getName());
                System.out.println("\n" + "Now "+name+", What would you like to do? ");
                action=scanner.nextLine();
                String[] spiltAction = action.trim().split("\\s+");
                    switch (spiltAction[0].toLowerCase()) {
                        case "go" ->gameController.changeRoom(action.trim().replaceAll("\\s+",""));
                        case "look" -> gameController.showRoomInformation();
                        case "bag" -> gameController.showBagInformation();
                        case "get" -> {
                            action= action.replace("get", "");
                            gameController.addItemToBag(gameController.getItemFromRoom(action.replaceAll("\\s+","")));
                            gameController.dropItemFromRoom(gameController.getItemFromRoom(action.replaceAll("\\s+","")));
                            gameController.showRoomInformation();
                            gameController.showBagInformation();
                        }
                        case "drop" -> {
                            action= action.replace("drop", "");
                            gameController.addItemToRoom(gameController.getItemFromBag(action.replaceAll("\\s+","")));
                            gameController.dropItemFromBag(gameController.getItemFromBag(action.replaceAll("\\s+","")));
                            gameController.showRoomInformation();
                            gameController.showBagInformation();
                        }
                        case "help" ->System.out.println("\n-Go <direction> \n-Look \n-Bag \n-Get <item> \n-Drop <item> \n-Exit");
                        case "exit" -> {
                            exitGame = true;
                            log.info("Thank you for your time, GoodBye " + name);
                        }
                        default -> log.info("Action not available, for more information write help");
                    }
                }while(!exitGame);
            }
    }
