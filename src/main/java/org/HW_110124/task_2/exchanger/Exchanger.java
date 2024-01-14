package org.HW_110124.task_2.exchanger;

import lombok.AllArgsConstructor;
import org.HW_110124.task_2.connection.Connection;
@AllArgsConstructor
public class Exchanger implements Runnable{
    private Connection connection;
    private String exchangerType;

    @Override
    public void run() {
        System.out.println("Exchanger type: " + exchangerType + ", connection id: " + connection.getId());
    }
}
