package Domain.GameDomain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@ToString
@Log
public class Bag {
    private List<Item> itemsInBag;
    private int slotAvailable;
    private final int maxCapacity;

    public Bag() {
        this.itemsInBag = new ArrayList<>();
        this.slotAvailable = getSlotAvailable();
        this.maxCapacity = getMaxCapacity();
    }

    public int getSlotAvailable(){
        if(itemsInBag.isEmpty()){
            return getMaxCapacity();
        }
        for (Item item:itemsInBag) {
            slotAvailable-=item.getSlotRequired();
        }
        return slotAvailable;
    }
    public int getMaxCapacity() {
        return 20;
    }
    public void addItemsToBag(@NotNull Item item) {
        if(slotAvailable>item.getSlotRequired()){
            getItemsInBag().add(item);
        }else{
            log.info("Maximum capacity exceeded");
        }
    }
    public void removeItemsToBag(@NotNull Item item) {
        if(maxCapacity >= (slotAvailable+item.getSlotRequired())){
            this.itemsInBag.remove(item);
            this.slotAvailable+=item.getSlotRequired();
        }else{
            log.info("You cannot exceed the maximum capacity");
        }
    }
}
