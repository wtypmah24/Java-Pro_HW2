package org.HW_091123.task_2.povs;

public class Penguin implements WingPOVs{
    //TODO Инкапсулируйте то, что меняется
    private String name;
    public int distanceMade;
    @Override
    public void fly() {
        //Penguin can't fly
    }

    @Override
    public void swim() {
        System.out.println("Penguin swim");
    }

    @Override
    public void run() {
        System.out.println("Penguin runs");
    }
}
