package GameDomain;

import Domain.AnimalDomain.Animal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Setter
@Getter
@ToString
public class RoomNord extends Room{
    private String roomName= "Nord";
    public RoomNord(List<Item> itemPresent, List<Class<? extends Animal>> animals) {
        super(itemPresent, animals);
    }
}
