package org.HW_110124.task_1;

import org.HW_110124.task_1.annotation.EventHandler;
import org.HW_110124.task_1.event.processor.EventProcessor;

public class Main {
    private static final String PACKAGE_NAME = "org.HW_110124.task_1.handlers";

    public static void main(String[] args) {
        System.out.println(EventProcessor.setToEventProcessSystem(PACKAGE_NAME, EventHandler.class));
    }
}
