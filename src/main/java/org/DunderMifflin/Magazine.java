package org.DunderMifflin;


public class Magazine extends Publication implements Printable {
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
    String dateOfPublication;

    public Magazine(String name, String text, String dateOfPublication) {
        super(name, text);
        this.dateOfPublication = dateOfPublication;
    }

    @Override
    public String getInformation() {
        return "Name of the publication is " + name + ", Date of publication is  " + dateOfPublication;
    }

    @Override
    public void print() {
        System.out.println(getInformation());
    }
}
