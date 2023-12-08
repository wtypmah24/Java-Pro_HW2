package org.HW_051223.task_2.montecarlo.result;

public class CoinTossResult {
    private int headsCount = 0;
    private int tailsCount = 0;

    public synchronized void incrementHeadsCount() {
        headsCount++;
    }

    public synchronized void incrementTailsCount() {
        tailsCount++;
    }

    public double getProbabilityHeads() {
        return (double) headsCount / (headsCount + tailsCount);
    }

    public double getProbabilityTails() {
        return (double) tailsCount / (headsCount + tailsCount);
    }
}
