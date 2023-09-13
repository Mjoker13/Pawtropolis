package GameDomain;

import org.Domain.Animal;

import java.util.List;

public class RoomEst extends Room{
    public RoomEst(String name, List<Item> itemPresent, List<Class<? extends Animal>> animals) {
        super(name, itemPresent, animals);
    }
}
