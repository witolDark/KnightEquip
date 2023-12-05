package Knight;

import junit.framework.TestCase;
import org.junit.Assert;
import Inventory.*;
import java.util.ArrayList;

public class InventoryTest extends TestCase {
    public void testSortInventory() {
        Knight knight = new Knight();
        Inventory inventory = new Inventory(knight);

        for (int i = 0; i < 10; i++) {
            inventory.helmets.add(Helmet.createItem());
            inventory.cloaks.add(Cloak.createItem());
            inventory.shoulders.add(Shoulder.createItem());
            inventory.boots.add(Boots.createItem());
        }

        ArrayList<Helmet> helmetsUnexpected = new ArrayList<>(inventory.helmets);
        ArrayList<Cloak> cloaksUnexpected = new ArrayList<>(inventory.cloaks);
        ArrayList<Shoulder> shouldersUnexpected = new ArrayList<>(inventory.shoulders);
        ArrayList<Boots> bootsUnexpected = new ArrayList<>(inventory.boots);

        inventory.sortInventory();

        Assert.assertNotEquals(helmetsUnexpected, inventory.helmets);
        Assert.assertNotEquals(cloaksUnexpected, inventory.cloaks);
        Assert.assertNotEquals(shouldersUnexpected, inventory.shoulders);
        Assert.assertNotEquals(bootsUnexpected, inventory.boots);
    }

    public void testRollItem() {
        Knight knight = new Knight();
        Inventory inventory = new Inventory(knight);

        for (int i = 0; i < 20; i++)
            inventory.rollItem();
        int arraysSize = inventory.helmets.size() + inventory.cloaks.size() + inventory.shoulders.size() + inventory.boots.size() + inventory.weapons.size();
        Assert.assertTrue(arraysSize > 0);
    }
}