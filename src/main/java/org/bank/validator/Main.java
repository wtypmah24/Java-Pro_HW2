package org.bank.validator;


import org.bank.validator.validator.Validator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    private final static BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {
        System.out.print("Enter a 16-digit card number: ");
        String cardNumber;
        try {
            cardNumber = READER.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Validator.isCorrect(cardNumber));
    }
}
