package Domain.GameDomain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;

@AllArgsConstructor
@Setter
@Getter
@ToString
@Log
public class Player {
    private String name;
    private int lifePoints;
    private Bag bag;

    public int getLifePoints() {
        return 100;
    }
}
