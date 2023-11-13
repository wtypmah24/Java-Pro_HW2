package org.HW_091123.task_2.povs;

public class Griffon implements WingPOVs{
    @Override
    public void fly() {
        System.out.println("Griffon flies");
    }

    @Override
    public void swim() {
        //Griffon can't swim
    }

    @Override
    public void run() {
        System.out.println("Griffon runs");
    }
}
