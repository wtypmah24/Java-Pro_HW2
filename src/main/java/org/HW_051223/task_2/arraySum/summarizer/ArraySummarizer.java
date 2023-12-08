package org.HW_051223.task_2.arraySum.summarizer;

import org.HW_051223.task_2.arraySum.task.Task;

import java.util.ArrayList;
import java.util.List;

public class ArraySummarizer {

    public static long getPartArraySum(int[] array, int bottomLimit, int upperLimit) {
        long sum = 0L;
        for (int i = bottomLimit; i <= upperLimit; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static long getTotalArraySum(int[] array, int numberOfThreads) throws InterruptedException {
        int arrayLength = array.length;
        long totalSum = 0L;

        List<Task> tasks = getTasks(arrayLength, numberOfThreads);

        for (Task t : tasks) {
            Thread thread = new Thread(() -> t.setResult(getPartArraySum(array, t.getBottomLimit(), t.getUpperLimit())));
            thread.start();
            thread.join();
            totalSum += t.getResult();
        }
        return totalSum;
    }

    private static List<Task> getTasks(int arrayLength, int numberOfThreads) {
        int batchSize = arrayLength / numberOfThreads;
        List<Task> tasks = new ArrayList<>(numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            int bottomLimit = i * batchSize;
            int upperLimit = (i == numberOfThreads - 1) ? arrayLength - 1 : (i + 1) * batchSize - 1;
            Task task = new Task(bottomLimit, upperLimit);
            tasks.add(task);
        }
        return tasks;
    }
}