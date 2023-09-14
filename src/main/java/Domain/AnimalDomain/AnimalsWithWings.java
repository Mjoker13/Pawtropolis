package Domain.AnimalDomain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public abstract class AnimalsWithWings extends Animal {

    private float wingspan;
    protected AnimalsWithWings(String name, String favoriteFood, int age, LocalDate entryDate, float weight, float height, float wingspan) {
        super(name, favoriteFood, age, entryDate, weight, height);
        this.wingspan = wingspan;
    }
}
