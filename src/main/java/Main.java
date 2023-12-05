import Knight.Inventory;
import Knight.Knight;
import UserInterface.GUI;
import Utilities.MyLogger;

import java.util.logging.Level;
import java.util.logging.Logger;

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