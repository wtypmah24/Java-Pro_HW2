package org.HW_191223.task_2.task;

import org.HW_191223.task_2.id.generator.UniqueIdGenerator;

public class Task {
    private  int taskId;

    public Task() {
        this.taskId = UniqueIdGenerator.generateUniqueId();
    }

    public int getTaskId() {
        return taskId;
    }
}
