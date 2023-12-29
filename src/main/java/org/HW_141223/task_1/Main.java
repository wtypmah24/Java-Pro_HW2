package org.HW_141223.task_1;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    /*
     * Создайте 10 потоков, каждый из которых «делает вычисления»
     * (генерирует случайное число, ждёт сгенерированное число миллисекунд,
     * добавляет сгенерированное число в общую для всех потоков переменную).
     * Используя AtomicBoolean, создайте флаг, указывающий на возможность
     * авершения приложения. Когда потоки накопят в общей переменной число 1000000 флаг становится true.*/
    private static final AtomicBoolean isItTimeToTerminate = new AtomicBoolean(false);
    private static final int NUMBER_OF_THREADS = 10;
    private static final int TARGET_NUMBER = 100_000;
    private static final AtomicInteger value = new AtomicInteger(0);

    public static void main(String[] args) {
        Thread[] threads = new Thread[NUMBER_OF_THREADS];

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            int finalI = i;
            threads[i] = new Thread(() -> {

                while (!isItTimeToTerminate.get()) {

                    if (value.get() >= TARGET_NUMBER) isItTimeToTerminate.set(true);

                    int randomNumberToAdd = ThreadLocalRandom.current().nextInt(1000);
                    int randomTimeToSleep = ThreadLocalRandom.current().nextInt(200);

                    System.out.println("Thread " + finalI + " sleep " + randomTimeToSleep);

                    try {
                        Thread.sleep(randomTimeToSleep);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    value.addAndGet(randomNumberToAdd);
                    System.out.println("Thread " + finalI + " added number " + randomNumberToAdd);

                }
            });

            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(value.get());
    }
}
