package org.HW_191223.task_2.id.generator;

public class UniqueIdGenerator {
    private static final ThreadLocal<Integer> counter = ThreadLocal.withInitial(() -> 1);

    public static int generateUniqueId() {
        int id = counter.get();
        counter.set(id + 1);
        return id;
    }
}