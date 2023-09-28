package Domain.GameDomain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@ToString
@Log
public class Bag {
    //todo non dare a nessuno la gestione dei propri attributi
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

    //todo sistemare getter e setter

    public void showItemsInformation(){
        System.out.println("In bag: " + items.stream().filter(Objects::nonNull).map(item -> item.getName() + " (x" + item.getQuantity() + ")").toList());
        System.out.println("Slot available:" + slotAvailable);
    }
}
