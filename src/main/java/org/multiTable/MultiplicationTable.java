package org.multiTable;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        getTable(9);
    }
    private static void getTable(int tableSize) {
        for (int i = 1; i <= tableSize; i++) {
            for (int j = 1; j <= tableSize; j++) {
                System.out.printf("%2d|", i * j);
            }
            System.out.println();
            for (int j = 1; j <= tableSize; j++) {
                System.out.print("___");
            }
            System.out.println();
        }
    }
}
