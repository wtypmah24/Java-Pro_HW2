package org.HW_171023.task_1;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateFinder {
    /* Напишите метод, который убирает из списка целых чисел все дубликаты.
    №2 */
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(1);
        nums.add(1);
        nums.add(2);
        nums.add(2);
        nums.add(3);
        nums.add(14);
        nums.add(16);

        System.out.println(findDuplicate(nums));
    }
    //Про сохранность последовательности чисел списке не говорится, поэтому можно использовать HashSet.
    public static List<Integer> findDuplicate(List<Integer> input){
        Set<Integer> tmp = new HashSet<>(input);
        return new ArrayList<>(tmp);
    }
}
