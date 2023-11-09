package org.HW_241023.task_2;

import java.util.Stack;

public class Grandson {
    private final int age;
    private int pancakeAmount = 0;

    public Grandson(int age) {
        this.age = age;
    }

    public void eatPancake(Stack<Pancake> pancakes){
        pancakes.pop();
        pancakeAmount++;
    }

    public int getAge() {
        return age;
    }

    public int getPancakeAmount() {
        return pancakeAmount;
    }
}
