package Utilities;

public class Utility {
    public static String createName(Integer level, String item, String subStat, Double subStatValue) {
        StringBuilder name = new StringBuilder();
        if (level >= 16)
            name.append("Legendary ");
        else if (level >= 12)
            name.append("Epic ");
        else
            name.append("Common ");

        name.append(item);
        name.append(" +");
        name.append(level);
        name.append(" ");
        name.append(subStat);
        name.append(" ");
        name.append(subStatValue);

        return name.toString();
    }

    public static String RESET = "\u001B[0m";
    public static String YELLOW = "\u001B[33m";
}
