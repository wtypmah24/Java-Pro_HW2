package org.HW_051223.task_2.arraySum.task;

import lombok.Getter;

@Getter

public class Task {
    private int upperLimit;
    private int bottomLimit;
    private  long result;

    public Task(int bottomLimit, int upperLimit) {
        this.upperLimit = upperLimit;
        this.bottomLimit = bottomLimit;
    }

    public void setResult(long result) {
        this.result = result;
    }
}
