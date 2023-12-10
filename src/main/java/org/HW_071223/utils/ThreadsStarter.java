package org.HW_071223.utils;

import org.HW_071223.consumer.Consumer;
import org.HW_071223.producer.Producer;
import org.HW_071223.warehouse.Warehouse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class ThreadsStarter {

    public static void makeThreads(String path, Warehouse warehouse){
        for (int i = 0; i < getProducersNumber(path); i++) {
            new Thread(new Producer(warehouse, path)).start();
        }

        for (int i = 0; i < getConsumersNumber(path); i++) {
            new Thread(new Consumer(warehouse, path)).start();
        }
    }

    private static int getProducersNumber(String path){
        Properties properties = new Properties();
        int producerCount = 0;
        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
            properties.load(bf);
            String consumingRateStr = properties.getProperty("producerCount");
            if (consumingRateStr != null) {
                producerCount = Integer.parseInt(consumingRateStr);
            } else {
                throw new RuntimeException("producerCount not found in the properties file");
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return producerCount;
    }

    private static int getConsumersNumber(String path){
        Properties properties = new Properties();
        int consumerCount = 0;
        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
            properties.load(bf);
            String consumingRateStr = properties.getProperty("consumerCount");
            if (consumingRateStr != null) {
                consumerCount = Integer.parseInt(consumingRateStr);
            } else {
                throw new RuntimeException("consumerCount not found in the properties file");
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return consumerCount;
    }
}
