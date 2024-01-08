package org.HW_211223.task_1;

import org.HW_211223.task_1.merge.sorting.SortingTask;
import org.HW_211223.task_1.strings.generator.RandomStringsGenerator;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class MultiThreadMergeSorter {
    /*
    * Дан массив строк на 10_000 элементов. Отсортируйте строки по длине,
    * используя сортировку слиянием. Сортировка должна быть выполнена
    * в многопоточном режиме с применением ForkJoinPool.*/
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        String[] sortedStrings = forkJoinPool.invoke(new SortingTask(RandomStringsGenerator.generateRandomStrings(1000, 10)));
        System.out.println(Arrays.toString(sortedStrings));
    }
}
