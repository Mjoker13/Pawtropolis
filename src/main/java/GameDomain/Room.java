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
public abstract class Room {

    private List<Item> itemPresent;
    private List<Class<? extends Animal>> animals;
   // private RoomsCoordinates roomDirection;

}
