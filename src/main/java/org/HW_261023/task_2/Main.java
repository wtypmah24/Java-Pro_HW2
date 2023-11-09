package org.HW_261023.task_2;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Main {

    /*
    * Напишите параметризированный метод для нахождения максимального элемента
    * в диапазоне [begin, end) среди элементов List. Какую границу должен иметь параметр такого метода?
    * */
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(50));
        }
        System.out.println(findMax(list, 2, 7));

        System.out.println("================");

        List<Character> list1 = new ArrayList<>();
        char randomChar;
        for (int i = 0; i < 30; i++) {
            randomChar = (char) (random.nextInt(26) + 'a');
            list1.add(randomChar);
        }
        System.out.println(findMax(list1, 7, 20));
    }
    public static <T extends Comparable> List<T> findMax (List<T> list, int begin, int end){
        List<T> maxList = new ArrayList<>();
        list.sort(Comparator.<T>naturalOrder());
        for (int i = begin; i < end; i++) {
            maxList.add(list.get(i));
        }
        return maxList;
    }
}
