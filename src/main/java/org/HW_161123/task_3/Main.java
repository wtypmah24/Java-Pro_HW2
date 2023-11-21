package org.HW_161123.task_3;

import org.HW_161123.task_3.employee.Employee;

import java.time.LocalDate;

public class Main {
    /*
    * Создайте класс Сотрудник с полями имя, фамилия,
    * дата рождения, должность, заработная плата.
    * Сериализуйте объект и сохраните в файл.
    * Поле заработной платы сериализовать не нужно, т.к. это коммерческая тайна организации.*/
    public static void main(String[] args) {
        Employee employee1 = new Employee("John",
                "Wick",
                "Football player",
                LocalDate.of(1980, 8, 6),
                100.5);

        employee1.serialize("employee1.dat");
    }

}