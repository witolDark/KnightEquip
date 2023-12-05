package Inventory;

import junit.framework.TestCase;
import org.junit.Assert;

public class CloakTest extends TestCase {

    public void testCreateItem() {
        Cloak cloak = Cloak.createItem();
        Assert.assertNotNull(cloak.getLevel());
        Assert.assertNotNull(cloak.getSubStat());
        Assert.assertNotNull(cloak.getSubStatValue());
    }
}