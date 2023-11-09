package org.HW_241023.task_2;

import java.util.Stack;

public class Granny {
    public Granny() {
        this.pancakes = new Stack<>();
    }

    protected Stack<Pancake> pancakes;
    public void cookPancake(){
        pancakes.push(new Pancake());
        pancakes.push(new Pancake());
    }

    public Stack<Pancake> getPancakes() {
        return pancakes;
    }
}
