import Utilities.MyLogger;
import Knight.Knight;
import Knight.Inventory;
import UserInterface.GUI;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Main {
    public static void main(String[] args) {
        final Logger LOGGER = MyLogger.LOGGER;
        Knight knight = new Knight();
        Inventory inventory = new Inventory(knight);
        GUI gui = new GUI(knight, inventory);
        LOGGER.log(Level.INFO, "Програма запущена");
        gui.printMenu();
        LOGGER.log(Level.INFO, "Програма завершила своє виконання");
    }
}