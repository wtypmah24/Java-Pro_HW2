package org.HW_241023.task_1;

public class Visitor {
    private final String name;
    private final int age;

    public Visitor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
