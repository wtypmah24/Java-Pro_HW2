package org.HW_191023.task_1;

import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<FullName> persons = new TreeSet<>();
        FullName p1 = new FullName("Charles", "Dickens");
        FullName p2 = new FullName("Bob", "Dilan");
        FullName p3 = new FullName("Arnold", "Schwarzenegger");
        FullName p4 = new FullName("Don", "Mafian");

        System.out.println("Sorted by first name:");
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);

        System.out.println(persons);

        System.out.println("Sorted by last name:");
        Set<FullName> persons2 = new TreeSet<>(new PersonsLastNameComparator());
        persons2.add(p1);
        persons2.add(p2);
        persons2.add(p3);
        persons2.add(p4);

        System.out.println(persons2);
    }
}
