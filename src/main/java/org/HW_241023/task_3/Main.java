package org.HW_241023.task_3;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    /*
    * Создайте программу-переводчик с английского языка.
    * Пользователь вводит слово на английском языке, переводчик показывает перевод.
    * Если переводчик не обнаружил в словаре введённое слово,
    * то он просит пользователя ввести перевод,
    * после чего сохраняет слово и его перевод в словарь.
    *  Программа продолжается, пока пользователь не введёт stopTranslate.
    *
    * */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите слово на русском: ");
        String rusWord;
        String translate = null;

        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("привет", "Hello!");
        dictionary.put("пока", "Bey!");
        dictionary.put("я", "I!");
        dictionary.put("ты", "You!");
        dictionary.put("он", "He!");
        dictionary.put("она", "She!");

        do {
            rusWord = scanner.nextLine().toLowerCase();
            if (dictionary.containsKey(rusWord)){
                System.out.println(dictionary.get(rusWord));
            }
            else{
                System.out.println("Словарь не содержит этого слова. Введите перевод: ");
                translate = scanner.nextLine();
                dictionary.put(rusWord, translate);
            }
        }while (!Objects.equals(rusWord, "stopTranslate") && !Objects.equals(translate, "stopTranslate") );
    }
}
