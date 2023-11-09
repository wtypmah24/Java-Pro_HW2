package org.DunderMifflin;

import javax.xml.namespace.QName;

public class Book extends Publication implements Printable {
    //    Здание 2 (интерфейсы).
//    Определить абстрактный класс Publication с полем name и text. Создать два подкласса – Book (добавить поле ISBN) и
//    Magazine (добавить поле Дата выхода).
//    В классе определить метод getInformation(), возвращающий строку-карточку издания (все характеристики, кроме текста).
//    Отдельно от иерархии создайте класс Paper, который хранит текст.
//    Определить интерфейс Printable, содержащий метод void print(). Классы Book, Magazine и
//    Paper должны реализовать интерфейс Printable.
//    Создать массив типа Printable, который будет содержать разные бумаги, книги и журналы.
//    В цикле пройти по массиву и вызвать метод print() для каждого объекта.
//    Создать статический метод printBooks(Printable[] printable) в классе Book, который выводит на консоль
//    названия только книг. Используем оператор instanceof для проверки типа.
    private final int ISBN;

    public Book(String name, String text, int ISBN) {
        super(name, text);
        this.ISBN = ISBN;
    }

    @Override
    public String getInformation() {
        return "Name of the book is " + name + ", ISBN is " + ISBN;
    }

    @Override
    public void print() {
        System.out.println(getInformation());
    }

    public static void printBooks(Printable[] printable) {
        for (Printable p : printable) {
            if (p instanceof Book) {
                System.out.println(((Book) p).name);
            }
        }
    }
}
