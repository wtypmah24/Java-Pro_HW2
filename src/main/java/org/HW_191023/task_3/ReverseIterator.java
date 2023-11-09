package org.HW_191023.task_3;


import java.util.*;

public class ReverseIterator implements Iterator<Integer> {
    /*
     * Создайте итератор по массиву целых чисел, который будет выводить элементы
     * в порядке их убывания. Исходный массив не должен при этом измениться
     * */

    private int currentIndex;
    private final ArrayList<Integer> arrayList;
    public ReverseIterator(Integer [] numbers){
        this.currentIndex = numbers.length - 1;
        arrayList = new ArrayList<>(Arrays.asList(numbers));
        arrayList.sort(Comparator.naturalOrder());
    }
    @Override
    public boolean hasNext() {
        return currentIndex >= 0;
    }
    @Override
    public Integer next() {
        if (!hasNext()) throw new NoSuchElementException();
        int number = arrayList.get(currentIndex);
        currentIndex--;
        return number;
    }
}
