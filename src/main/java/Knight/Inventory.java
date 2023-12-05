package Knight;

import Inventory.*;
import UserInterface.MailSender;
import Utilities.MyLogger;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Inventory {
    private final Logger LOGGER = MyLogger.LOGGER;
    Knight knight;
    ArrayList<Helmet> helmets = new ArrayList<>() {
    };
    ArrayList<Cloak> cloaks = new ArrayList<>() {
    };
    ArrayList<Shoulder> shoulders = new ArrayList<>() {
    };
    ArrayList<Boots> boots = new ArrayList<>() {
    };
    ArrayList<Weapon> weapons = new ArrayList<>() {
    };

    public Inventory(Knight knight) {
        this.knight = knight;
    }

    public void sortInventory() {
        Comparator<Helmet> helmetComparator = Comparator.comparing(Helmet::getLevel);
        Comparator<Cloak> cloakComparator = Comparator.comparing(Cloak::getLevel);
        Comparator<Shoulder> shoulderComparator = Comparator.comparing(Shoulder::getLevel);
        Comparator<Boots> bootsComparator = Comparator.comparing(Boots::getLevel);

        if (!helmets.isEmpty()) {
            helmets.sort(helmetComparator);
            LOGGER.log(Level.INFO, "Відсортовано список шоломів");
        }
        if (!cloaks.isEmpty()) {
            cloaks.sort(cloakComparator);
            LOGGER.log(Level.INFO, "Відсортовано список плащів");
        }
        if (!shoulders.isEmpty()) {
            shoulders.sort(shoulderComparator);
            LOGGER.log(Level.INFO, "Відсортовано список наплічників");
        }
        if (!boots.isEmpty()) {
            boots.sort(bootsComparator);
            LOGGER.log(Level.INFO, "Відсортовано список чоботів");
        }
    }

    public void rollItem() {
        int itemToRoll = (int) (Math.random() * 5);
        switch (itemToRoll) {
            case 0:
                boots.add(Boots.createItem());
                LOGGER.log(Level.INFO, "Згенеровано чоботи " + boots.get(boots.size() - 1));
                break;
            case 1:
                cloaks.add(Cloak.createItem());
                LOGGER.log(Level.INFO, "Згенеровано плащ" + cloaks.get(cloaks.size() - 1));
                break;
            case 2:
                helmets.add(Helmet.createItem());
                LOGGER.log(Level.INFO, "Згенеровано шолом " + helmets.get(helmets.size() - 1));
                break;
            case 3:
                shoulders.add(Shoulder.createItem());
                LOGGER.log(Level.INFO, "Згенеровано наплічник " + shoulders.get(shoulders.size() - 1));
                break;
            case 4:
                weapons.add(Weapon.createItem());
                LOGGER.log(Level.INFO, "Згенеровано зброю " + weapons.get(weapons.size() - 1));
                break;
        }
        LOGGER.log(Level.INFO, "Викликано сортування інвентаря");
        sortInventory();
    }

    public void showChangeEquipment(Scanner scanner) {
        showEquipment();

        System.out.println("[1] Replace Helmet");
        System.out.println("[2] Replace Cloak");
        System.out.println("[3] Replace Shoulder");
        System.out.println("[4] Replace Boots");
        System.out.println("[Other] Back");
        System.out.print("Choice: ");
        String choice = scanner.nextLine();
        LOGGER.log(Level.INFO, MessageFormat.format("В методі вибору артефакту користувач натиснув {0}", choice));
        switch (choice) {
            case "1":
                LOGGER.log(Level.INFO, "Викликаний метод зміни шолома");
                chooseEquipment(helmets, scanner);
                break;
            case "2":
                LOGGER.log(Level.INFO, "Викликаний метод зміни плаща");
                chooseEquipment(cloaks, scanner);
                break;
            case "3":
                LOGGER.log(Level.INFO, "Викликаний метод зміни наплічника");
                chooseEquipment(shoulders, scanner);
                break;
            case "4":
                LOGGER.log(Level.INFO, "Викликаний метод зміни чоботів");
                chooseEquipment(boots, scanner);
                break;
            default:
                break;
        }
    }

    public void showEquipment() {
        if (knight.getHelmet() != null)
            System.out.println("Helmet:   " + knight.getHelmet());
        else {
            System.out.println("No HELMET equipped yet");
            LOGGER.log(Level.WARNING, "Спроба вивести неіснуючий шолом");
        }
        if (knight.getCloak() != null)
            System.out.println("Cloak:    " + knight.getCloak());
        else {
            System.out.println("No CLOAK equipped yet");
            LOGGER.log(Level.WARNING, "Спроба вивести неіснуючий плащ");
        }
        if (knight.getShoulder() != null)
            System.out.println("Shoulder: " + knight.getShoulder());
        else {
            System.out.println("No SHOULDER equipped yet");
            LOGGER.log(Level.WARNING, "Спроба вивести неіснуючий наплічник");
        }
        if (knight.getBoots() != null)
            System.out.println("Boots:    " + knight.getBoots());
        else {
            System.out.println("No BOOTS equipped yet");
            LOGGER.log(Level.WARNING, "Спроба вивести неіснуючі чоботи");
        }
    }

    public void showWeapon(Scanner scanner) {
        System.out.println(knight.getWeapon());
        System.out.println("[1] Replace, [Other] Back");
        String choice = scanner.nextLine();
        LOGGER.log(Level.INFO, MessageFormat.format("В методі вибору зброї користувач натиснув {0}", choice));
        if (choice.equals("1"))
            chooseEquipment(weapons, scanner);
    }

    public <T> void chooseEquipment(ArrayList<T> items, Scanner scanner) {
        if (items.isEmpty()) {
            System.out.println("No there items avalaible");
            LOGGER.log(Level.WARNING, "Список предметів вибраної категорії пустий");
            return;
        }

        LOGGER.log(Level.INFO, "Обирається предмет" + items.get(0).getClass());

        for (int i = 0; i < items.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + items.get(i));
        }

        while (true) {

            int choose = 0;
            try {
                choose = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Щось пішло не так при виборі: " + items.getClass() + " зачекайте поки ми відсилаємо звіт");
                LOGGER.log(Level.WARNING, "Виключення в виборі індексу артефакта, надсилання на е-майл");
                MailSender.send("Exception", "Scanner NextInt exception in chooseEquipment method, user entered " + choose);
                return;
            }

            if (choose < 1 || choose > items.size()) {
                System.out.println("Невірний індекс");
                LOGGER.log(Level.INFO, "Користувач ввів невірний індекс предмета");
                continue;
            }

            LOGGER.log(Level.INFO, "Предмет вибрано, перехід у метод встановлення");
            knight.setEquip(items.get(choose - 1));
            return;
        }
    }

    public void showInventory() {
        System.out.println("Weapons:");
        for (Weapon weapon : weapons)
            System.out.println(weapon);
        System.out.println("Helmets:");
        for (Helmet helmet : helmets)
            System.out.println(helmet);
        System.out.println("Cloaks:");
        for (Cloak cloak : cloaks)
            System.out.println(cloak);
        System.out.println("Shoulders");
        for (Shoulder shoulder : shoulders)
            System.out.println(shoulder);
        System.out.println("Boots:");
        for (Boots boots : boots)
            System.out.println(boots);
    }

}
