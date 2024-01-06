package org.HW_191223.task_2;

import org.HW_191223.task_2.client.Client;
import org.HW_191223.task_2.product.Product;
import org.HW_191223.task_2.task.Task;

public class Main {
    /*
    *Создайте классы Клиент, Товар, Задание.
    * Создайте единый механизм для генерации уникальных
    * идентификаторов для каждого из классов
    * (у Клиентов свои идентификаторы, у Товаров – свои, у Заданий - свои).
    * Используйте обёртку ThreadLocal для хранения счетчика
    * уникальных идентификаторов в каждом потоке. Реализуйте класс
    * UniqueIdGenerator, который предоставляет метод generateUniqueId(),
    * возвращающий уникальный идентификатор. */
    public static void main(String[] args) {
        Thread clientThread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                Client client = new Client();
                System.out.printf("В потоке %d создался новый клиент %d\n", Thread.currentThread().threadId(), client.getClientId());
            }
        });
        clientThread.start();

        Thread productThread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                Product product = new Product();
                System.out.printf("В потоке %d создался новый продукт %d\n", Thread.currentThread().threadId(), product.getProductId());
            }
        });
        productThread.start();

        Thread taskThread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                Task task = new Task();
                System.out.printf("В потоке %d создалась новая задача %d\n", Thread.currentThread().threadId(), task.getTaskId());
            }
        });
        taskThread.start();
    }
}
