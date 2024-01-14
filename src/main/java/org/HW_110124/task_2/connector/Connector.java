package org.HW_110124.task_2.connector;

import org.HW_110124.task_2.connection.Connection;
import org.HW_110124.task_2.connection.FastConnection;
import org.HW_110124.task_2.connection.SlowConnection;

import java.util.concurrent.ThreadLocalRandom;

public class Connector {
    private static FastConnection fastConnectionPrototype;
    public static Connection getConnection(String host, String port, String protocol){
        int delay = ThreadLocalRandom.current().nextInt(100, 500);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (delay < 300) {
            fastConnectionPrototype = fastConnectionPrototype != null ? fastConnectionPrototype : new FastConnection(host, port, protocol);
            return fastConnectionPrototype;
        }
        return SlowConnection.getInstance(host, port, protocol);
    }
}
