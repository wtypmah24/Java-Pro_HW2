package org.HW_110124.task_2;

import org.HW_110124.task_2.connector.Connector;
import org.HW_110124.task_2.exchanger.Exchanger;

public class Main {
    private static final String HOST = "local host";
    private static final String PORT = "8080";
    private static final String PROTOCOL = "HTTPS";
    public static void main(String[] args) {

        Thread videoThread = new Thread(new Exchanger(Connector.getConnection(HOST, PORT, PROTOCOL), "Video"));
        Thread audioThread = new Thread(new Exchanger(Connector.getConnection(HOST, PORT, PROTOCOL), "Audio"));
        Thread gameThread = new Thread(new Exchanger(Connector.getConnection(HOST, PORT, PROTOCOL), "Game"));

        videoThread.start();
        audioThread.start();
        gameThread.start();
    }
}
