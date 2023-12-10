package org.HW_071223.resource;

import lombok.ToString;

@ToString
public class Resource {
    private static int counter = 1;
    private int id;

    public Resource() {
        this.id = counter++;
    }
}
