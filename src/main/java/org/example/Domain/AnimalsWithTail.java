package org.example.Domain;

import java.time.LocalDate;
import java.util.Objects;

public abstract class  AnimalsWithTail extends Animal {
    private float tailLength;
    protected AnimalsWithTail(String name, String favoriteFood, int age, LocalDate entryDate, float weight, float height, float tailLength) {
        super(name, favoriteFood, age, entryDate, weight, height);
        this.tailLength = tailLength;
    }
    public float getTailLength() {
        return tailLength;
    }
    public void setTailLength(float tailLength) {
        this.tailLength = tailLength;
    }

    @Override
    public String toString() {
        return "AnimalsWithTail{" +
                "name='" + super.getName() + '\'' +
                ", favoriteFood='" + super.getFavoriteFood() + '\'' +
                ", age=" + super.getAge() +
                ", entryDate=" + super.getEntryDate() +
                ", weight=" + super.getWeight() +
                ", height=" + super.getHeight() +
                "tailLength=" + tailLength +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnimalsWithTail that)) return false;
        if (!super.equals(o)) return false;
        return Float.compare(getTailLength(), that.getTailLength()) == 0;
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTailLength());
    }
}
