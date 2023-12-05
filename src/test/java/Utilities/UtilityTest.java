package Utilities;

import junit.framework.TestCase;
import org.junit.Assert;

public class UtilityTest extends TestCase {

    public void testCreateName() {
        Integer level = 16;
        String item = "Helmet";
        String subStat = "Attack";
        Double subStatValue = 55.6;
        String expected = "Legendary Helmet +16 Attack 55.6";
        String actual = Utility.createName(level,item,subStat,subStatValue);
        Assert.assertEquals(expected, actual);
    }
}