package org.HW_071223;

import org.HW_071223.utils.ThreadsStarter;
import org.HW_071223.warehouse.Warehouse;

public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse(10);
        String path = "producer-consumer.properties";

        ThreadsStarter.makeThreads(path, warehouse);
    }
}