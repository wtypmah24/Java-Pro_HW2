package org.HW_191223.task_3;

import org.HW_191223.task_3.delivery.queue.DeliveryQueue;
import org.HW_191223.task_3.delivery.task.scheduler.DeliveryTaskScheduler;
import org.HW_191223.task_3.order.processing.OrderProcessingTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    /*
    * В интернет-магазине есть два процесса:
    * обработка заказов и доставка товаров.
    * На фоне обработки заказов, нужно периодически
    * планировать доставку готовых товаров. Разработайте
    * программу, используя ThreadPoolExecutor и
    * ScheduledThreadPoolExecutor, чтобы эффективно
    * управлять обработкой заказов и доставкой.*/
    public static void main(String[] args) {

        DeliveryQueue deliveryQueue = new DeliveryQueue();

        ExecutorService orderProcessingExecutor = Executors.newFixedThreadPool(5);

        ScheduledExecutorService deliveryScheduler = Executors.newScheduledThreadPool(4);

        for (int i = 1; i <= 10; i++) {
            String orderName = "Order " + i;
            OrderProcessingTask orderProcessingTask = new OrderProcessingTask(orderName, deliveryQueue);
            orderProcessingExecutor.submit(orderProcessingTask);
        }

        deliveryScheduler.scheduleAtFixedRate(
                new DeliveryTaskScheduler(deliveryQueue),
                1, 2, TimeUnit.SECONDS
        );

        orderProcessingExecutor.shutdown();
        //deliveryScheduler.shutdown();
    }
}
