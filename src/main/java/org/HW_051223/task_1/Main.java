package org.HW_051223.task_1;

import org.HW_051223.task_1.digger.Digger;
import org.HW_051223.task_1.trench.Trench;

public class Main {

    public static void main(String[] args) {
        Trench trench = new Trench(200);
        Digger diggerBob = new Digger(40, "Bob", trench);
        Digger diggerAlex = new Digger(40, "Alex", trench);

        diggerBob.start();
        diggerAlex.start();

        try {
            diggerBob.join();
            diggerAlex.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
