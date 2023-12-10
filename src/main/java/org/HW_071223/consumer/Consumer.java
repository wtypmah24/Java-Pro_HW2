package org.HW_071223.consumer;

import lombok.Getter;
import org.HW_071223.warehouse.Warehouse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Properties;


public class Consumer implements Runnable {
    private final Warehouse warehouse;
    private static int counter = 1;
    @Getter
    private final int id;
    private final int consumingRate;

    public Consumer(Warehouse warehouse, String path) {
        this.warehouse = warehouse;
        this.id = counter++;
        this.consumingRate = readConsumingRate(path);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(consumingRate);
                System.out.printf("Consumer %d discharged cargo at %s%n", this.getId(), LocalDateTime.now());
                warehouse.discharge();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private int readConsumingRate(String path) {
        Properties properties = new Properties();
        int consumingRate = 0;
        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
            properties.load(bf);
            String consumingRateStr = properties.getProperty("consumingRate");
            if (consumingRateStr != null) {
                consumingRate = Integer.parseInt(consumingRateStr);
            } else {
                throw new RuntimeException("consumingRate not found in the properties file");
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return consumingRate;
    }
}