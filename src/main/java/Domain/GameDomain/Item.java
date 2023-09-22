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
        this.slotRequired = slotRequired;
        this.quantity = 1;
    }

    public void setQuantity(int quantity){
        if(quantity>= 1){
            this.quantity = quantity;
        } else{
            System.out.println("The quantity cannot be negative");
        }
    }
    public void increaseTheQuantity(){
        quantity++;
    }
    public void decreaseTheQuantity(){
        quantity--;
    }
    @Override
    public String toString() {
        return  "\n-" + name
                +", description='" + description
                +", slotRequired=" + slotRequired
                +", quantity= (" + quantity + ")";
    }
}
