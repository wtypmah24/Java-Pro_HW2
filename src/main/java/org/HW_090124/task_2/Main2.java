package org.HW_090124.task_2;

import org.HW_090124.task_1.human.Human;
import org.HW_090124.task_2.custom.serializer.CustomSerializer;

public class Main2 {
    /*Создайте собственный класс для сериализации
    объекта из задания 1 в JSON. Используйте Reflection
    API для анализа полей объекта и их значений, чтобы
    динамически создавать JSON-представление объекта.*/
    public static void main(String[] args) {
        Human human = new Human("Bob", "1 January 1900", 180, true);
        CustomSerializer.writeObjectToJsonFile(human, "HW_09.12.24.json");
    }
}
