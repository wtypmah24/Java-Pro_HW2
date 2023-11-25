package org.HW_211123;

import org.HW_211123.log.level.LogLevel;
import org.HW_211123.logger.Logger;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Logger logger = new Logger();
        Logger logger1 = new Logger();
        logger.log(LogLevel.DEBUG, "msg from logger");
        logger1.log(LogLevel.ERROR, "msg from logger1");
    }
}
