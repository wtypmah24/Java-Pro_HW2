package org.HW_121023.task_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Utility {
    public static List<String> getStrings() {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        List<String> strings = new ArrayList<>();
        System.out.println("This program used to find the longest and the shortest string");
        System.out.println("Enter your words. If you want to quit just type 'quit'");

        while (!Objects.equals(input, "quit")) {
            input = scanner.nextLine();
            if (!Objects.equals(input, "quit")) {
                strings.add(input);
            }
        }
        return strings;
    }
}
