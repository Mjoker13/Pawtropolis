package GameDomain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.Domain.Animal;

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
