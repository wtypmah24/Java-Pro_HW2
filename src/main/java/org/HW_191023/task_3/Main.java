package org.HW_191023.task_3;

public class Main {
    /*
    * Создайте итератор по массиву целых чисел, который будет выводить элементы
    * в порядке их убывания. Исходный массив не должен при этом измениться
    * */
    public static void main(String[] args) {
        Integer [] arr = {32,4,3,453,45,645,64,5};

        ReverseIterator iterator = new ReverseIterator(arr);
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}