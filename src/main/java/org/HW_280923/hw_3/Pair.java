package org.HW_280923.hw_3;

public class Pair {
    //        Создайте класс для хранения пары строк (Pair). В классе создайте приватные поля first и second.
//        Создайте геттеры для этих полей. Создайте блок инициализации, в котором выведите в консоль значение полей first и second,
//        а затем присвойте полю first значение “one”, а полю second значение «two».
//        Создайте конструктор по умолчанию (без входных параметров).
//        Внутри конструктора выведите в консоль значение полей first и second.
//        Создайте конструктор, который принимает параметры first и second и обновляет значения соответствующих полей.
//        Внутри конструктора выведите в консоль значение полей first и second.
//        В программе создайте объект Pair двумя разными конструкторами.
    private String first;
    private String second;

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }

    {
        System.out.println("Original values");
        System.out.println("first: " + first);
        System.out.println("second: " + second);

        first = "one";
        second = "two";
    }
    public Pair(){
        System.out.println("values after default constructor call: ");
        System.out.println("first: " + first);
        System.out.println("second: " + second);
    }
    public Pair(String first, String second){
        this.first = first;
        this.second = second;
        System.out.println("values after constructor with parameters call: ");
        System.out.println("first: " + first);
        System.out.println("second: " + second);
    }
}
