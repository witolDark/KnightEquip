package Inventory;

import Utilities.Utility;

import java.util.Objects;

public class Shoulder extends Item {
    private final ShoulderSubStats shoulderSubStat;
    private final Integer armour;
    private Shoulder(Integer level, ShoulderSubStats subStat) {
        this.level = level;
        this.armour = level;
        this.shoulderSubStat = subStat;
        this.price = level * 15.45;

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

    public Integer getArmour() {
        return armour;
    }

    public ShoulderSubStats getSubStat() {
        return shoulderSubStat;
    }

    @Override
    public String toString() {
        return name + " : " + price + " gold";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shoulder)) return false;
        Shoulder shoulder = (Shoulder) o;
        return Objects.equals(name, shoulder.name) && Objects.equals(level, shoulder.level) && Objects.equals(subStatValue, shoulder.subStatValue) && shoulderSubStat == shoulder.shoulderSubStat && Objects.equals(armour, shoulder.armour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level, subStatValue, shoulderSubStat, armour);
    }

    public enum ShoulderSubStats {
        Attack,
        ElementalMastery,
        CritRate,
        CritDmg
    }
}
