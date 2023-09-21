package Domain.GameDomain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;

@AllArgsConstructor
@Setter
@Getter
@ToString
@Log
public class Player {
    private String name;
    private int lifePoints;
    private Room actuallyRoom;
    private Bag bag;

    public int getLifePoints() {
        return 100;
    }
    public void addItemToBagAndDropItemToRoom(Item item){
        if(item != null) {
            bag.addItemsToBag(item);
            actuallyRoom.removeItemsToRoom(item);
        }else{
            log.info("Item not present in the room");
        }
    }
    public void addItemToRoomAndDropItemToBag(Item item){
        if(item!=null) {
            bag.removeItemsToBag(item);
            actuallyRoom.addItemsToRoom(item);
        }else{
            log.info("Item not present in the bag");
        }
    }
    public Item getItemInRoom(String s){
        return  getActuallyRoom().getItemsPresentInRoom()
                .stream()
                .filter(item -> item.getName().equalsIgnoreCase(s))
                .findFirst().orElse(null);
    }
    public Item getItemInBag(String s){
        return getBag().getItemsInBag().stream()
                .filter(i-> i.getName().equalsIgnoreCase(s))
                .findFirst().orElse(null);
    }
}
