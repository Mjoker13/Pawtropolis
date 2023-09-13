package GameDomain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.Domain.Animal;

import java.util.List;

@ToString
@Getter
@Setter
public class RoomSud extends Room{
    private final String roomName= "Sud";
    public RoomSud(List<Item> itemPresent, List<Class<? extends Animal>> animals) {
        super(itemPresent, animals);
    }
}
