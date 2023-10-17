package com.example.pawtropolis.Domain.GameDomain;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
public class Item {
    private final String name;
    private final String description;
    private final int slotRequired;
    @Setter
    private int quantity;

    public Item(String name, String description, int slotRequired) {
        this.name = name;
        this.description = description;
        if (slotRequired < 20) {
            this.slotRequired = slotRequired;
        } else throw new RuntimeException("The slot required cannot overcome 20.");
        this.quantity = 1;
    }

    public void increaseQuantity() {
        this.quantity++;
    }

    public void decreaseQuantity() {
        this.quantity--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return slotRequired == item.slotRequired && quantity == item.quantity && Objects.equals(name, item.name) && Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, slotRequired, quantity);
    }

    @Override
    public String toString() {
        return "\n-" + name
                + ", description='" + description
                + ", slotRequired=" + slotRequired
                + ", quantity= x" + quantity;
    }

}
