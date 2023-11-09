package org.HW_121023.task_3;



import java.util.List;

public class Main{
    public static void main(String[] args){
        Group group = new Group();
        group.addStudents(new Student("Clark"));
        group.addStudents(new Student("Robin"));
        group.addStudents(new Student("Robinson"));
        group.addStudents(new Student("Rabinson"));
        group.addStudents(new Student("Clarkent"));
        group.addStudents(new Student("Klarl"));
        group.addStudents(new Student("Cent"));
        group.addStudents(new Student("Cent"));

        List<Student> searched = group.getSearchedStudents("C");
        for(Student student : searched){
            System.out.println(student.getName());
        }
    }
}
