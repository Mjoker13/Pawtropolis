import Controller.GameController;
import GameControls.Menu;
import lombok.extern.java.Log;

import java.util.Arrays;
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
                System.out.println("\n" + "Now "+name+", What would you like to do? ");
                action=scanner.nextLine();
                String[] spiltAction = action.trim().split("\\s+");


                if(Arrays.stream(Menu.values()).anyMatch(a -> spiltAction[0].equalsIgnoreCase(a.name()))) {
                    System.out.println("Your actual room is : "+ gameController.getCurrentRoom().getName());

                    Menu gameControls = Menu.valueOf(spiltAction[0].toUpperCase());
                    switch (gameControls) {
                        case GO -> {
                            action = action.replace("go ", "");
                            gameController.changeRoom(action);
                        }
                        case LOOK -> gameController.showRoomInformation();
                        case BAG -> gameController.showBagInformation();
                        case GET -> {
                            action = action.replace("get", "");
                            gameController.addItemToBag(gameController.getItemFromRoom(action.replaceAll("\\s+", "")));
                            gameController.dropItemFromRoom(gameController.getItemFromRoom(action.replaceAll("\\s+", "")));
                            gameController.showRoomInformation();
                            gameController.showBagInformation();
                        }
                        case DROP -> {
                            action = action.replace("drop", "");
                            gameController.addItemToRoom(gameController.getItemFromBag(action.replaceAll("\\s+", "")));
                            gameController.dropItemFromBag(gameController.getItemFromBag(action.replaceAll("\\s+", "")));
                            gameController.showRoomInformation();
                            gameController.showBagInformation();
                        }
                        case HELP -> System.out.println("\n-Go <direction> \n-Look \n-Bag \n-Get <item> \n-Drop <item> \n-Exit");
                        case EXIT -> {
                            exitGame = true;
                            log.info("Thank you for your time, GoodBye " + name);
                        }
                        default -> log.info("Action not available, for more information write help");
                    }
                }
                else{
                    log.info("Action not available, for more information write help");
                }
                }while(!exitGame);
            }
    }
