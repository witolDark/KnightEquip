package Inventory;

import Utilities.Utility;

import java.util.Objects;

public class Helmet extends Item {
    private final Integer hp;
    private final HelmetSubstats helmetSubStat;

    private Helmet(Integer level, HelmetSubstats subStat) {
        this.level = level;
        this.hp = level;
        this.helmetSubStat = subStat;
        this.price = level * 12.45;

        switch (subStat) {
            case CritDmg:
                this.subStatValue = (double) Math.round(level * 1.655 * 2);
                break;
            case CritRate:
                this.subStatValue = (double) Math.round(level * 1.655);
                break;
            case Attack:
                this.subStatValue = (double) Math.round(level * 2.43);
                break;
        }

        this.name = Utility.createName(level, "Helmet", String.valueOf(subStat), this.subStatValue);
    }

    public static Helmet createItem() {
        int level = (int) (Math.random() * 20 + 1);
        HelmetSubstats subStat = HelmetSubstats.values()[(int) (Math.random() * 3)];
        return new Helmet(level, subStat);
    }

    public Integer getHp() {
        return hp;
    }

    public HelmetSubstats getSubStat() {
        return helmetSubStat;
    }

    @Override
    public String toString() {
        return name + " : " + price + " gold";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Helmet)) return false;
        Helmet helmet = (Helmet) o;
        return Objects.equals(name, helmet.name) && Objects.equals(level, helmet.level) && Objects.equals(subStatValue, helmet.subStatValue) && Objects.equals(hp, helmet.hp) && helmetSubStat == helmet.helmetSubStat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level, subStatValue, hp, helmetSubStat);
    }

    public enum HelmetSubstats {
        CritDmg,
        CritRate,
        Attack
    }
}
