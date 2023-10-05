package Domain.GameDomain;

import Domain.AnimalDomain.Animal;
import GameControls.Direction;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;

import java.util.*;
@Log
@Getter
@Setter
@ToString
public class Room {
    private String name;
    private List<Item> items;
    private List<Animal> animals;
    private EnumMap<Direction, Room> adjacentRooms;

    public Room(String name, List<Item> items, List<Animal> animals) {
        this.name = name;
        this.items = Objects.requireNonNullElseGet(items, ArrayList::new);
        this.animals = Objects.requireNonNullElseGet(animals, ArrayList::new);
        this.adjacentRooms = new EnumMap<>(Direction.class);
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
    public void linkRoomByDirection(Direction direction,Room adjacentRoom,Room actualRoom) {
        adjacentRooms.put(direction, adjacentRoom);
        adjacentRoom.linkAdjacentRoomToActualRoom(direction,actualRoom);
    }
    private void linkAdjacentRoomToActualRoom(Direction direction, Room actualRoom){
        adjacentRooms.put(Direction.roundTrip(direction), actualRoom);
    }
    public Room getAdjacentRooms(Direction direction) {
        return adjacentRooms.get(direction);
    }
    public void showNearbyRoom(){
        for (Direction d: Direction.values()) {
            if(this.getAdjacentRooms(d)!= null){
                System.out.println("You can move at direction "+d.name().toLowerCase() +" to "+ getAdjacentRooms(d).getName()+" ");
            }else System.out.print("");
        }
    }
    public Item getItemFromRoom(String itemName){
        return  items.stream()
                .filter(item -> item.getName().replaceAll("\\s+","").equalsIgnoreCase(itemName))
                .findFirst().orElse(null);
    }
}
