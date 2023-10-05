package Domain.GameDomain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;

@Setter
@Getter
@ToString
@Log
public class Player {
    private String name;
    private final int lifePoints;
    private Bag bag;

    public Player(String name, Bag bag) {
        this.name = name;
        this.lifePoints = 100;
        this.bag = bag;
    }

    public void showBagInformation() {
        bag.showItemsInformation();
    }

    public void addItemToBag(Item item) {
        bag.addItem(item);
    }

    public void dropItemFromBag(Item item) {
        bag.dropItem(item);
    }

    public Item getItemFromBag(String itemName) {
        return bag.getItemFromBag(itemName);
    }
}
