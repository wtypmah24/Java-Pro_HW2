package org.HW_090124.task_1.human;

import java.time.LocalTime;
import java.util.Random;

public class Human {
    private String name;
    private String dateOfBirth;
    private int height;
    private boolean isRightHanded;

    public Human() {
    }

    public Human(String name, String dateOfBirth, int height, boolean isRightHanded) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.height = height;
        this.isRightHanded = isRightHanded;
    }

    private void walk() {
        System.out.println("Top-top-top-top");
    }

    private void talk() {
        System.out.println("blah-blah-blah");
    }

    private void scream() {
        System.out.println("AAAAAAAAAA");
    }

    private boolean guessANumber(int providedNumber) {
        Random random = new Random();
        return providedNumber == random.nextInt(100);
    }

    private void sayTime() {
        System.out.println(LocalTime.now());
    }

    private int calculateFibonacci(int size) {
        if (size <= 0) return 0;
        if (size == 1) return 1;

        return calculateFibonacci(size - 1) + calculateFibonacci(size - 2);
    }

    private void likeSomeMeme() {
        System.out.println("""
                   ***   ***
                  ***** *****
                   *******\s
                    ***** \s
                     ***  \s
                      *   \s
                """);
    }

    private Human giveABirth(){
        return new Human();
    }

    private void makeHomeWork(){
        System.out.println("Nah, i'll do it tomorrow...");
    }

    private void countTo(int number){
        for (int i = 1; i <= number; i++) {
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
