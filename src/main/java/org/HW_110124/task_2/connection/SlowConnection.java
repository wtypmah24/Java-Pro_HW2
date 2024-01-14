package org.HW_110124.task_2.connection;

public class SlowConnection extends Connection {
    private static SlowConnection instance;

    private SlowConnection(String host, String port, String protocol) {
        super(host, port, protocol);
    }

    public static synchronized SlowConnection getInstance(String host, String port, String protocol) {
        instance = instance != null ? instance : new SlowConnection(host, port, protocol);
        return instance;
    }
}