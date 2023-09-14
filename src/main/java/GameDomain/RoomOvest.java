package GameDomain;

import Domain.AnimalDomain.Animal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
