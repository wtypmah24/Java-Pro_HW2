package org.HW_121023.task_1;

public class Main {
    /* Создайте программу, которая принимает от пользователя неограниченное количество строк.
    Ввод строк должен закончится, когда пользователь введёт слово quit.
    Выведите в консоль все строки, которые ввёл пользователь.
    Реализуйте два метода – один находит самую длинную строку в списке, второй – самую короткую строку.
    Выведите самую длинную и самую короткую из строк в консоль.*/
    public static void main(String[] args) {

        System.out.println(Utility.getStrings());

        System.out.println("Longest string: " + Longest_Shortest.getLongestString(Utility.getStrings()));
        System.out.println("Shortest string: " + Longest_Shortest.getShortestString(Utility.getStrings()));
    }
}
