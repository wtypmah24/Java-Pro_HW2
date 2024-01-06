package org.HW_191223.task_3.delivery.task;

import org.HW_191223.task_3.delivery.queue.DeliveryQueue;

import java.time.LocalDateTime;

public class DeliveryTask {

    String orderName;
    LocalDateTime orderDateTime;
    DeliveryQueue deliveryQueue;
    public DeliveryTask(String orderName, LocalDateTime orderDateTime,DeliveryQueue deliveryQueue) {
        this.orderName = orderName;
        this.orderDateTime = orderDateTime;
        this.deliveryQueue  = deliveryQueue;
    }

    public String getOrderName() {
        return orderName;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

}
