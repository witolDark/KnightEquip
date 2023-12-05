package Inventory;

import junit.framework.TestCase;
import org.junit.Assert;

public class HelmetTest extends TestCase {

    public void testCreateItem() {
        Helmet helmet = Helmet.createItem();
        Assert.assertNotNull(helmet.getLevel());
        Assert.assertNotNull(helmet.getHp());
        Assert.assertNotNull(helmet.getSubStat());
        Assert.assertNotNull(helmet.getSubStatValue());
    }
}