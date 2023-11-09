package org.HW_280923.hw_2;

public class Student<T> {
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
    private String firstName;
    private String lastName;
    private int grade;

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", grade=" + grade +
                '}';
    }

    public Student(String firstName, String lastName, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public Student() {
    }

    public Student(Student<T> original) {
        this.firstName = original.firstName;
        this.lastName = original.lastName;
        this.grade = original.grade;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        if (grade < 0) throw new RuntimeException("Номер группы должен быть положительным");
        this.grade = grade;
    }

    public void upGrade() {
        grade++;
    }
}
