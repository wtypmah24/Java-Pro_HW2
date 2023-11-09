package org.HW_261023.task_3._subjectClass;


import org.HW_261023.task_3._student._Student;
import org.HW_261023.task_3._subject._Subject;

public abstract class _SubjectClass <T extends _Subject>{
    public void addStudent(_Student<? extends T> student){}
}
