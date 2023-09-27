package Domain.GameDomain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;


@Setter
@Getter
@ToString
@Log
public class Player {
    private String name;
    private int lifePoints;
    private Bag bag;

    public Player(String name, Bag bag) {
        this.name = name;
        this.lifePoints = 100;
        this.bag = bag;
    }
}
