package org.HW_051223.task_2.montecarlo.coin.toss;

import org.HW_051223.task_2.montecarlo.result.CoinTossResult;

public class CoinToss implements Runnable{
    private final int startRange;
    private final int endRange;
    private final CoinTossResult globalResult;

    public CoinToss(int startRange, int endRange, CoinTossResult globalResult) {
        this.startRange = startRange;
        this.endRange = endRange;
        this.globalResult = globalResult;
    }

    @Override
    public void run() {
        for (int i = startRange; i <= endRange; i++) {
            // Имитация броска монеты (0 - орел, 1 - решка)
            int tossResult = Math.random() < 0.5 ? 0 : 1;

            if (tossResult == 0) {
                globalResult.incrementHeadsCount();
            } else {
                globalResult.incrementTailsCount();
            }
        }
    }
}
