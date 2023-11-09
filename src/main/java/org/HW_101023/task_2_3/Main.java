package org.HW_101023.task_2_3;


import org.HW_101023.task_2_3.features.IPrintable;
import org.HW_101023.task_2_3.figures.Circle;
import org.HW_101023.task_2_3.figures.Rectangle;
import org.HW_101023.task_2_3.figures.Shape;
import org.HW_101023.task_2_3.figures.Triangle;
import org.HW_101023.task_2_3.parser.Parser;

import java.util.Scanner;

public class Main {
    /*
    Необходимо написать консольное приложение с объектно-ориентированной архитектурой,
    выводящее характеристики заданной пользователем геометрической фигуры. Пользователь вводит имя фигуры
    и её параметры одной строкой. Результатом работы приложения являются вычисленные характеристики.
    Парсинг введённой пользователем строки выполните в отдельном утилитарном классе.
    (таблицу входных и выходных данных см. в презентации)


    Доделайте задание №2. Создайте интерфейс IPrintable, который будет содержать метод print().
    Каждая фигура должна наследовать этот интерфейс. Реализацию метода можно сделать в виде вывода фигуры в консоль символами ⧠, ◍, ⊿, либо текстом или графически (нарисовать символами).
    При выводе данных о фигуре также вызовите метод print.
    Создайте массив IPrintable из нескольких фигур и в цикле вызовите метод print у каждой фигуры.
     */
    public static void main(String[] args) {
        System.out.print("enter the shape (circle, triangle or rectangle) then, separated by a space, its parameters " +
                "(for circle only radius, for triangle length of the each side, for rectangle height and length): ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Shape figure = Parser.parsToFigure(input);
        System.out.println(figure.calculateArea());
        System.out.println(figure.calculatePerimeter());

        Circle circle = new Circle(3.3);
        Triangle triangle = new Triangle(2.2, 3.3, 4.4);
        Rectangle rectangle = new Rectangle(3, 4);

        IPrintable[] shapes = {circle, triangle, rectangle};
        for(IPrintable shape : shapes){
            shape.print();
        }
    }
}
