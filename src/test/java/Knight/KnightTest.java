package Knight;

import junit.framework.TestCase;
import Inventory.*;
import org.junit.Assert;

public class KnightTest extends TestCase {

    public void testSetEquip() {
        Knight knight = new Knight();
        knight.setEquip(Helmet.createItem());
        Assert.assertNotNull(knight.getHelmet());
        knight.setEquip(Cloak.createItem());
        Assert.assertNotNull(knight.getCloak());
        knight.setEquip(Shoulder.createItem());
        Assert.assertNotNull(knight.getShoulder());
        knight.setEquip(Boots.createItem());
        Assert.assertNotNull(knight.getBoots());
        knight.setEquip(Weapon.createItem());
        Assert.assertNotNull(knight.getWeapon());
    }

    public void testChangeStats() {
        Knight knight = new Knight();
        Knight knight1 = new Knight();
        knight.setEquip(Helmet.createItem());
        Assert.assertNotEquals(knight,knight1);
    }
}