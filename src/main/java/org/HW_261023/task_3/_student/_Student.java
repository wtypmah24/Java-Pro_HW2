package org.HW_261023.task_3._student;


import org.HW_261023.task_3._subject._Subject;

public class _Student <T extends _Subject>{
    private String name;

    public _Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "_Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
