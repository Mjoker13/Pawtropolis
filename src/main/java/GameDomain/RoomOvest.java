package GameDomain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.Domain.Animal;

import java.util.List;

@Getter
@Setter
@ToString
public class RoomOvest extends Room {
    private final String roomName= "Ovest";
    public RoomOvest(List<Item> itemPresent, List<Class<? extends Animal>> animals) {
        super(itemPresent, animals);
    }
}
