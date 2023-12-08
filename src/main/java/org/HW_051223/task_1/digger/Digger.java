package org.HW_051223.task_1.digger;

import lombok.AllArgsConstructor;
import org.HW_051223.task_1.trench.Trench;

@AllArgsConstructor
public class Digger extends Thread {
    private int diggingSpeed; // how many meters per 10s
    private String name;
    private Trench trench;

    @Override
    public void run() {
        while (true) {
            synchronized (trench) {
                if (trench.currentLength >= trench.getTargetLength()) {
                    break;
                }

                int dug = Math.min((trench.getTargetLength() - trench.currentLength), diggingSpeed);
                trench.currentLength += dug;

                System.out.printf("I am %s and I dug %d meters, " +
                        "%d meters of the trench complete, " +
                        "now I will rest for 10 seconds\n", name, dug, trench.currentLength);

                if (trench.currentLength >= trench.getTargetLength()) {
                    System.out.println("Trench is dug!");
                    break;
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
