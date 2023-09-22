package Domain.GameDomain;

import Domain.AnimalDomain.Animal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Room {
    private String name;
    private List<Item> itemsPresentInRoom;
    private List<Animal> animals;

    public void addItemsToRoom(@NotNull Item item) {
        if(itemsPresentInRoom.contains(item)){
            item.increaseTheQuantity();
        }else {
            this.itemsPresentInRoom.add(item);
        }
        }
    public void removeItemsToRoom(@NotNull Item item) {
        if(itemsPresentInRoom.contains(item) && item.getQuantity()>1){
            item.decreaseTheQuantity();
        } else {
            this.itemsPresentInRoom.remove(item);
        }
    }
}
