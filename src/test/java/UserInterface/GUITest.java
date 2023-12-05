package UserInterface;

import Knight.Knight;
import junit.framework.TestCase;
import org.junit.Assert;
import Knight.Inventory;

import java.util.Scanner;

public class GUITest extends TestCase {

    public void testGetMenuKey() {
        Knight knight = new Knight();
        Inventory inventory = new Inventory(knight);
        GUI gui = new GUI(knight,inventory);
        Scanner scanner = new Scanner(System.in);
        Assert.assertFalse(gui.getMenuKey("e", scanner));
        Assert.assertTrue(gui.getMenuKey("6", scanner));
    }
}