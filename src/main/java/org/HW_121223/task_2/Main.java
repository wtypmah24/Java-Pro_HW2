package org.HW_121223.task_2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    /*
     * Разработайте программу, использующую ConcurrentMap,
     * для обеспечения безопасного обновления значения по условию.
     * Например, уменьшайте значение ключа "stock" на 1 только если текущее значение больше 0.*/

    public static void main(String[] args) {
        Map<String, AtomicInteger> articleToQuantity = new ConcurrentHashMap<>();

        articleToQuantity.put("Iphone", new AtomicInteger(2));
        articleToQuantity.put("Samsung", new AtomicInteger(3));
        articleToQuantity.put("Xiaomi", new AtomicInteger(10));
        articleToQuantity.put("Motorola", new AtomicInteger(4));
        articleToQuantity.put("Nokia", new AtomicInteger(5));

        new Thread(() -> removeByOne(articleToQuantity, "Iphone")).start();
        new Thread(() -> removeByOne(articleToQuantity, "Iphone")).start();
        new Thread(() -> removeByOne(articleToQuantity, "Iphone")).start();
        new Thread(() -> removeByOne(articleToQuantity, "Iphone")).start();

        articleToQuantity.forEach((k, v) -> System.out.println("article " + k + " remains " + v));

    }

    private static void removeByOne(Map<String, AtomicInteger> articleToQuantity, String article) {
        articleToQuantity.computeIfPresent(article, (k, v) -> {
            if (v.get() > 0) {
                v.set(v.get() - 1);
            }
            return v;
        });
    }
}
