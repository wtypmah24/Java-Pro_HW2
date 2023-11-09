package org.HW_261023.task_3._subjectClass;


import org.HW_261023.task_3._student._Student;
import org.HW_261023.task_3._subject.naturalScience.NaturalScience;

import java.util.HashSet;
import java.util.Set;

public class _NaturalScienceClass extends _SubjectClass<NaturalScience>{
    Set<_Student<? extends NaturalScience>> naturalStudents;

    public _NaturalScienceClass() {
        naturalStudents = new HashSet<>();
    }

    @Override
    public void addStudent(_Student<? extends NaturalScience> student) {
        naturalStudents.add(student);
    }

    public Set<_Student<? extends NaturalScience>> getNaturalStudents() {
        return naturalStudents;
    }
}
