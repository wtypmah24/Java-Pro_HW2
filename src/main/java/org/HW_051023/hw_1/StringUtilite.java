package org.HW_051023.hw_1;

import java.sql.Array;
import java.util.Arrays;
import java.util.Random;

public class StringUtilite {
//    1 уровень сложности: №1
//    Создайте утилитарный класс, который будет хранить полезные методы работы со строками.
//    В нём будет один приватный конструктор по умолчанию, а также только статические методы:

    private StringUtilite(){}
    private static Random random = new Random();

    //    generateWord – генерирует строку заданной длины, состоящую только из букв английского алфавита
    private static String generateWord(int length) {

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < length; i++) {
            word.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        return word.toString();
    }

    //    generateNumeric – генерирует строку заданной длины, состоящую из цифр
    private static String generateNumeric(int length){
        String numString = "";
        for (int i = 0; i < length; i++) {
            int randomNum = random.nextInt(9);
            numString = numString + randomNum;
        }
        return numString;
    }

    //    splitByFirst – находит в строке первый символ, который не является буквой или цифрой и разделяет строку на части,
//    используя найденный символ в качестве разделителя. Например, splitByFirst(“Я люблю Java!”)
//    вернёт массив строк [“Я”, “люблю”, “Java!”], а splitByFirst(“Люди! Я люблю Java! Ура!”) вернёт массив строк
//    [“Люди”, “ Я люблю Java”, “ Ура”, “”]
    private static String[] splitByFirst(String text){
        int count = 0; // size of the String array
        char firstChar = 0; // first not a letter or digit char

        //Determine first not a letter or digit char
        for (char c : text.toCharArray()){
            if(!Character.isLetterOrDigit(c)){
                firstChar = c;
                break;
            }
        }
        //Count real size of the Sting array
        for (char c : text.toCharArray()){
            if(c == firstChar){
                count++;
            }
        }

        //Declare String array
        String [] splittedString = new String[count];

        //Array index
        int j = 0;
        //String Builder is to create strings
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if(c != firstChar){
                temp.append(c);
            }
            else{
                splittedString[j++] = String.valueOf(temp);
                //Refresh stringBuilder
                temp = new StringBuilder();
            }

        }
        return splittedString;
    }

    //    isNumeric – проверяет, состоит ли данная строка только из цифр (может быть распознана как целое неотрицательное число)
    private static boolean isNumeric (String string){
        for(char c : string.toCharArray()){
            if (!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //    Используйте все методы в коде метода main.
        System.out.println(Arrays.toString(splitByFirst("Люди! Я люблю Java! Ура!")));
        System.out.println(isNumeric("1223435464"));
        System.out.println(generateWord(5));
        System.out.println(generateNumeric(5));
    }


}
