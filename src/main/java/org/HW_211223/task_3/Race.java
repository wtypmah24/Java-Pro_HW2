package org.HW_211223.task_3;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

public class Race {
    /*
     * В гонке участвуют несколько участников.
     * Все они должны быть подготовлены к гонке,
     * и только после этого стартовать.
     * Используйте CountDownLatch для ожидания подготовки всех участников.*/
    private static final int RACER_COUNT = 10;
    private static final CountDownLatch LATCH = new CountDownLatch(RACER_COUNT);

    public static void main(String[] args) {
        Arrays.stream(new int[RACER_COUNT]).mapToObj(e -> new Thread(() -> {
                    System.out.println("Waiting for all racer...");
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(2000));
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println("Racer: " + Thread.currentThread().getId() + " is ready.");
            LATCH.countDown();
        }))
                .forEach(Thread::start);

        try {
            LATCH.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("All racers are ready!");
    }
}
