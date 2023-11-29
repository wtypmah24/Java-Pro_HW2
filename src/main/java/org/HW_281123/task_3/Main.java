package org.HW_281123.task_3;

import org.HW_281123.task_3.functional.iface.CustomFunctionalInterface;

import java.util.Random;

public class Main {
    /*
     * Создайте функциональный интерфейс для генерации случайных чисел
     * в заданном диапазоне. Используйте лямбда-выражение для генерации числа.*/
    public static void main(String[] args) {
        CustomFunctionalInterface customFunctionalInterface = (bottomLimit, upperLimit) -> {
            Random random = new Random();
            return random.nextInt(bottomLimit, upperLimit);
        };

        int random = customFunctionalInterface.makeSomething(-100, 100);
        System.out.println(random);
    }
}
