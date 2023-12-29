package org.HW_141223.task_2.warehouse;

import org.HW_141223.task_2.resource.Resource;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Warehouse {
    BlockingQueue<Resource> resources = new LinkedBlockingQueue<>();
    private final int capacity;

    public Warehouse(int capacity) {
        this.capacity = capacity;
    }

    public void loading(Resource resource) {
        if (resources.size() >= capacity) {
            System.out.println("Warehouse is full. Waiting for discharging.");
        } else {
            System.out.println("Loaded cargo " + resource);
            resources.add(resource);
        }
    }

    public void unloading() {
        if (resources.size() == 0) {
            System.out.println("Warehouse is empty. Waiting for loading.");
        } else {
            Resource resource = resources.poll();
            System.out.println("Discharged cargo " + resource);
        }
    }
}
