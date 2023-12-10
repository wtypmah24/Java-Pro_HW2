package org.HW_071223.producer;

import lombok.Getter;
import org.HW_071223.resource.Resource;
import org.HW_071223.warehouse.Warehouse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Properties;

public class Producer implements Runnable {

    private final Warehouse warehouse;
    private static int counter = 1;
    @Getter
    private final int id;
    private final int productionRate;

    public Producer(Warehouse warehouse, String path) {
        this.warehouse = warehouse;
        this.id = counter++;
        this.productionRate = readProductionRate(path);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(productionRate);
                Resource resource = new Resource();
                System.out.printf("Producer %d loaded cargo %s at %s%n", this.getId(), resource, LocalDateTime.now());
                warehouse.loading(resource);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private int readProductionRate(String path) {
        Properties properties = new Properties();
        int productionRate = 0;
        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
            properties.load(bf);
            String consumingRateStr = properties.getProperty("productionRate");
            if (consumingRateStr != null) {
                productionRate = Integer.parseInt(consumingRateStr);
            } else {
                throw new RuntimeException("productionRate not found in the properties file");
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return productionRate;
    }
}