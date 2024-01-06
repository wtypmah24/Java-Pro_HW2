package org.HW_191223.task_3.delivery.queue;

import org.HW_191223.task_3.delivery.task.DeliveryTask;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class DeliveryQueue {
    private BlockingQueue<DeliveryTask> deliveryQueue;

    public DeliveryQueue() {
        this.deliveryQueue = new LinkedBlockingQueue<>();
    }

    public void addDeliveryTask(DeliveryTask deliveryTask) {
        deliveryQueue.add(deliveryTask);
    }

    public DeliveryTask delivering() {
        return deliveryQueue.poll();
    }

    public boolean isEmpty() {
        return deliveryQueue.isEmpty();
    }
}
