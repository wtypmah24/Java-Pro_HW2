package org.company;

public class Engineer extends Employee{
    //    Задание 1 (абстрактные классы)
//            1 Создайте абстрактный класс Employee, определите в нём абстрактный метод calculateSalary().
//            2 Создайте подклассы Employee. Например, Manager и Engineer, которые переопределяют метод calculateSalary().
//    Переопределите (реализуйте) метод calculateSalary() в каждом классе так, чтобы метод возвращал размер
//    заработной платы сотрудника.
//            3 Создайте класс Company, который хранит массив/список Employee. Создайте метод расчёта количества денег,
//    которое потребуется для зарплаты в текущий месяц.
    @Override
    public int calulateSalary() {
        return 4000;
    }
}
