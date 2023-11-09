package org.HW_191023.task_1;

import java.util.Comparator;

public class PersonsLastNameComparator implements Comparator<FullName> {
    @Override
    public int compare(FullName o1, FullName o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
