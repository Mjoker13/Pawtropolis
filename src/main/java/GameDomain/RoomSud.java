package GameDomain;

import org.Domain.Animal;

import java.util.List;

public class RoomSud extends Room{
    public RoomSud(String name, List<Item> itemPresent, List<Class<? extends Animal>> animals) {
        super(name, itemPresent, animals);
    }
}
