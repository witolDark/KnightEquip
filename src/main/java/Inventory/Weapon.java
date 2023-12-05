package Inventory;

import Utilities.Utility;

import java.util.Objects;

public class Weapon {
    private static final Integer[] basesLegendary = new Integer[]{542, 608, 674};
    private static final Integer[] basesEpic = new Integer[]{454, 510, 565};
    private static final Integer[] basesCommon = new Integer[]{314, 354, 401};
    private static final String[] PASSIVES = new String[]{
            "Наносить оточуючим ворогам 140% фізичної шкоди від загальної шкоди носія раз в 10 с.",
            "Використання звичайної атаки збільшує її крит. шкоду в розмірі 24%",
            "Після виклику елементальної реакції збільшує майстерність стихій на 14 раз в 0.4 с, максимум 4 стаки"
    };
    private final String name;
    private final Integer baseDamage;
    private final WeaponSubstats subStat;
    private final Double subStatsValue;
    private final String passiveAbility;

    private Weapon(String name, Integer baseDamage, WeaponSubstats subStat, Double subStatsValue, String passiveAbility) {
        this.name = name;
        this.baseDamage = baseDamage;
        this.subStat = subStat;
        this.subStatsValue = subStatsValue;
        this.passiveAbility = passiveAbility;
    }

    public static Weapon createItem() {
        int base = 0;
        String name = "";
        switch ((int) (Math.random() * 3)) {
            case 0:
                base = basesLegendary[(int) (Math.random() * 3)];
                name = "Legenday Sword";
                break;
            case 1:
                base = basesEpic[(int) (Math.random() * 3)];
                name = "Epic Sword";
                break;
            case 2:
                base = basesCommon[(int) (Math.random() * 3)];
                name = "Common Sword";
                break;
        }
        double substtatvalue = 0;
        WeaponSubstats subStat = WeaponSubstats.values()[(int) (Math.random() * 5)];
        switch (subStat) {
            case CritDmg:
                substtatvalue = 56.2;
                break;
            case CritRate:
                substtatvalue = 28.1;
                break;
            case Attack:
                substtatvalue = 46.4;
                break;
            case EnergyRecharge:
                substtatvalue = 61.2;
                break;
            case ElementalMastery:
                substtatvalue = 110.0;
                break;
        }
        String passive = PASSIVES[(int) (Math.random() * 3)];

        return new Weapon(name, base, subStat, substtatvalue, passive);
    }

    public WeaponSubstats getSubStat() {
        return subStat;
    }

    public Double getSubStatValue() {
        return subStatsValue;
    }

    public Integer getBaseDamage() {
        return baseDamage;
    }

    @Override
    public String toString() {
        return Utility.YELLOW + "================================================================================" + "\n" +
                name + " Базова атака: " + baseDamage + "\n" +
                subStat + ": " + subStatsValue + "%" + "\n" +
                passiveAbility + Utility.RESET;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weapon)) return false;
        Weapon weapon = (Weapon) o;
        return Objects.equals(name, weapon.name) && Objects.equals(baseDamage, weapon.baseDamage) && subStat == weapon.subStat && Objects.equals(subStatsValue, weapon.subStatsValue) && Objects.equals(passiveAbility, weapon.passiveAbility);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, baseDamage, subStat, subStatsValue, passiveAbility);
    }

    public enum WeaponSubstats {
        CritDmg,
        CritRate,
        Attack,
        EnergyRecharge,
        ElementalMastery
    }
}
