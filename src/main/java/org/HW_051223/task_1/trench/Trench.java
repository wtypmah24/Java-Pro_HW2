package org.HW_051223.task_1.trench;

import lombok.Getter;

@Getter
public class Trench {
    private final int targetLength;
    public int currentLength;

    public Trench(int targetLength) {
        this.targetLength = targetLength;
        this.currentLength = 0;
    }
}
