package org.HW_090124.task_1;

import org.HW_090124.task_1.human.Human;
import org.HW_090124.task_1.util.UtilReflector;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    /*
     * Создайте класс с 10 методами и 4 приватными полями.
     * Геттеры и сеттеры добавлять не нужно.
     * Создайте объект Вашего класса. Выведите в консоль
     * информацию об объекте. Затем пользователь вводит
     * имя поля или метода. Программа определяет, имя какого
     * члена класса было введено. Если введено имя метода, то
     * этот метод немедленно вызывается. Если введено имя поля,
     * то программа запрашивает у пользователя новое значение
     * и устанавливает его новым значением этого поля.*/
    public static void main(String[] args) {
        Human human = new Human("Bob", "1 January 1900", 180, true);
        System.out.println(Arrays.stream(UtilReflector.getAllFields(human)).map(Field::getName).toList());

        //executeOrSet(human, "height");

        System.out.println(Arrays.stream(UtilReflector.getAllMethods(human)).map(Method::getName).toList());

        UtilReflector.executeOrSet(human, "sayTime");
        UtilReflector.executeOrSet(human, "likeSomeMeme");

    }
}
