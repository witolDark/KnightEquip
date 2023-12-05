package Inventory;

import Utilities.Utility;

import java.util.Objects;

public class Cloak extends Item {
    private final CloakSubStats cloakSubStat;

    private Cloak(Integer level, CloakSubStats subStat) {
        this.level = level;
        this.cloakSubStat = subStat;
        this.price = level * 10.45;

        switch (subStat) {
            case Attack:
                this.subStatValue = (double) Math.round(level * 13.25);
                break;
            case EnergyRecharge:
                this.subStatValue = (double) Math.round(level * 2.28);
                break;
            case ElementalMastery:
                this.subStatValue = (double) Math.round(level * 8.4);
                break;
        }

        this.name = Utility.createName(level, "Cloak", String.valueOf(subStat), this.subStatValue);
    }

    public static Cloak createItem() {
        int level = (int) (Math.random() * 20 + 1);
        CloakSubStats SubStat = CloakSubStats.values()[(int) (Math.random() * 3)];
        return new Cloak(level, SubStat);
    }

    public CloakSubStats getSubStat() {
        return cloakSubStat;
    }

    @Override
    public String toString() {
        return name + " : " + price + " gold";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cloak)) return false;
        Cloak cloak = (Cloak) o;
        return Objects.equals(name, cloak.name) && Objects.equals(level, cloak.level) && Objects.equals(subStatValue, cloak.subStatValue) && cloakSubStat == cloak.cloakSubStat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level, subStatValue, cloakSubStat);
    }

    public enum CloakSubStats {
        Attack,
        EnergyRecharge,
        ElementalMastery,
    }
}
