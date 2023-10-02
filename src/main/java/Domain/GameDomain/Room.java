package Domain.GameDomain;

import Domain.AnimalDomain.Animal;
import GameControls.Direction;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
@Setter
@ToString
public class Room {
    private String name;
    private List<Item> items;
    private List<Animal> animals;
    private Map<Direction, Room> adjacentRoom;


    public Room(String name, List<Item> items, List<Animal> animals) {
        this.name = name;
        this.items = items;
        this.animals = animals;
        this.adjacentRoom = new HashMap();
    }
    public void showRoomInformation(){
        System.out.println("You are in: " + name);
        System.out.println("\nItems present in room: " + items.stream().filter(Objects::nonNull).map(item -> item.getName() + " (x" + item.getQuantity() + ")").toList());
        System.out.println("NPC: " + animals.stream().filter(Objects::nonNull).map(animal -> animal.getName() + " (" + animal.getClass().getSimpleName() + ")").toList() + "\n");
    }
    public void addItem(Item item){
        items.add(item);
    }
    public void dropItem(Item item){
        items.remove(item);
    }

    public void connectRoom(Direction direction, Room room) {
        adjacentRoom.put(direction, room);
    }

    public Room getAdjacentRoom(Direction direction) {
        return adjacentRoom.get(direction);
    }





}
