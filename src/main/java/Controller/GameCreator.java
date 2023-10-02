package Controller;

import Domain.AnimalDomain.Animal;
import Domain.AnimalDomain.Eagle;
import Domain.AnimalDomain.Lion;
import Domain.AnimalDomain.Tiger;
import Domain.GameDomain.Bag;
import Domain.GameDomain.Item;
import Domain.GameDomain.Player;
import Domain.GameDomain.Room;
import GameControls.Direction;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameCreator {
    ZooController zooController= new ZooController();
    Random random = new Random();

    public List<Room> createRooms() {
        List<Room> rooms = new ArrayList<>();

        Room roomA1 = new Room("A1", getRandomItems(), getRandomAnimals());
        Room roomA2 = new Room("A2", getRandomItems(), getRandomAnimals());
        Room roomA3 = new Room("A3", getRandomItems(), getRandomAnimals());
        Room roomA4 = new Room("A4", getRandomItems(), getRandomAnimals());
        Room roomA5 = new Room("A5", getRandomItems(), getRandomAnimals());

        Room roomB1 = new Room("B1", getRandomItems(), getRandomAnimals());
        Room roomB2 = new Room("B2", getRandomItems(), getRandomAnimals());
        Room roomB3 = new Room("B3", getRandomItems(), getRandomAnimals());
        Room roomB4 = new Room("B4", getRandomItems(), getRandomAnimals());
        Room roomB5 = new Room("B5", getRandomItems(), getRandomAnimals());

        rooms.add(roomA1);
        rooms.add(roomA2);
        rooms.add(roomA3);
        rooms.add(roomA4);
        rooms.add(roomA5);
        rooms.add(roomB1);
        rooms.add(roomB2);
        rooms.add(roomB3);
        rooms.add(roomB4);
        rooms.add(roomB5);

        roomA1.connectRoom(Direction.SOUTH, roomA2);
        roomA1.connectRoom(Direction.EAST,roomB5);
        roomA1.connectRoom(Direction.WEST,roomB1);
        roomB1.connectRoom(Direction.WEST, roomA1);
        roomB1.connectRoom(Direction.NORTH,roomB2);
        roomB2.connectRoom(Direction.EAST,roomB1);
        roomB2.connectRoom(Direction.SOUTH,roomA3);
        roomA3.connectRoom(Direction.WEST,roomB2);
        roomA3.connectRoom(Direction.NORTH,roomA2);
        roomA3.connectRoom(Direction.EAST,roomA4);
        roomA4.connectRoom(Direction.SOUTH,roomA3);
        roomA4.connectRoom(Direction.NORTH,roomB4);
        roomB4.connectRoom(Direction.SOUTH,roomA4);
        roomB4.connectRoom(Direction.WEST,roomB3);
        roomB3.connectRoom(Direction.EAST,roomB4);
        roomA2.connectRoom(Direction.NORTH,roomA1);
        roomA2.connectRoom(Direction.SOUTH,roomA3);
        roomA2.connectRoom(Direction.EAST,roomA5);
        roomA5.connectRoom(Direction.WEST,roomA2);
        roomB5.connectRoom(Direction.EAST,roomA1);
        return rooms;


    }
    public List<Room> getAllRooms(){
        Stream<Room> streamArrayRooms = createRooms().stream();
        return streamArrayRooms.map(Room.class::cast).collect(Collectors.toList());
    }
    public int randomRoom(){

        return random.nextInt(9);
    }
    public List<Item> createItems(){
        List<Item> itemList= new ArrayList<>();
        Item hammer = new Item("Hammer","Use it to break things",3);
        Item water = new Item("Water","Use it to quench your thirst",2);
        Item knife = new Item("Knife","use it to spread the Nutella",2);
        Item banana = new Item("Banana","Give it to the animals",1);
        Item apple = new Item("Apple","Give it to the animals",1);
        Item cane = new Item("Cane","Relax with animals",1);
        Item gas = new Item("Gas","Drink to suicide",1);
        Item nutella = new Item("Nutella","Paradise's moment",2);
        Item screwdriver = new Item("Screwdriver","To be",2);
        Item chainsaw = new Item("Chainsaw","Cut all",4);
        Item electricChair = new Item("Electric chair","use for cook the chicken",4);
        Item chicken = new Item("Chicken","Cook it with the electric chair",4);
        Item oldBread = new Item("Old bread","It cuts with chainsaw",4);
        itemList.add(hammer);
        itemList.add(water);
        itemList.add(knife);
        itemList.add(banana);
        itemList.add(apple);
        itemList.add(cane);
        itemList.add(gas);
        itemList.add(nutella);
        itemList.add(screwdriver);
        itemList.add(chainsaw);
        itemList.add(electricChair);
        itemList.add(chicken);
        itemList.add(oldBread);
        return itemList;
    }
    public Bag createBag(){
         return new Bag();
    }
    public Player createPlayer(){
        if(getAllRooms().isEmpty() || createBag()== null){
            return null;
        }
        return new Player("Lego",createBag());
    }
    public static @NotNull Map<Class<? extends Animal>, List<Animal>> createAnimals() {

        Map<Class<? extends Animal>, List<Animal>> animals = new HashMap<>();

        LocalDate dateSherkan = LocalDate.of(2012, 8, 20);
        LocalDate dateTigro = LocalDate.of(2018, 12, 2);
        LocalDate dateOscar = LocalDate.of(2005, 5, 12);
        Tiger oscar = new Tiger("Oscar", "rubbit", 23, dateOscar, 82.5F, 95, 25);
        Tiger sherkan = new Tiger("Sherkan", "man", 13, dateSherkan, 78.5F, 96, 22);
        Tiger tigro = new Tiger("Tigro", "honey", 8, dateTigro, 86.5F, 95, 30);
        Tiger iris = new Tiger("Iris", "gazelles", 8, dateTigro, 82.5F, 89, 45);

        LocalDate dateSimba = LocalDate.of(1994, 8, 3);
        LocalDate dateAlex = LocalDate.of(1982, 10, 5);
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
    private @NotNull List<Item> getRandomItems(){
        int randomIndex = random.nextInt(createItems().size());
        int randomIndex2 = random.nextInt(createItems().size());
        int randomIndex3 = random.nextInt(createItems().size());
        List<Item> randomItems = new ArrayList<>();
            if (randomIndex != randomIndex2 && randomIndex3 != randomIndex) {
                randomItems.add(createItems().get(randomIndex));
                randomItems.add(createItems().get(randomIndex2));
                randomItems.add(createItems().get(randomIndex3));
            } else if (randomIndex == randomIndex2 && randomIndex3 != randomIndex) {
                randomItems.add(createItems().get(randomIndex));
                randomItems.add(createItems().get(randomIndex3));
            } else if (randomIndex2 != randomIndex) {
                randomItems.add(createItems().get(randomIndex2));
                randomItems.add(createItems().get(randomIndex));
            }else {
                randomItems.add(createItems().get(randomIndex3));
                randomItems.add(createItems().get(randomIndex));
            }
        return randomItems;
    }
    private @NotNull List<Animal> getRandomAnimals(){
        int randomIndex = random.nextInt(createAnimals().values().stream().mapToInt(List::size).sum());
        int randomIndex2 = random.nextInt(createAnimals().values().stream().mapToInt(List::size).sum());
        List<Animal> randomAnimals = new ArrayList<>();
        if(randomIndex != randomIndex2) {
            randomAnimals.add(zooController.getAllAnimalsForSpecies(Animal.class).get(randomIndex));
            randomAnimals.add(zooController.getAllAnimalsForSpecies(Animal.class).get(randomIndex2));
        }else{
            randomAnimals.add(zooController.getAllAnimalsForSpecies(Animal.class).get(randomIndex));
        }
        return randomAnimals;
    }

}
