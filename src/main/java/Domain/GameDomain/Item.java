package Domain.GameDomain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Item {
    private String name;
    private String description;
    private int slotRequired;
    private int quantity;

    public Item(String name, String description, int slotRequired) {
        this.name = name;
        this.description = description;
        if (slotRequired < 20) {
            this.slotRequired = slotRequired;
        } else throw new RuntimeException("The slot required cannot overcome 20.");
        this.quantity = 1;
    }
    public void increaseTheQuantity(){
        this.quantity ++;

    }
    public void decreaseTheQuantity(){
        this.quantity --;
    }
    @Override
    public String toString() {
        return  "\n-" + name
                +", description='" + description
                +", slotRequired=" + slotRequired
                +", quantity= x" + quantity;
    }
}
