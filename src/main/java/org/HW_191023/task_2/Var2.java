package org.HW_191023.task_2;

import java.util.*;

public class Var2 {
    /*
     * Создайте коллекцию (List или Set), добавьте несколько элементов.
     * Организовать цикл while по коллекции с помощью итератора.
     * Организовать цикл for (не путать с foreach!) по коллекции с помощью итератора.
     */
    public static void main(String[] args) {
        Set<Integer> nums = new HashSet<>();
        nums.add(1); //
        nums.add(45);//
        nums.add(3);//
        nums.add(5);//
        nums.add(7);//
        nums.add(8);//
        nums.add(10);//
        nums.add(11);//
        nums.add(12);//
        nums.add(13);//
        nums.add(17);//
        Iterator<Integer> iterator = new Iterator<>() {
            final ArrayList<Integer> innerArray = new ArrayList<>(nums);
            final ArrayList<Integer> primeArray = new ArrayList<>();

            {
                innerArray.sort(Comparator.naturalOrder());
                for (int i = 0; i < innerArray.size(); i++) {
                    boolean isPrime = true;
                    if (innerArray.get(i) <= 1) isPrime = false;
                    else {
                        for (int j = 2; j < i; j++) {
                            if (innerArray.get(i) % j == 0){
                                isPrime = false;
                                break;
                            }
                        }
                    }
                    if (isPrime){
                        primeArray.add(innerArray.get(i));
                    }
                }
            }
            @Override
            public boolean hasNext() {
                return !primeArray.isEmpty();
            }

            @Override
            public Integer next() {
                if (!hasNext()) throw new NoSuchElementException();
                return primeArray.remove(0);
            }
        };
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
