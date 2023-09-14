package Domain.GameDomain;

import Domain.AnimalDomain.Animal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public abstract class Room {

    private List<Item> itemPresent;
    private List<Class<? extends Animal>> animals;
   // private RoomsCoordinates roomDirection;

}
