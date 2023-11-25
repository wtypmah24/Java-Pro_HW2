package org.HW_211123.logger;

import org.HW_211123.log.level.LogLevel;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Класс для записи событий в программе в зависимости от настроек способен выводить сообщения либо в консоль либо файл.
 */
public class Logger {
    private static final String settingsPath = "settings.txt";
    private static final String logPath = "log.dat";
    private LogLevel logLevel;
    private boolean isFileWriting;

    /**
     * При создании объекта он сразу считывает и применяет настройки из файла.
     * После записывает переменные окружения и системные настройки в файл либо выводит в консоль.
     */
    public Logger() {
        setSettings(readSettings());
        writeEnv(isFileWriting);
        writeSystemProperties(isFileWriting);
    }

    private List<String> readSettings() {
        Path settings = Path.of(settingsPath);
        List<String> settingsList = new ArrayList<>();
        try {
            settingsList = Files.readAllLines(settings);
        } catch (IOException e) {
            System.out.println("Can't read settings. " + e.getLocalizedMessage());
        }
        return settingsList;
    }

    private void setSettings(List<String> settingsList) {
        if (settingsList.isEmpty()) {
            logLevel = LogLevel.DEBUG;
            isFileWriting = false;
        } else {
            logLevel = LogLevel.valueOf(settingsList.get(0).toUpperCase());
            isFileWriting = Boolean.parseBoolean(settingsList.get(1));
        }
    }

    /**
     * Единственный публичнй метод для выполнения записи.
     * Принимает в параметры:
     *
     * @param messagePriority - Приоритет сообщения (DEBUG, INFO, WARNING, ERROR)
     * @param message         - Сообщение, которое должно быть записано.
     */
    public void log(LogLevel messagePriority, String message) {
        switch (logLevel) {
            case DEBUG -> debug(message, messagePriority);
            case INFO -> info(message, messagePriority);
            case ERROR -> error(message, messagePriority);
            case WARNING -> warning(message, messagePriority);
        }
    }

    private void debug(String message, LogLevel messagePriority) {
        write(message, messagePriority);
    }

    private void info(String message, LogLevel messagePriority) {
        if (messagePriority == LogLevel.INFO || messagePriority == LogLevel.WARNING || messagePriority == LogLevel.ERROR) {
            write(message, messagePriority);
        }
    }

    private void warning(String message, LogLevel messagePriority) {
        if (messagePriority == LogLevel.WARNING || messagePriority == LogLevel.ERROR) {
            write(message, messagePriority);
        }
    }

    private void error(String message, LogLevel messagePriority) {
        if (messagePriority == LogLevel.ERROR) {
            write(message, messagePriority);
        }
    }

    private void write(String message, LogLevel level) {
        if (!isFileWriting) {
            System.out.println(createMessage(level, message));
        } else {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(logPath, true))) {
                bw.write(message);
                bw.newLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static String createMessage(LogLevel level, String message) {
        LocalDateTime time = LocalDateTime.now();
        return String.format("Date and time: %s, Log level: %s, Message: %s", time, level, message);
    }

    private void writeEnv(boolean isFileWriting) {
        Map<String, String> vars = System.getenv();
        if (!isFileWriting) {
            vars.forEach((k, v) -> System.out.println(k + "\t" + v));
        } else {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(logPath, true))) {
                for (Map.Entry<String, String> entry : vars.entrySet()) {
                    bw.write(entry.getKey() + "\t" + entry.getValue());
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeSystemProperties(boolean isFileWriting) {
        Properties prop = System.getProperties();
        if (isFileWriting) {
            prop.forEach((k, v) -> System.out.println(k + "\t" + v));
        } else {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(logPath, true))){
                prop.forEach((k, v) -> {
                    try {
                        bw.write(k + "\t" + v);
                        bw.newLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
