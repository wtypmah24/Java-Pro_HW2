package org.HW_121023.task_3;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Group {
    /* Создайте класс Group, который хранит фамилии всех студентов в учебной группе.
     В классе напишите метод, который по заданным первым буквам фамилии находит всех студентов
      и возвращает результат в виде списка. Вызовите метод в main.*/
    private final List <Student> students;


    public List<Student> getStudents() {
        return students;
    }

    public Group() {
        this.students = new ArrayList<>();
    }

    public void addStudents(Student student){
        students.add(student);
    }

    public List<Student> getSearchedStudents (String key){
        List<Student> targetStudents = new LinkedList<>();
        //Длинный метод для разминки ума.
        for (Student student : students) {
            boolean isMatch = true;
            String sName = student.getName();

            if(sName.length() < key.length()){
                isMatch = false;
            }
            for (int j = 0; j < key.length(); j++) {
                if (key.charAt(j) != sName.charAt(j)) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                targetStudents.add(student);
            }
        }

        //Короткий метод.
        /*for(Student student : students){
            if(student.getName().startsWith(key)){
                targetStudents.add(student);
            }
        }*/
        return targetStudents;
    }
}
