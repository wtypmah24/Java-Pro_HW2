package org.HW_141223.task_2;

import org.HW_141223.task_2.consumer.Consumer;
import org.HW_141223.task_2.producer.Producer;
import org.HW_141223.task_2.warehouse.Warehouse;

import java.util.Arrays;

public class Main {
    /*
    * Создайте реализацию программы Поставщик – Склад - Потребитель на основе блокирующей очереди. */
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse(15);

        makeProducers(120, warehouse, 2000);

        makeConsumers(10, warehouse, 1500);
    }
    private static void makeConsumers (int amount, Warehouse warehouse, int consumingRate){
        Arrays.stream(new int[amount]).mapToObj(e -> new Thread(new Consumer(warehouse, consumingRate))).forEach(Thread::start);
    }

    private static void makeProducers(int amount, Warehouse warehouse, int productionRate){
        Arrays.stream(new int[amount]).mapToObj(e -> new Thread(new Producer(warehouse, productionRate))).forEach(Thread::start);
    }
}
