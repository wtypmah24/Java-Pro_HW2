package org.HW_311023.parser;


import org.HW_311023.exception.CommandLineParserException;
import org.HW_311023.sorting.setting.SortingSetting;

import java.util.ArrayList;
import java.util.List;

public class CommandLineParser {
    private CommandLineParser() {
    }

    /**
     * @param args is command line arguments
     * @return new SortingSetting class that contains all sorting settings
     * @throws CommandLineParserException
     */
    public static SortingSetting parse(String[] args) throws CommandLineParserException {
        if (args.length < 3) throw new CommandLineParserException("Not enough arguments");
        boolean increaseMethod = true;
        String dataType = null;
        String outputFileName = null;
        List<String> inputFiles = new ArrayList<>();

        int i = 0;
        while (i < args.length) {
            String arg = args[i];
            switch (arg) {
                case "-d" -> increaseMethod = false;
                case "-a" -> increaseMethod = true;
                case "-s", "-i" -> dataType = arg;
                default -> {
                    if (outputFileName == null) outputFileName = arg;
                    else inputFiles.add(arg);
                }
            }
            i++;
        }

        if (dataType == null) throw new CommandLineParserException("You have to enter a valid data type");
        if (outputFileName == null) throw new CommandLineParserException("You have not entered the output file name");
        if (inputFiles.isEmpty()) throw new CommandLineParserException("You have not provided input files");

        return new SortingSetting(increaseMethod, dataType, outputFileName, inputFiles);
    }
}
