package Domain.GameDomain;

import Domain.AnimalDomain.Animal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Room {
    private String name;
    private List<Item> items;
    private List<Animal> animals;

    public void showRoomInformation(){
        System.out.println("You are in: " + name);
        System.out.println("\nItems present in room: " + items.stream().filter(Objects::nonNull).map(item -> item.getName() + " (x" + item.getQuantity() + ")").toList());
        System.out.println("NPC: " + animals.stream().filter(Objects::nonNull).map(animal -> animal.getName() + " (" + animal.getClass().getSimpleName() + ")").toList() + "\n");
    }
}
