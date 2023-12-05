package Inventory;

import Utilities.Utility;

public class Helmet extends Item {
    public enum HelmetSubstats {
        CritDmg,
        CritRate,
        Attack
    }
    private final Integer hp;
    public Integer getHp() {
        return hp;
    }
    private final HelmetSubstats helmetSubStat;

    public HelmetSubstats getSubStat() {
        return helmetSubStat;
    }

    @Override
    public String toString() {
        return getName();
    }

    private Helmet(Integer level, HelmetSubstats subStat) {
        this.level = level;
        this.hp = level;
        this.helmetSubStat = subStat;

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
}
