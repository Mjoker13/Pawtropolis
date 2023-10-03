package Domain.GameDomain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@ToString
@Log
public class Bag {
    @Setter
    private List<Item> items;
    private int slotAvailable;
    private final int maxCapacity;

    public Bag() {
        this.items = new ArrayList<>();
        this.slotAvailable = getSlotAvailable();
        this.maxCapacity = getMaxCapacity();
    }
    public void decreaseSlotAvailable(@NotNull Item item){
        slotAvailable+=item.getSlotRequired();
    }
    public void increaseSlotAvailable(@NotNull Item item){
        slotAvailable-=item.getSlotRequired();
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
    public void showItemsInformation(){
        System.out.println("In bag: " + items.stream().filter(Objects::nonNull).map(item -> item.getName() + " (x" + item.getQuantity() + ")").toList());
        System.out.println("Slot available:" + slotAvailable);
    }
    public void addItem(@NotNull Item item){
       // Item itemQuantity = new Item(item.getName(),item.getDescription(),item.getSlotRequired());
        if (slotAvailable >= item.getSlotRequired()) {
                    if(items.contains(item)){
                      item.increaseQuantity();
                     }else{
                      items.add(item);
                    }
                     increaseSlotAvailable(item);
                } else {
                log.info("Maximum capacity exceeded");
            }
    }
    public void dropItem(Item item){
            items.remove(item);
            decreaseSlotAvailable(item);
    }
    public Item getItemFromBag(String itemName){
        return items.stream()
                .filter(i-> i.getName().replaceAll("\\s+","").equalsIgnoreCase(itemName))
                .findFirst().orElse(null);
    }
    }

