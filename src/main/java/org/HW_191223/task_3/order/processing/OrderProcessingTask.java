package org.HW_191223.task_3.order.processing;

import org.HW_191223.task_3.delivery.queue.DeliveryQueue;
import org.HW_191223.task_3.delivery.task.DeliveryTask;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

public class OrderProcessingTask implements Runnable {
    private final String orderName;
    DeliveryQueue deliveryQueue;

    public OrderProcessingTask(String orderName, DeliveryQueue deliveryQueue) {
        this.orderName = orderName;
        this.deliveryQueue = deliveryQueue;
    }

    public String getOrderName() {
        return orderName;
    }

    @Override
    public void run() {
        System.out.println("Собиараем заказ " + orderName + " .... .....");
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(2000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        DeliveryTask deliveryTask = new DeliveryTask(orderName, LocalDateTime.now(), deliveryQueue);
        deliveryQueue.addDeliveryTask(deliveryTask);
        System.out.println("Заказ собран и добавлен в очередь доставки.");
    }
}