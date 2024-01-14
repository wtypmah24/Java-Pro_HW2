package org.HW_110124.task_2.connection;

import java.util.concurrent.atomic.AtomicInteger;

public class Connection {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id;

    public Connection(String host, String port, String protocol) {
        this.id = count.addAndGet(1);
    }
    public int getId() {
        return id;
    }
}
