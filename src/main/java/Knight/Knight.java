package Knight;

import Inventory.*;
import Utilities.AllSubStats;
import Utilities.MyLogger;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Knight {
    private final Logger LOGGER = MyLogger.LOGGER;
    private Integer baseHp;
    private Integer baseDamage;
    private Integer additionalDamage;
    private Integer baseArmour;
    private Integer elementalMastery;
    private Double energyRecharge;
    private Double critDamage;
    private Double critRate;
    private Helmet helmet;
    private Cloak cloak;
    private Shoulder shoulder;
    private Boots boots;
    private Weapon weapon;

    public Helmet getHelmet() {
        return helmet;
    }

    public Cloak getCloak() {
        return cloak;
    }

    public Shoulder getShoulder() {
        return shoulder;
    }

    public Boots getBoots() {
        return boots;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public <T> void setEquip(T equip) {
        if (equip instanceof Weapon) {
            this.weapon = (Weapon) equip;
            this.baseDamage += weapon.getBaseDamage();
            changeStats(weapon.getSubStat(), weapon.getSubStatValue());
        }
        else if (equip instanceof Helmet) {
            helmet = (Helmet) equip;
            baseHp += (int) Math.round(baseHp * helmet.getHp() / 100.0);
            changeStats(helmet.getSubStat(), helmet.getSubStatValue());
        }
        else if (equip instanceof Cloak) {
            cloak = (Cloak) equip;
            changeStats(cloak.getSubStat(), cloak.getSubStatValue());
        }
        else if (equip instanceof Shoulder) {
            shoulder = (Shoulder) equip;
            changeStats(shoulder.getSubStat(), shoulder.getSubStatValue());
            baseArmour += (int) Math.round(baseArmour * shoulder.getArmour() / 100.0);
        }
        else if (equip instanceof Boots) {
            boots = (Boots) equip;
            changeStats(AllSubStats.Attack, boots.getSubStatValue());
            additionalDamage += (int) Math.round(boots.getDamage());
        }
        else {
            LOGGER.log(Level.WARNING, "Помилка у виборі екіпірування " + equip);
            return;
        }
        LOGGER.log(Level.INFO, "Предмет успішно обрано " + equip);
    }

    public <T extends Enum<T>> void changeStats(Enum<T> subStat, Double subsValue) {
        if (subStat.name().equals(AllSubStats.CritDmg.name())) {
            critDamage += subsValue;
        }
        else if (subStat.name().equals(AllSubStats.CritRate.name())) {
            critRate += subsValue;
        }
        else if (subStat.name().equals(AllSubStats.Attack.name())) {
            additionalDamage += (int) Math.round(baseDamage * subsValue / 100);
        }
        else if (subStat.name().equals(AllSubStats.ElementalMastery.name())) {
            elementalMastery += (int) Math.round(subsValue);
        }
        else energyRecharge += subsValue;

        LOGGER.log(Level.INFO, "Параметри лицаря змінено у зв'язку з вибором нового предмета");
    }

    public Knight() {
        baseHp = 11405;
        baseDamage = 140;
        baseArmour = 480;
        elementalMastery = 0;
        energyRecharge = 100.0;
        critDamage = 100.0;
        critRate = 50.0;
        additionalDamage = 0;
        helmet = null;
        cloak = null;
        shoulder = null;
        boots = null;
        weapon = null;
    }

    public void showStats() {
        System.out.print("Макс. ОЗ           \t");
        System.out.println(baseHp);
        System.out.print("Сила атаки         \t");
        System.out.println(baseDamage + additionalDamage);
        System.out.print("Броня              \t");
        System.out.println(baseArmour);
        System.out.print("Майстерність стихій\t");
        System.out.println(elementalMastery);
        System.out.println("==========================");
        System.out.print("Крит. шанс        \t");
        System.out.println(critRate + "%");
        System.out.print("Крит. шкода       \t");
        System.out.println(critDamage + "%");
        System.out.print("Відн. енергії     \t");
        System.out.println(energyRecharge + "%");
        LOGGER.log(Level.INFO, "Виведено характеристики лицаря");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Knight)) return false;
        Knight knight = (Knight) o;
        return Objects.equals(baseHp, knight.baseHp) && Objects.equals(baseDamage, knight.baseDamage) && Objects.equals(additionalDamage, knight.additionalDamage) && Objects.equals(baseArmour, knight.baseArmour) && Objects.equals(elementalMastery, knight.elementalMastery) && Objects.equals(energyRecharge, knight.energyRecharge) && Objects.equals(critDamage, knight.critDamage) && Objects.equals(critRate, knight.critRate) && Objects.equals(helmet, knight.helmet) && Objects.equals(cloak, knight.cloak) && Objects.equals(shoulder, knight.shoulder) && Objects.equals(boots, knight.boots) && Objects.equals(weapon, knight.weapon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseHp, baseDamage, additionalDamage, baseArmour, elementalMastery, energyRecharge, critDamage, critRate, helmet, cloak, shoulder, boots, weapon);
    }
}
