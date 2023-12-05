package Inventory;

import Utilities.Utility;

public class Shoulder extends Item {
    public enum ShoulderSubStats {
        Attack,
        ElementalMastery,
        CritRate,
        CritDmg
    }

    private final ShoulderSubStats shoulderSubStat;
    private final Integer armour;
    public Integer getArmour() {
        return armour;
    }

    public ShoulderSubStats getSubStat() {
        return shoulderSubStat;
    }

    @Override
    public String toString() {
        return getName();
    }

    private Shoulder(Integer level, ShoulderSubStats subStat) {
        this.level = level;
        this.armour = level;
        this.shoulderSubStat = subStat;

        switch (subStat) {
            case Attack:
                this.subStatValue = (double) Math.round(level * 13.25);
                break;
            case ElementalMastery:
                this.subStatValue = (double) Math.round(level * 8.4);
                break;
            case CritDmg:
                this.subStatValue = (double) Math.round(level * 1.655 * 2);
                break;
            case CritRate:
                this.subStatValue = (double) Math.round(level * 1.655);
                break;
        }

        this.name = Utility.createName(level, "Shoulder", String.valueOf(subStat), this.subStatValue);
    }

    public static Shoulder createItem() {
        int level = (int) (Math.random() * 20 + 1);
        ShoulderSubStats SubStat = ShoulderSubStats.values()[(int) (Math.random() * 4)];
        return new Shoulder(level, SubStat);
    }
}
