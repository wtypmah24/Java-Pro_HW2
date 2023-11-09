package org.HW_171023.task_2;

public class Main {
    public static void main(String[] args) {
        ProperFraction num1 = new ProperFraction(3, 5);
        ProperFraction num2 = new ProperFraction(1, 2);

        System.out.println(num1.hashCode());
        System.out.println(num2.hashCode());
        System.out.println(num1.equals(num2));
    }
}
