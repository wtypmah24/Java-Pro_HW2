package org.HW_071223.warehouse;

import org.HW_071223.resource.Resource;

import java.util.LinkedList;
import java.util.Queue;

public class Warehouse {
    private final Queue<Resource> resources = new LinkedList<>();
    private final int CAPACITY;

    public Warehouse(int CAPACITY) {
        this.CAPACITY = CAPACITY;
    }

    public synchronized void loading(Resource resource) {
        while (resources.size() >= CAPACITY) {
            try {
                System.out.println("Warehouse is full. Waiting for discharging.");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Loaded cargo " + resource);
        resources.add(resource);
        notifyAll();
    }

    public synchronized void discharge() {
        while (resources.size() == 0) {
            try {
                System.out.println("Warehouse is empty. Waiting for loading.");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Resource resource = resources.poll();
        System.out.println("Discharged cargo " + resource);
        notifyAll();
    }
}
