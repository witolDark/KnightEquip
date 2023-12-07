package UserInterface;

import Knight.Inventory;
import Knight.Knight;
import junit.framework.TestCase;
import org.junit.Assert;

public class GUITest extends TestCase {

    public void testGetMenuKey() {
        Knight knight = new Knight();
        Inventory inventory = new Inventory(knight);
        GUI gui = new GUI(knight,inventory);
        Assert.assertTrue(gui.getMenuKey(6));
    }
}