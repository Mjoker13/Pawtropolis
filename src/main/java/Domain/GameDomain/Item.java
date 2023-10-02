package Domain.GameDomain;

import lombok.Getter;


@Getter
public class Item {
    private final String name;
    private final String description;
    private final int slotRequired;
    private int quantity;

    public Item(String name, String description, int slotRequired) {
        this.name = name;
        this.description = description;
        if (slotRequired < 20) {
            this.slotRequired = slotRequired;
        } else throw new RuntimeException("The slot required cannot overcome 20.");
        this.quantity = 1;
    }
    public void increaseQuantity(){
        this.quantity ++;

    }
    public void decreaseQuantity(){
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
