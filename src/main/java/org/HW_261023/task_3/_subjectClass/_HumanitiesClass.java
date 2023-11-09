package org.HW_261023.task_3._subjectClass;


import org.HW_261023.task_3._student._Student;
import org.HW_261023.task_3._subject.humanities.Humanities;

import java.util.HashSet;
import java.util.Set;

public class _HumanitiesClass extends _SubjectClass<Humanities>{
    Set<_Student<? extends Humanities>> humanityStudent;

    public _HumanitiesClass() {
        humanityStudent = new HashSet<>();
    }

    @Override
    public void addStudent(_Student<? extends Humanities> student) {
        humanityStudent.add(student);
    }

    public Set<_Student<? extends Humanities>> getHumanityStudent() {
        return humanityStudent;
    }
}
