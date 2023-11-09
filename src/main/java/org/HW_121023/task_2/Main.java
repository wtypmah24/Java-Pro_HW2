package org.HW_121023.task_2;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
    /* Напишите метод, который создаёт список с произвольным количеством элементов.
    Список должен быть заполнен случайными числами в диапазоне от -100 до 100 включительно.
    Напишите второй метод, который принимает список чисел и удаляет из него все отрицательные числа.
    В main вызовите оба метода.*/
    public static @NotNull List<Integer> getRandomList(int length) {
        if (length < 1) throw new RuntimeException("Length must be more than 1!");
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            numbers.add(random.nextInt(-100, 101));
        }
        return numbers;
    }

    public static @NotNull List<Integer> ExtractNegativeNumbers(@NotNull List<Integer> numbers) {
        List<Integer> positiveNumbers = new LinkedList<>();
        for (int number : numbers) {
            if (number > 0) {
                positiveNumbers.add(number);
            }
        }
        return positiveNumbers;
    }

    public static void main(String[] args) {
        List<Integer> example = getRandomList(100);
        System.out.println(example);
        System.out.println(ExtractNegativeNumbers(example));
    }
}
