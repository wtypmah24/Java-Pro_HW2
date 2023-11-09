package org.HW_191023.task_2;

import java.util.*;

public class Var1 {
    /*
    * Создайте коллекцию (List или Set), добавьте несколько элементов.
    * Организовать цикл while по коллекции с помощью итератора.
    * Организовать цикл for (не путать с foreach!) по коллекции с помощью итератора.
    */
    public static void main(String[] args) {
        Set<Integer> nums = new HashSet<>();
        nums.add(1); //
        nums.add(3);//
        nums.add(5);//
        nums.add(7);//
        nums.add(8);//
        nums.add(10);//
        nums.add(11);//
        nums.add(12);//
        nums.add(13);
        nums.add(17);//
        Iterator<Integer> iterator = new Iterator<>() {
            final ArrayList<Integer> innerArray = new ArrayList<>(nums);
            @Override
            public boolean hasNext() {
                return !innerArray.isEmpty();
            }

            @Override
            public Integer next() {
                if(!hasNext()) throw new NoSuchElementException();
                return innerArray.remove(0);
            }
        };
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        for (int i = 0; iterator.hasNext(); i++) {
            System.out.println(iterator.next());
        }
    }
}
