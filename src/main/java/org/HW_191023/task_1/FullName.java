package org.HW_191023.task_1;



import java.util.Comparator;

public class FullName implements Comparable<FullName> {
    /*
     * Создайте класс FullName полного имени человека (firstName, lastName).
     * Создайте TreeSet с экземплярами этого класса. При создании TreeSet
     * передайте в него компаратор, который сравнивает экземпляры по полю firstName.
     * Выведите множество в консоль.
     * */
    private final String firstName;
    private final String lastName;

    public FullName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    @Override
    public int compareTo(FullName o) {
        return this.firstName.compareTo(o.firstName);
    }

    @Override
    public String toString() {
        return "FullName{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
