import Controller.GameCreator;
import Domain.AnimalDomain.Animal;
import Controller.ZooController;
import Controller.GameController;
import Domain.GameDomain.*;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@Log
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do?");
        String input = scanner.nextLine();

        ZooController zooController= new ZooController();

        List<Class<? extends Animal>> tigers = new ArrayList<>();


        List<Item> items= new ArrayList<>();
        Item item1= new Item("Martello", "ahahahshsiejd",1);
        Item item2= new Item("Chiodo", "ahahahshsiejd",1);
        items.add(item2);
        items.add(item1);

        GameCreator gameCreator = new GameCreator();
        gameCreator.createRooms(items);

    }
}