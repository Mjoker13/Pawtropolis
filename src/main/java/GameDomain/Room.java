package GameDomain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.Domain.Animal;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Room {

    private String name;
    private Map<Item, List<Item>> itemPresent;
    private Map<Class<? extends Animal>, List<Animal>> animals;
    private List<RoomsCoordinates> roomDirection;

}
