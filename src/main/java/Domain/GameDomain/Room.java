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
    private EnumMap<Direction, Room> adjacentRoom;

    public Room(String name, List<Item> items, List<Animal> animals) {
        this.name = name;
        this.items = items;
        this.animals = animals;
        this.adjacentRoom = new EnumMap<>(Direction.class);
    }
    public void showRoomInformation(){
        System.out.println("You are in: " + name);
        System.out.println("Items present in room: " + items.stream().filter(Objects::nonNull).map(item -> item.getName() + " (x" + item.getQuantity() + ")").toList());
        System.out.println("NPC: " + animals.stream().filter(Objects::nonNull).map(animal -> animal.getName() + " (" + animal.getClass().getSimpleName() + ")").toList());
    }
    public void addItem(Item item){
        items.add(item);
    }
    public void dropItem(Item item){
        items.remove(item);
    }
    public void fillingMap(Direction direction, Room room) {
        adjacentRoom.put(direction, room);
    }
    public Room getAdjacentRoom(Direction direction) {
        return adjacentRoom.get(direction);
    }
    public void nearbyRoom(){
        for (Direction d: Direction.values()) {
            if(this.getAdjacentRoom(d)!= null){
                System.out.println("You can move at direction "+d.name().toLowerCase() +" to "+getAdjacentRoom(d).getName()+" ");
            }else System.out.print("");
        }
    }
}
