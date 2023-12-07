package UserInterface;

import Commands.*;
import Knight.Inventory;
import Knight.Knight;
import Utilities.MyLogger;

import java.text.MessageFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUI {
    private static final String[] menuItem = new String[]{"[1] Details", "[2] Weapon", "[3] Equipment", "[4] Inventory", "[5] Roll Item", "[6] Exit"};
    private final Logger LOGGER = MyLogger.LOGGER;
    Knight knight;
    Inventory inventory;
    private final Invoker invoker;
    Scanner scanner;


    public GUI(Knight knight, Inventory inventory) {
        this.knight = knight;
        this.inventory = inventory;

        scanner = new Scanner(System.in);

        ICommand showDetailsCommand = new ShowDetailsCommand(knight);
        ICommand showChangeWeaponCommand = new ShowChangeWeaponCommand(inventory);
        ICommand showChangeEquipmentCommand = new ShowChangeEquipmentCommand(inventory);
        ICommand showInventoryCommand = new ShowInventoryCommand(inventory);
        ICommand rollItemsCommand = new RollItemsCommand(inventory);

        invoker = new Invoker();
        invoker.setShowDetailsCommand(showDetailsCommand);
        invoker.setShowChangeWeaponCommand(showChangeWeaponCommand);
        invoker.setShowChangeEquipmentCommand(showChangeEquipmentCommand);
        invoker.setShowInventoryCommand(showInventoryCommand);
        invoker.setRollItemsCommand(rollItemsCommand);
    }

    public void printMenu() {
        while (true) {
            for (String item : menuItem) {
                System.out.println(item);
            }

            System.out.print("Enter # of choice: ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                LOGGER.log(Level.INFO, MessageFormat.format("Користувач вибрав пункт головного меню {0}", choice));

                if (getMenuKey(choice)) {
                    scanner.close();
                    return;
                }
            } else {
                LOGGER.log(Level.WARNING, "Користувач ввів не числове значення в меню");
                System.out.println("Wrong input");
                scanner.next();
            }
            System.out.println();
        }
    }

    public boolean getMenuKey(int choice) {
        switch (choice) {
            case 1:
                LOGGER.log(Level.INFO, "Перехід у вивід характеристик лицаря");
                invoker.showKnightDetails();
                LOGGER.log(Level.INFO, "Вихід у головне меню з виводу характеристик лицаря");
                break;
            case 2:
                LOGGER.log(Level.INFO, "Перехід у вивід, зміну зброї лицаря");
                invoker.showChangeWeapon();
                LOGGER.log(Level.INFO, "Вихід у головне меню з виводу, зміни зброї лицаря");
                break;
            case 3:
                LOGGER.log(Level.INFO, "Перехід у перегляд, зміну екіпірування лицаря");
                invoker.showChangeEquipment();
                LOGGER.log(Level.INFO, "Вихід у головне меню з виводу, зміни  екіпірування лицаря");
                break;
            case 4:
                LOGGER.log(Level.INFO, "Перехід у перегляд інвентаря");
                invoker.showInventory();
                LOGGER.log(Level.INFO, "Вихід у головне меню з інвентаря лицаря");
                break;
            case 5:
                LOGGER.log(Level.INFO, "Очікується генерація 5-ти предметів");
                invoker.rollItems();
                LOGGER.log(Level.INFO, "Згенеровано 5 предметів");
                break;
            case 6:
                return true;
            default:
                System.out.println("Невірний символ, відправка повідомлення на емайл..");
                LOGGER.log(Level.WARNING, "Користувач вибрав некорректний пункт головного меню");
                MailSender.send("Wrong main menu key", "User has entered wrong key, but program stand");
                break;
        }
        return false;
    }
}
