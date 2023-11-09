package org.HW_101023.task_1;


import org.HW_101023.task_1.months.Months;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a month: " + Arrays.toString(Months.values()));
        String month = scanner.nextLine().toUpperCase(Locale.ROOT);
        Months userMonth = Months.valueOf(month);

        System.out.println("Season is " + userMonth.getSeason() + ", average temperature of the month is " + userMonth.getAverageTemp());
    }
}
