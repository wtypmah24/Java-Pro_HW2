package org.HW_141223.task_2.producer;

import lombok.Getter;
import org.HW_141223.task_2.resource.Resource;
import org.HW_141223.task_2.warehouse.Warehouse;

import java.time.LocalDateTime;

public class Producer implements Runnable{
    private final Warehouse warehouse;
    private static int counter = 1;
    @Getter
    private final int id;
    private final int productionRate;

    public Producer(Warehouse warehouse, int productionRate) {
        this.warehouse = warehouse;
        this.id = counter++;
        this.productionRate = productionRate;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(productionRate);
                Resource resource = new Resource();
                System.out.printf("Producer %d loaded cargo %s at %s%n", this.getId(), resource, LocalDateTime.now());
                warehouse.loading(resource);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
