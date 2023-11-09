package org.HW_280923.hw_2;

public class Main {
    // Создайте класс Студент, имеющий поля имя, фамилия и номер группы.
// 1 Напишите минимум 2 конструктора для класса Студент.
// 2 Реализуйте геттеры и сеттеры для класса Студент. В сеттере сделайте проверку, что номер группы положительный.
// В противном случае бросьте исключение throw new RuntimeException(“Номер группы должен быть положительным”);
// 3 Создайте метод «перейти в следующую группу». При вызове метода студент переводится в следующую по номеру группу
// (чтобы не сдавать экзамены  ).
// 4 Создайте в программе объект студента.
// 5 Добавьте клонирующий конструктор к классу Студент. В программе склонируйте созданный ранее объект.
// Проверьте с помощью ==, что объекты имеют разные ссылки в памяти. Затем измените одно из полей оригинального
// студента. Изменилось ли то же поле у клона?
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setFirstName("Bon");
        student1.setLastName("Jovi");
        student1.setGrade(3);

        Student student2 = new Student("John", "Wick", 2);
        Student studentClone1 = new Student(student1);
        Student studentClone2 = new Student(student2);

        System.out.println("first student: " + student1);
        System.out.println("second student: " + student2);
        System.out.println("first clone student: " + studentClone1);
        System.out.println("second clone student: " + studentClone2);

        student2.upGrade();
        System.out.println("second student: " + student2);

        System.out.println(studentClone1 == student1);
        System.out.println(studentClone2 == student2);
    }
}
