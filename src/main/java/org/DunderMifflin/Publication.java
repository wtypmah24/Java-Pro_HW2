package org.DunderMifflin;

public abstract class Publication {
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
    String name;
    String text;

    public abstract String getInformation();

    public Publication(String name, String text) {
        this.name = name;
        this.text = text;
    }
}
