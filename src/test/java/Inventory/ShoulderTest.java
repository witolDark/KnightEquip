package Inventory;

import junit.framework.TestCase;
import org.junit.Assert;

public class ShoulderTest extends TestCase {

    public void testCreateItem() {
        Shoulder shoulder = Shoulder.createItem();
        Assert.assertNotNull(shoulder.getLevel());
        Assert.assertNotNull(shoulder.getArmour());
        Assert.assertNotNull(shoulder.getSubStat());
        Assert.assertNotNull(shoulder.getSubStatValue());
    }
}