package org.HW_241023.task_1;

public class Main {
    /*
    * Создайте программу Вышибала, которая обслуживает посетителей в порядке их прихода
    * в ночной клуб. Если посетителю меньше 21 года, то в клуб его не пустят.
    * */

    public static void main(String[] args) {
        Visitor visitor1 = new Visitor("Bobby", 21);
        Visitor visitor2 = new Visitor("John", 19);
        Visitor visitor3 = new Visitor("Greg", 32);
        Visitor visitor4 = new Visitor("Holly", 24);
        Visitor visitor5 = new Visitor("Hanna", 22);

        Club rasputin = new Club();

        rasputin.addToQueue(visitor1);
        rasputin.addToQueue(visitor2);
        rasputin.addToQueue(visitor3);
        rasputin.addToQueue(visitor4);
        rasputin.addToQueue(visitor5);

        rasputin.allowToComeIn();
    }
}
