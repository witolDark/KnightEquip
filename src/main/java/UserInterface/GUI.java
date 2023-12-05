package UserInterface;

import Utilities.MyLogger;
import Knight.Knight;
import Knight.Inventory;
import java.text.MessageFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUI {
    private final Logger LOGGER = MyLogger.LOGGER;
    Knight knight;
    Inventory inventory;
    private static final String[] menuItem = new String[] { "[1] Details", "[2] Weapon", "[3] Equipment", "[4] Inventory", "[5] Roll Item", "[6] Exit" };
    public GUI(Knight knight, Inventory inventory) {
        this.knight = knight;
        this.inventory = inventory;
    }
    public void printMenu() {
        while (true) {
            System.out.println();
            for (String item : menuItem) {
                System.out.println(item);
            }

            System.out.print("Enter # of choice: ");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            LOGGER.log(Level.INFO, MessageFormat.format("Користувач вибрав пункт головного меню {0}", choice));

            switch (choice) {
                case "1":
                    LOGGER.log(Level.INFO, "Перехід у вивід характеристик лицаря");
                    knight.showStats();
                    LOGGER.log(Level.INFO, "Вихід у головне меню з виводу характеристик лицаря");
                    break;
                case "2":
                    LOGGER.log(Level.INFO, "Перехід у вивід, зміну зброї лицаря");
                    inventory.showWeapon(scanner);
                    LOGGER.log(Level.INFO, "Вихід у головне меню з виводу, зміни зброї лицаря");
                    break;
                case "3":
                    LOGGER.log(Level.INFO, "Перехід у перегляд, зміну екіпірування лицаря");
                    inventory.showEquipment(scanner);
                    LOGGER.log(Level.INFO, "Вихід у головне меню з виводу, зміни  екіпірування лицаря");
                    break;
                case "4":
                    LOGGER.log(Level.INFO, "Перехід у перегляд інвентаря");
                    inventory.showInventory();
                    LOGGER.log(Level.INFO, "Вихід у головне меню з інвентаря лицаря");
                    break;
                case "5":
                    LOGGER.log(Level.INFO, "Очікується генерація 5-ти предметів");
                    for(int i = 1; i <= 5; i++)
                        inventory.rollItem();
                    LOGGER.log(Level.INFO, "Згенеровано 5 предметів");
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Невірний символ, відправка повідомлення на емайл..");
                    LOGGER.log(Level.WARNING, "Користувач вибрав некорректний пункт головного меню");
                    MailSender.send("Wrong main menu key", "User has entered wrong key, but program stand");
                    break;
            }
        }
    }
}
