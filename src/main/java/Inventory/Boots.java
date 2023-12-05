package Inventory;

import Utilities.Utility;

public class Boots extends Item {
    private final Double damage;

    public Double getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return getName();
    }

    private Boots(Integer level) {
        this.level = level;
        this.damage = (double) Math.round(level * 13.25);
        this.subStatValue = (double) Math.round(level * 8.4);

        this.name = Utility.createName(level, "Boots", "Attack", this.damage);
    }

    public static Boots createItem() {
        int level = (int) (Math.random() * 20 + 1);

        return new Boots(level);
    }
}
