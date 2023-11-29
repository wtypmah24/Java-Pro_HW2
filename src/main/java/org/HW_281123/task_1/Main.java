package org.HW_281123.task_1;

import java.util.List;

import static java.lang.Math.abs;

public class Main {
    /*
    * Создайте список чисел. С помощью метода forEach выведите каждое число в консоль по модулю.*/
    public static void main(String[] args) {
        List<Integer> list = List.of(-4,-36,-5,4,54,-3,-4,-23,-5,-45,-43);
        list.forEach((Integer e) -> System.out.println(abs(e)));
    }
}