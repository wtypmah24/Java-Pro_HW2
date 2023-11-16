package org.HW_141123.task_2;

import org.HW_141123.task_2.complex.ComplexNumber;

public class Main {
    public static void main(String[] args) {
        ComplexNumber cNumber1 = new ComplexNumber(5, 2);
        ComplexNumber cNumber2 = new ComplexNumber(3, 10);

        System.out.println("First module " +
                cNumber1.getModule() +
                " Second module " +
                cNumber2.getModule() +
                " sum is " +
                cNumber1.getSum(cNumber2) +
                " Multiplication is " +
                cNumber1.multiply(cNumber2));
    }
}
