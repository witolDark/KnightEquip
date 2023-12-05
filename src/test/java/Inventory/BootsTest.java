package Inventory;

import junit.framework.TestCase;
import org.junit.Assert;

public class BootsTest extends TestCase {
    public void testCreateItem() {
        Boots boots = Boots.createItem();
        Assert.assertNotNull(boots.getLevel());
        Assert.assertNotNull(boots.getDamage());
        Assert.assertNotNull(boots.getSubStatValue());
    }
}