package org.HW_141123.task_1;

import org.HW_141123.task_1.pizza.Pizza;
import org.HW_141123.task_1.pizza.PizzaLazy;
import org.HW_141123.task_1.pizza.sauce.Sauce;

public class Main {
    /*
    * Создайте класс Пицца с минимум 5 полями.
    * Реализуйте внутренний класс-строитель,
    * помогающий компоновать объект Пицца.*/

    public static void main(String[] args) {
        Pizza pizza = Pizza.builder().
                crust("Cheese").
                sauce(Sauce.GARLIC).
                cheese(true).
                pepperoni(true).
                mushrooms(true).
                build();
        System.out.println(pizza);

        System.out.println("------------------");

        PizzaLazy lazy = PizzaLazy.builder().
                crust("Normal").
                sauce(Sauce.TOMATO).
                cheese(true).
                pepperoni(false).
                mushrooms(false).
                build();
        System.out.println(lazy);
    }
}
