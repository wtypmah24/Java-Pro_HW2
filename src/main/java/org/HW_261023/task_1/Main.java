package org.HW_261023.task_1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /*
    * Напишите параметризированный метод для обмена позициями двух разных элементов в массиве.
    * Метод принимает параметризированный массив и индексы элементов, которые нужно обменять.
    * */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        replaceElements(list, 2, 9);
        System.out.println(list);
    }

    public static <T> void replaceElements (List<T> list, int index1, int index2){
        T tmp1 = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, tmp1);
    }
}
