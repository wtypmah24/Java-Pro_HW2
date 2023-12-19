package org.HW_121223.task_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    /*
     * Дан список чисел из большого количества случайных чисел.
     * Используя синхронизированные коллекции, уберите из списка
     * отрицательные значения. Замерьте время выполнения метода в однопоточном режиме и в многопоточном.*/
    public static void main(String[] args) {
        int numberOfThreads = 100;

        List<Integer> randomList = generateRandomList(1000_000);

        long startMono = System.currentTimeMillis();
        removeNegativeMono(randomList);
        long endMono = System.currentTimeMillis();

        long startPoly = System.currentTimeMillis();
        removeNegativePoly(randomList, numberOfThreads);
        long endPoly = System.currentTimeMillis();

        System.out.println("Running time for ONE thread: " + (endMono - startMono));
        System.out.println("Running time for " + numberOfThreads + " threads: " + (endPoly - startPoly));

    }

    private static List<Integer> generateRandomList(int size) {
        Random r = new Random();
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            randomNumbers.add(r.nextInt(-100, 101));
        }
        return randomNumbers;
    }

    private static List<Integer> removeNegativeMono(List<Integer> input) {
        input.removeIf(i -> i < 0);
        return input;
    }

    private static List<Integer> removeNegativePoly(List<Integer> input, int numberOfThreads) {
        CopyOnWriteArrayList<Integer> safeList = new CopyOnWriteArrayList<>(input);

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> safeList.removeIf(n -> n < 0));
            thread.start();
        }

        return safeList;
    }
}