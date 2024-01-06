package org.HW_191223.task_3.delivery.task.scheduler;

import org.HW_191223.task_3.delivery.queue.DeliveryQueue;
import org.HW_191223.task_3.delivery.task.DeliveryTask;

public class DeliveryTaskScheduler implements Runnable{
    private final DeliveryQueue deliveryQueue;

    public DeliveryTaskScheduler(DeliveryQueue deliveryQueue) {
        this.deliveryQueue = deliveryQueue;
    }

    @Override
    public void run() {
        DeliveryTask currentDeliveryTask = deliveryQueue.delivering();
        System.out.println("Доставляем заказ: " + currentDeliveryTask.getOrderName() + " полученный (дата и время): " + currentDeliveryTask.getOrderDateTime());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
