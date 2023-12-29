package org.HW_141223.task_2.resource;

import lombok.ToString;

@ToString
public class Resource {
    private static int counter = 1;
    private int id;

    public Resource() {
        this.id = counter++;
    }
}
