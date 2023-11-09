package org.HW_071123.task_1;


import org.HW_071123.task_1.lombok.LombokExample;

public class Main {
    public static void main(String[] args) {
        LombokExample example = new LombokExample();
        LombokExample example1 = new LombokExample();
        example.setFirstField("сетеры присутствуют");
        System.out.println(example.getFirstField());
        System.out.println(example.toString());
        System.out.println(example.hashCode());
        System.out.println(example.equals(example1));
    }
}
