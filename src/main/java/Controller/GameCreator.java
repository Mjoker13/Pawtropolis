package Controller;

import Domain.AnimalDomain.Animal;
import Domain.AnimalDomain.Eagle;
import Domain.AnimalDomain.Lion;
import Domain.AnimalDomain.Tiger;
import Domain.GameDomain.Item;
import Domain.GameDomain.Room;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class GameCreator {
    ZooController zooController= new ZooController();

    public List<ArrayList<Room>> createRooms() {

        List<Animal> tiger = new ArrayList<>(zooController.getAllAnimalsForSpecies(Tiger.class));
        ArrayList<ArrayList<Room>> matrixRooms = new ArrayList<>();

        ArrayList<Room> firstRow = new ArrayList<>();
        Room room1 = new Room("1", createItem(), tiger);
        Room room2 = new Room("2", createItem(), tiger);
        Room room3 = new Room("3", createItem(), tiger);
        firstRow.add(room1);
        firstRow.add(room2);
        firstRow.add(room3);
        matrixRooms.add(0, firstRow);

        List<Animal> lions = new ArrayList<>(zooController.getAllAnimalsForSpecies(Lion.class));
        ArrayList<Room> secondRow = new ArrayList<>();
        Room room4 = new Room("4", createItem(), lions);
        Room roomHome = new Room("Home", createItem(), lions);
        Room room6 = new Room("6", createItem(), lions);
        secondRow.add(room4);
        secondRow.add(roomHome);
        secondRow.add(room6);
        matrixRooms.add(1, secondRow);

        List<Animal> eagles = new ArrayList<>(zooController.getAllAnimalsForSpecies(Eagle.class));
        ArrayList<Room> thirdRow = new ArrayList<>();
        Room room7 = new Room("7", createItem(), eagles);
        Room room8 = new Room("8", createItem(), eagles);
        Room room9 = new Room("9", createItem(), eagles);
        thirdRow.add(room7);
        thirdRow.add(room8);
        thirdRow.add(room9);
        matrixRooms.add(2, thirdRow);

        return matrixRooms;
    }
    public void getAllRooms(){
        Stream<ArrayList<Room>> streamArrayRoom = createRooms().stream();
        Stream<Room> streamRoom = streamArrayRoom.flatMap(List::stream);
        streamRoom.map(Room::getName).forEach(System.out::println);
    }
    public List<Item> createItem(){
        List<Item> itemList= new ArrayList<>();
        Item hammer = new Item("Hammer","Use it to break things",3);
        Item water = new Item("Water","Use it to quench your thirst",1);
        Item knife = new Item("Knife","use it to spread the Nutella",2);
        Item banana = new Item("Banana","Give it to the animals",1);
        Item apple = new Item("Apple","Give it to the animals",1);
        Item cane = new Item("Cane","Relax with animals",2);

        itemList.add(hammer);
        itemList.add(water);
        itemList.add(knife);
        itemList.add(banana);
        itemList.add(apple);
        itemList.add(cane);

        return itemList;
    }
    public static @NotNull Map<Class<? extends Animal>, List<Animal>> createAnimals() {

        Map<Class<? extends Animal>, List<Animal>> animals = new HashMap<>();

        LocalDate dateSherkan = LocalDate.of(2012, 8, 20);
        LocalDate dateTigro = LocalDate.of(2018, 12, 02);
        LocalDate dateOscar = LocalDate.of(2005, 5, 12);
        Tiger oscar = new Tiger("Oscar", "rubbit", 23, dateOscar, 82.5F, 95, 25);
        Tiger sherkan = new Tiger("Sherkan", "man", 13, dateSherkan, 78.5F, 96, 22);
        Tiger tigro = new Tiger("Tigro", "honey", 8, dateTigro, 86.5F, 95, 30);
        Tiger iris = new Tiger("Iris", "gazelles", 8, dateTigro, 82.5F, 89, 45);

        LocalDate dateSimba = LocalDate.of(1994, 8, 03);
        LocalDate dateAlex = LocalDate.of(1982, 10, 05);
        Lion simba = new Lion("Simba", "insect", 12, dateSimba, 85, 120, 35);
        Lion alex = new Lion("Alex", "gazelles", 18, dateAlex, 87, 115.0F, 28);
        Lion nala = new Lion("Nala", "gazelles", 15, dateAlex, 82, 108, 49);

        LocalDate dateOlimpia = LocalDate.of(2008, 9, 13);
        LocalDate dateBianca = LocalDate.of(2000, 3, 22);
        Eagle olimpia = new Eagle("Olimpia", "fish", 22, dateOlimpia, 20, 70, 90);
        Eagle bianca = new Eagle("Bianca", "rubbit", 18, dateBianca, 26, 68, 116);
        Eagle gigi = new Eagle("Gigi", "rubbit", 15, dateBianca, 25, 62, 98.05F);
        Eagle teresa = new Eagle("Teresa", "rubbit", 15, dateOlimpia, 30, 82, 108.9F);

        List<Animal> tigers= new ArrayList<>();
        tigers.add(oscar);
        tigers.add(tigro);
        tigers.add(sherkan);
        tigers.add(iris);
        animals.put(Tiger.class,tigers);

        List<Animal> lions = new ArrayList<>();
        lions.add(simba);
        lions.add(nala);
        lions.add(alex);
        animals.put(Lion.class,lions);

        List<Animal> eagles = new ArrayList<>();
        eagles.add(olimpia);
        eagles.add(bianca);
        eagles.add(gigi);
        eagles.add(teresa);
        animals.put(Eagle.class,eagles);

        return animals;
    }

}
