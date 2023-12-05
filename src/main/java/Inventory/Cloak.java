package Inventory;

import Utilities.Utility;

public class Cloak extends Item {
    public enum CloakSubStats {
        Attack,
        EnergyRecharge,
        ElementalMastery,
    }
    private final CloakSubStats cloakSubStat;

    public CloakSubStats getSubStat() {
        return cloakSubStat;
    }

    @Override
    public String toString() {
        return getName();
    }

    private Cloak(Integer level, CloakSubStats subStat) {
        this.level = level;
        this.cloakSubStat = subStat;

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
}
