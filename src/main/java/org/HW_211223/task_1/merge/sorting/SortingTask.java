package org.HW_211223.task_1.merge.sorting;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class SortingTask extends RecursiveTask<String[]> {
    private final String[] stringsToBeSorted;

    public SortingTask(String[] stringsToBeSorted) {
        this.stringsToBeSorted = stringsToBeSorted;
    }

    @Override
    protected String[] compute() {
        if (stringsToBeSorted.length <= 1) return stringsToBeSorted;

        int mid = stringsToBeSorted.length / 2;

        SortingTask leftTask = new SortingTask(Arrays.copyOfRange(stringsToBeSorted, 0, mid));
        SortingTask rightTask = new SortingTask(Arrays.copyOfRange(stringsToBeSorted, mid, stringsToBeSorted.length));

        invokeAll(leftTask, rightTask);

        return merge(leftTask.join(), rightTask.join());
    }

    private String[] merge(String[] left, String[] right) {
        String[] result = new String[left.length + right.length];

        int i = 0, j = 0, k = 0;

        while (i < left.length || j < right.length) {
            result[k++] = (j == right.length || (i < left.length && left[i].length() <= right[j].length())) ? left[i++] : right[j++];
        }

        return result;
    }
}
