package org.HW_051223.task_2.arraySum;

import org.HW_051223.task_2.arraySum.summarizer.ArraySummarizer;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write array length: ");
        int size = scanner.nextInt();
        System.out.print("Write number of threads: ");
        int threadsNumber = scanner.nextInt();


        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        long start = System.currentTimeMillis();
        ArraySummarizer.getTotalArraySum(array, threadsNumber);
        long end = System.currentTimeMillis();
        System.out.println("one threads: " + (end - start));
    }
}
