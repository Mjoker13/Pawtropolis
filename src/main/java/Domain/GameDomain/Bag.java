package Domain.GameDomain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@Log
public class Bag {
    private List<Item> items;
    private int slotAvailable;
    private final int maxCapacity;

    public Bag() {
        this.items = new ArrayList<>();
        this.slotAvailable = getSlotAvailable();
        this.maxCapacity = getMaxCapacity();
    }
    public int getSlotAvailable(){
        if(items.isEmpty()){
            return getMaxCapacity();
        }
        return slotAvailable;
    }
    public int getMaxCapacity() {
        return 20;
    }

}
