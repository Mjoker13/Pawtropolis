package GameDomain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Bag {
    private Map<Item, String> itemList;
    private int slotAvailable;
}
