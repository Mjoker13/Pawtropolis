package GameDomain;

import lombok.Getter;
import lombok.Setter;
import org.Domain.Animal;

import java.util.List;
@Getter
@Setter
public class RoomNord extends Room{
    public RoomNord(String name, List<Item> itemPresent, List<Class<? extends Animal>> animals) {
        super(name, itemPresent, animals);
    }
}
