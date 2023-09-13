package GameDomain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Direction {

    NORD("nord"),
    SUD("sud"),
    EST("est"),
    OVEST("ovest");

    private final String value;
}
