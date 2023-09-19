package Controller;

import Domain.AnimalDomain.Animal;
import Domain.AnimalDomain.Eagle;
import Domain.AnimalDomain.Lion;
import Domain.AnimalDomain.Tiger;
import Domain.GameDomain.Bag;
import Domain.GameDomain.Item;
import Domain.GameDomain.Player;
import Domain.GameDomain.Room;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameCreator {
    ZooController zooController= new ZooController();
    public List<ArrayList<Room>> createRooms() {
        ArrayList<ArrayList<Room>> matrixRooms = new ArrayList<>();

        ArrayList<Room> firstRow = new ArrayList<>();
        Room roomA1 = new Room("A1", getRandomItem(), getRandomAnimals());
        Room roomA2 = new Room("A2", getRandomItem(), getRandomAnimals());
        Room roomA3 = new Room("A3", getRandomItem(), getRandomAnimals());
        Room roomA4 = new Room("A4", getRandomItem(), getRandomAnimals());
        Room roomA5 = new Room("A5", getRandomItem(), getRandomAnimals());

        firstRow.add(roomA1);
        firstRow.add(roomA2);
        firstRow.add(roomA3);
        firstRow.add(roomA4);
        firstRow.add(roomA5);
        matrixRooms.add(0, firstRow);

        ArrayList<Room> secondRow = new ArrayList<>();
        Room roomB1 = new Room("B1", getRandomItem(), getRandomAnimals());
        Room roomB2 = new Room("B2", getRandomItem(), getRandomAnimals());
        Room roomB3 = new Room("B3", getRandomItem(), getRandomAnimals());
        Room roomB4 = new Room("B4", getRandomItem(), getRandomAnimals());
        Room roomB5 = new Room("B5", getRandomItem(), getRandomAnimals());
        secondRow.add(roomB1);
        secondRow.add(roomB2);
        secondRow.add(roomB3);
        secondRow.add(roomB4);
        secondRow.add(roomB5);
        matrixRooms.add(1, secondRow);

        ArrayList<Room> thirdRow = new ArrayList<>();
        Room roomC1 = new Room("C1", getRandomItem(), getRandomAnimals());
        Room roomC2 = new Room("C2", getRandomItem(), getRandomAnimals());
        Room roomC3 = new Room("C3", getRandomItem(), getRandomAnimals());
        Room roomC4 = new Room("C4", getRandomItem(), getRandomAnimals());
        Room roomC5 = new Room("C5", getRandomItem(), getRandomAnimals());
        thirdRow.add(roomC1);
        thirdRow.add(roomC2);
        thirdRow.add(roomC3);
        thirdRow.add(roomC4);
        thirdRow.add(roomC5);
        matrixRooms.add(2, thirdRow);

        ArrayList<Room> fourthRow = new ArrayList<>();
        Room roomD1 = new Room("D1", getRandomItem(), getRandomAnimals());
        Room roomD2 = new Room("D2", getRandomItem(), getRandomAnimals());
        Room roomD3 = new Room("D3", getRandomItem(), getRandomAnimals());
        Room roomfD4 = new Room("D4", getRandomItem(), getRandomAnimals());
        Room roomfD5 = new Room("D5", getRandomItem(), getRandomAnimals());
        fourthRow.add(roomD1);
        fourthRow.add(roomD2);
        fourthRow.add(roomD3);
        fourthRow.add(roomfD4);
        fourthRow.add(roomfD5);
        matrixRooms.add(3,fourthRow);

        ArrayList<Room> fifthRow = new ArrayList<>();
        Room roomE1 = new Room("E1", getRandomItem(), getRandomAnimals());
        Room roomE2 = new Room("E2", getRandomItem(), getRandomAnimals());
        Room roomE3 = new Room("E3", getRandomItem(), getRandomAnimals());
        Room roomqE4 = new Room("E4", getRandomItem(), getRandomAnimals());
        Room roomE5 = new Room("E5", getRandomItem(), getRandomAnimals());
        fifthRow.add(roomE1);
        fifthRow.add(roomE2);
        fifthRow.add(roomE3);
        fifthRow.add(roomqE4);
        fifthRow.add(roomE5);


        matrixRooms.add(4, fifthRow);

        return matrixRooms;
    }
    public List<Room> getAllRooms(){
        Stream<ArrayList<Room>> streamArrayRoom = createRooms().stream();
        Stream<Room> streamRoom = streamArrayRoom.flatMap(List::stream);
        return streamRoom.map(Room.class::cast).collect(Collectors.toList());
    }
    public List<Item> createItem(){
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
        return itemList;
    }
    public Bag createBag(){
        List<Item> itemList = getRandomItem();
        int slotAvailable=20;
        if(createItem().isEmpty()){
            return null;
        }
        for (Item item: itemList) {
            slotAvailable -= item.getSlotRequired();
        }
        return new Bag(itemList,slotAvailable);
    }
    public Player createPlayer(){
        if(getAllRooms().isEmpty() || createBag()== null){
            return null;
        }
        return new Player("Lego",100,getAllRooms().get(4),createBag());
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
    private @NotNull List<Item> getRandomItem(){
        Random random = new Random();
        int randomIndex = random.nextInt(createItem().size());
        int randomIndex2 = random.nextInt(createItem().size());
        int randomIndex3 = random.nextInt(createItem().size());
        List<Item> randomItem = new ArrayList<>();
        if(randomIndex != randomIndex2 && randomIndex3 != randomIndex) {
            randomItem.add(createItem().get(randomIndex));
            randomItem.add(createItem().get(randomIndex2));
            randomItem.add(createItem().get(randomIndex3));
        } else if (randomIndex == randomIndex2 && randomIndex3 != randomIndex) {
            randomItem.add(createItem().get(randomIndex));
            randomItem.add(createItem().get(randomIndex3));
        }
        return randomItem;
    }
    private @NotNull List<Animal> getRandomAnimals(){
        Random random = new Random();
        int randomIndex = random.nextInt(10);
        int randomIndex2 = random.nextInt(10);
        List<Animal> randomItem = new ArrayList<>();
        if(randomIndex != randomIndex2) {
            randomItem.add(zooController.getAllAnimalsForSpecies(Animal.class).get(randomIndex));
            randomItem.add(zooController.getAllAnimalsForSpecies(Animal.class).get(randomIndex2));
        }else{
            randomItem.add(zooController.getAllAnimalsForSpecies(Animal.class).get(randomIndex));
        }
        return randomItem;
    } // da sistemare
}
