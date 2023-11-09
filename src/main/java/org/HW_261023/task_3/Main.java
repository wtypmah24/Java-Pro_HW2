package org.HW_261023.task_3;


import org.HW_261023.task_3._student._Student;
import org.HW_261023.task_3._subject.exactScience._Mathematics;
import org.HW_261023.task_3._subject.exactScience._Physic;
import org.HW_261023.task_3._subject.humanities._Literature;
import org.HW_261023.task_3._subject.humanities._Philology;
import org.HW_261023.task_3._subject.naturalScience._Biology;
import org.HW_261023.task_3._subject.naturalScience._Chemistry;
import org.HW_261023.task_3._subjectClass._ExactScienceClass;
import org.HW_261023.task_3._subjectClass._HumanitiesClass;
import org.HW_261023.task_3._subjectClass._NaturalScienceClass;

public class Main {
    /*
    * Создайте иерархию учебных предметов
    * (Subject -> Natural sciences/exact sciences/humanities -> Biology,
    *  Chemistry / Physics, Mathematics / Literature, Philology).
    * Напишите класс Student, параметризируемый предметом.
    * Создайте классы студентов по каждому из направлений
    * (Natural sciences/exact sciences/humanities),
    * укажите в наследуемом параметре конкретный тип направления.*/

    public static void main(String[] args) {
        _Student<_Mathematics> mathGreg = new _Student<>("Greg");
        _Student<_Physic> physicAlice = new _Student<>("Alice");
        _Student<_Biology> bioBob = new _Student<>("Bob");
        _Student<_Chemistry> chemJohn = new _Student<>("John");
        _Student<_Literature> litSteve = new _Student<>("Steve");
        _Student<_Philology> philoCaren = new _Student<>("Caren");

        _ExactScienceClass exactScienceClass = new _ExactScienceClass();
        _HumanitiesClass humanitiesClass = new _HumanitiesClass();
        _NaturalScienceClass naturalScienceClass = new _NaturalScienceClass();

        exactScienceClass.addStudent(mathGreg);
        exactScienceClass.addStudent(physicAlice);

        humanitiesClass.addStudent(litSteve);
        humanitiesClass.addStudent(philoCaren);

        naturalScienceClass.addStudent(bioBob);
        naturalScienceClass.addStudent(chemJohn);

        System.out.println(humanitiesClass.getHumanityStudent());
    }

}
