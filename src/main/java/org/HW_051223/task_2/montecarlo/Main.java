package org.HW_051223.task_2.montecarlo;

import org.HW_051223.task_2.montecarlo.coin.toss.CoinToss;
import org.HW_051223.task_2.montecarlo.result.CoinTossResult;

public class Main {

    public static void main(String[] args) {
        final int NUM_SIMULATIONS = 10_000_0000;
        final int NUM_THREADS = 100;
        CoinTossResult globalResult = new CoinTossResult();

        CoinToss[] tasks = new CoinToss[NUM_THREADS];
        Thread[] threads = new Thread[NUM_THREADS];

        int tossesPerThread = NUM_SIMULATIONS / NUM_THREADS;
        int remainingTosses = NUM_SIMULATIONS % NUM_THREADS;

        for (int i = 0; i < NUM_THREADS; i++) {
            int startRange = i * tossesPerThread + 1;
            int endRange = (i == NUM_THREADS - 1) ? startRange + tossesPerThread + remainingTosses - 1 : startRange + tossesPerThread - 1;

            tasks[i] = new CoinToss(startRange, endRange, globalResult);
            threads[i] = new Thread(tasks[i]);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Вероятность выпадения орла: " + globalResult.getProbabilityHeads());
        System.out.println("Вероятность выпадения решки: " + globalResult.getProbabilityTails());
    }
}
