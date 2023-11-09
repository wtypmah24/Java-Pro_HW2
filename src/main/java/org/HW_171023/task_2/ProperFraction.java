package org.HW_171023.task_2;

public class ProperFraction {
    /* Создайте класс правильной дроби (например, 1/2, 7/8 и т.д.). Числитель и знаменатель будут
    храниться в отдельных полях типа int. Самостоятельно (без генерации в IDE) реализуйте методы equals и
    hashCode для класса. Причём дроби с одинаковым результатом необходимо считать эквивалентными, т.е.
    1/2 эквивалентна 2/4, эквивалентна 5/10 и т.д.*/
    int numerator;
    int denominator;

    public ProperFraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public boolean equals(Object o) {
        // Проверяем происходит ли сравнивание с самим с собой
        //Рефлексивность – для любого заданного (x != null) значения x, выражение x.equals(x) должно возвращать true
        if (this == o) return true;
        //Проверяем принадлежат ли классы одной иерархии наследования.
        if (!(o instanceof ProperFraction)) return false;
        ProperFraction that = (ProperFraction) o;
        //Проверяем равны ли дроби
        return denominator / numerator == that.denominator / that.numerator;
    }

    @Override
    public int hashCode() {
        // Хеш функция простая всего с двумя примитивными полями. Для наших целей можно обойтись без константы 31.
        return (denominator / numerator);
    }
}
