package Utilities;

import java.io.FileInputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class MyLogger {
    public static Logger LOGGER;

    static {
        try (FileInputStream ins = new FileInputStream("C:\\Users\\witold\\IdeaProjects\\KnightsEquip\\src\\LoggerConfig")) {
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = java.util.logging.Logger.getLogger(MyLogger.class.getName());
        } catch (Exception ignore) {
            System.out.println("Logger creation ERROR");
        }
    }
}
