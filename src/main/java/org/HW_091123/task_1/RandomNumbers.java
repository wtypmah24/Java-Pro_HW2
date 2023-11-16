package org.HW_091123.task_1;

import java.util.Random;

public class RandomNumbers {
    /*
     * Напишите метод, который принимает на вход объект класса Random.
     * Метод должен возвращать случайное нечётное число из диапазона от -100 до 100.
     *  Напишите тест для проверки метода. Сделайте так,
     * чтобы в тесте объект Random выдавал набор ожидаемых чисел, а не случайных.*/

    /**
     *
     * ссылка на тесты https://github.com/wtypmah24/Java-Pro_HW2/blob/main/src/test/java/org/HW_091123/task_1/RandomNumbersTest.java
     */
    public int getRandomEvenInteger(Random random) {
        if (random == null) throw new IllegalArgumentException("You have provided empty argument");
        int randomNUmber = random.nextInt(-100, 99);
        if (randomNUmber % 2 == 0) return randomNUmber + 1;
        else return randomNUmber;
    }
}