package Controller;

import Domain.AnimalDomain.Animal;
import Domain.AnimalDomain.Eagle;
import Domain.AnimalDomain.Lion;
import Domain.AnimalDomain.Tiger;
import Domain.GameDomain.Item;
import Domain.GameDomain.Room;

import java.util.ArrayList;
import java.util.List;

public class GameCreator {

    ZooController zooController= new ZooController();

    public void createRooms(List<Item> item) {

        List<Animal> tiger = new ArrayList<>(zooController.getAllAnimalsForSpecies(Tiger.class));
        ArrayList<ArrayList<Room>> matrixRooms = new ArrayList<>();

        ArrayList<Room> firstRow = new ArrayList<>();
        Room room1 = new Room("1", item, tiger);
        Room room2 = new Room("2", item, tiger);
        Room room3 = new Room("3", item, tiger);
        firstRow.add(room1);
        firstRow.add(room2);
        firstRow.add(room3);
        matrixRooms.add(0, firstRow);

        List<Animal> lions = new ArrayList<>(zooController.getAllAnimalsForSpecies(Lion.class));
        ArrayList<Room> secondRow = new ArrayList<>();
        Room room4 = new Room("4", item, lions);
        Room room5 = new Room("5", item, lions);
        Room room6 = new Room("6", item, lions);
        secondRow.add(room4);
        secondRow.add(room5);
        secondRow.add(room6);
        matrixRooms.add(1, secondRow);

        List<Animal> eagles = new ArrayList<>(zooController.getAllAnimalsForSpecies(Eagle.class));
        ArrayList<Room> thirdRow = new ArrayList<>();
        Room room7 = new Room("7", item, eagles);
        Room room8 = new Room("8", item, eagles);
        Room room9 = new Room("9", item, eagles);
        thirdRow.add(room7);
        thirdRow.add(room8);
        thirdRow.add(room9);
        matrixRooms.add(2, thirdRow);

        for (int i = 0; i < matrixRooms.size(); i++) {
            ArrayList<Room> row = matrixRooms.get(i);
            for (int j = 0; j < row.size(); j++)
                System.out.print(row.get(j).getName() + " ");
            System.out.println();
        }
    }
}
