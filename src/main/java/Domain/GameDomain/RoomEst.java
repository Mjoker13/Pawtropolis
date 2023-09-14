package Domain.GameDomain;

import Domain.AnimalDomain.Animal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
public class RoomEst extends Room{
    private final String roomName= "Est";
    public RoomEst(List<Item> itemPresent, List<Class<? extends Animal>> animals) {
        super(itemPresent, animals);
    }

}
