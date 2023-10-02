import Controller.PlayerController;
import Controller.MapController;
import GameControls.Menu;
import lombok.extern.java.Log;

import java.util.Arrays;
import java.util.Scanner;

@Log
public class Main {
    public static void main(String[] args) {

        PlayerController playerController = new PlayerController();
        MapController mapController = new MapController();
        Scanner scanner = new Scanner(System.in);
        boolean exitGame = false;
        String action;
        System.out.println("What's your name?");
        String name = scanner.nextLine();
        name = name.substring(0,1).toUpperCase()+ name.substring(1).toLowerCase();
            System.out.println("Hello " + name+ " welcome to the Pawtropolis.");
            do{
                System.out.println("\n" + name+" what would you like to do? ");
                action=scanner.nextLine();
                String[] spiltAction = action.trim().split("\\s+");
                if(Arrays.stream(Menu.values()).anyMatch(a -> spiltAction[0].equalsIgnoreCase(a.name()))) {
                    Menu gameControls = Menu.valueOf(spiltAction[0].toUpperCase());
                    switch (gameControls) {
                        case GO -> {
                            action = action.replace("go ", "");
                            mapController.changeRoom(action);
                        }
                        case LOOK -> mapController.showRoomInformation();
                        case BAG -> playerController.showBagInformation();
                        case GET ->{
                            action = action.replace("get", "");
                            playerController.addItemToBag(mapController.getItemFromRoom(action.replaceAll("\\s+", "")));
                            mapController.dropItemFromRoom(mapController.getItemFromRoom(action.replaceAll("\\s+", "")));
                        }
                        case DROP ->{
                            action = action.replace("drop", "");
                            mapController.addItemToRoom(playerController.getItemFromBag(action.replaceAll("\\s+", "")));
                            playerController.dropItemFromBag(playerController.getItemFromBag(action.replaceAll("\\s+", "")));
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
