package org.bank.validator.validator;


import org.bank.validator.excemption.NotCorrectNumberException;
import org.bank.validator.excemption.WrongLengthException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static void checkLength(String input) throws WrongLengthException {
        // Регулярное выражение для 16 цифр
        String regex = "^\\d{16}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new WrongLengthException("Card number must contain 16 digits");
        }
    }
    private static void luhnMethod(String input) throws NotCorrectNumberException {
        long number = Long.parseLong(input);
        // Calculate checksum
        long sum1 = 0;
        long sum2 = 0;
        long x = number;
        long total = 0;
        long mod1;
        long mod2;
        long d1;
        long d2;
        do {
            // Remove last digit and add to sum1
            mod1 = x % 10;
            x = x / 10;
            sum1 = sum1 + mod1;
            // Remove second last digit
            mod2 = x % 10;
            x = x / 10;
            // Double second last digit and add digits to sum2
            mod2 = mod2 * 2;
            d1 = mod2 % 10;
            d2 = mod2 / 10;
            sum2 = sum2 + d1 + d2;
        }
        while (x > 0);
        total = sum1 + sum2;
        // Next check Luhn Algorithm
        //return total % 10 == 0;
        if(total % 10 != 0) throw new NotCorrectNumberException("Wrong card number");
    }

    public static boolean isCorrect(String input) {
        try {
            checkLength(input);
            luhnMethod(input);
            return true;
        } catch (WrongLengthException | NotCorrectNumberException e) {
            e.printStackTrace();
            return false;
        }
    }
}
