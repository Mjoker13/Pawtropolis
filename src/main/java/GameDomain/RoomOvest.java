package GameDomain;

import org.Domain.Animal;

import java.util.List;

public class RoomOvest extends Room {
    public RoomOvest(String name, List<Item> itemPresent, List<Class<? extends Animal>> animals) {
        super(name, itemPresent, animals);
    }
}
