package Inventory;

import Utilities.Utility;

import java.util.Objects;

public class Boots extends Item {
    private final Double damage;

    private Boots(Integer level) {
        this.level = level;
        this.damage = (double) Math.round(level * 13.25);
        this.subStatValue = (double) Math.round(level * 8.4);
        this.price = level * 10.65;

        this.name = Utility.createName(level, "Boots", "Attack", this.damage);
    }

    public static Boots createItem() {
        int level = (int) (Math.random() * 20 + 1);

        return new Boots(level);
    }

    public Double getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return name + " : " + price + " gold";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Boots)) return false;
        Boots boots = (Boots) o;
        return Objects.equals(name, boots.name) && Objects.equals(level, boots.level) && Objects.equals(subStatValue, boots.subStatValue) && Objects.equals(damage, boots.damage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level, subStatValue, damage);
    }
}
