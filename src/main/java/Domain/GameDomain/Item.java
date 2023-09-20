package Domain.GameDomain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Item {
    private String name;
    private String description;
    private int slotRequired;

    @Override
    public String toString() {
        return  "\n-" + name
                +", description='" + description
                +", slotRequired=" + slotRequired;
    }
}
