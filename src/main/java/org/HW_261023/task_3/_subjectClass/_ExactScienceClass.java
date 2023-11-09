package org.HW_261023.task_3._subjectClass;


import org.HW_261023.task_3._student._Student;
import org.HW_261023.task_3._subject.exactScience.ExactScience;

import java.util.HashSet;
import java.util.Set;

public class _ExactScienceClass extends _SubjectClass<ExactScience> {
    Set<_Student<? extends ExactScience>> exactStudents;

    public _ExactScienceClass() {
        exactStudents = new HashSet<>();
    }

    @Override
    public void addStudent(_Student<? extends ExactScience> student) {
        exactStudents.add(student);
    }

    public Set<_Student<? extends ExactScience>> getExactStudents() {
        return exactStudents;
    }
}
