package org.HW_141223.task_2.consumer;

import lombok.Getter;
import org.HW_141223.task_2.warehouse.Warehouse;

import java.time.LocalDateTime;

public class Consumer implements Runnable{
    private Warehouse warehouse;
    private static int counter = 1;
    @Getter
    private final int id;
    private final int consumingRate;

    public Consumer(Warehouse warehouse, int consumingRate) {
        this.warehouse = warehouse;
        this.id = counter++;
        this.consumingRate = consumingRate;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(consumingRate);
                System.out.printf("Consumer %d discharged cargo at %s%n", this.getId(), LocalDateTime.now());
                warehouse.unloading();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
