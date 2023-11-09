package org.HW_311023;


import org.HW_311023.exception.CommandLineParserException;
import org.HW_311023.parser.CommandLineParser;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(CommandLineParser.parse(args));

        } catch (CommandLineParserException e) {
            throw new RuntimeException(e);
        }
    }
}
