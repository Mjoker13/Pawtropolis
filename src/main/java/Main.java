import Controller.PlayerController;
import Controller.MapController;
import GameControls.CommandType;
import lombok.extern.java.Log;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

import static GameControls.CommandType.*;

@Log
public class Main {
    public static void main(String[] args) {

        PlayerController playerController = new PlayerController();
        MapController mapController = new MapController();
        Scanner scanner = new Scanner(System.in);
        boolean exitGame = false;
        String input;
        System.out.println("What's your name?");
        String name = scanner.nextLine();
        name = name.substring(0,1).toUpperCase()+ name.substring(1).toLowerCase();
            System.out.println("Hello " + name+ " welcome to the Pawtropolis.");
            do{
                System.out.println("\n" + name+" what would you like to do? ");
                input=scanner.nextLine();
                String[] inputTokens = input.trim().split("\\s+");

                if(Arrays.stream(CommandType.values()).anyMatch(a -> inputTokens[0].equalsIgnoreCase(a.name()))) {

                    switch (Objects.requireNonNull(convertingStringToCommandType(inputTokens[0]))) {
                        case GO -> {
                                input = input.trim().replace("go", "");
                                mapController.changeRoom(input);
                        }
                        case LOOK -> mapController.showsRoomInformation();
                        case BAG -> playerController.showsBagInformation();
                        case GET->{
                            input = input.replace("get", "");
                            if(mapController.getItemFromRoom(input.replaceAll("\\s+", "")) == null){
                                log.info("Item not present;");
                            }else {
                                playerController.addItemToBag(mapController.getItemFromRoom(input.replaceAll("\\s+", "")));
                                mapController.dropItemFromRoom(mapController.getItemFromRoom(input.replaceAll("\\s+", "")));
                            }
                        }
                        case DROP ->{
                            input = input.replace("drop", "");
                            if(playerController.getItemFromBag(input.replaceAll("\\s+", ""))== null){
                                log.info("Item not present;");
                            }else{
                                mapController.addItemToRoom(playerController.getItemFromBag(input.replaceAll("\\s+", "")));
                                playerController.dropItemFromBag(playerController.getItemFromBag(input.replaceAll("\\s+", "")));
                            }
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
