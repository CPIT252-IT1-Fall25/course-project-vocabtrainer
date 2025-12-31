package sa.edu.kau.fcit.vecabtrainer.config;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static Logger instance;
    private static String LOG_FILE;

    private Logger() {

        LOG_FILE = getTimestamp() + ".log";

        try {
            new FileWriter(LOG_FILE, true).close();
            System.out.println("Logger is ready..");
        } catch (IOException e) {
            System.out.println("Failed to initialize log file: " + e.getMessage());
        }
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void info(String message) {
        log("INFO", message);
    }

    public void error(String message) {
        log("ERROR", message);
    }

    private void log(String level, String message) {
        String logEntry = getTimestamp() + " [" + level + "] " + message;
        System.out.println(logEntry);
        try {
            PrintWriter out = new PrintWriter(new FileWriter(LOG_FILE, true));
            out.println(logEntry);
            out.flush();
            out.close();
        } catch (IOException e) {
            System.out.println("Error writing to log file: " + e.getMessage());
        }
    }

    private String getTimestamp() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
    }
}
