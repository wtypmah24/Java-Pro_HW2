package org.HW_280923.hw_1;


import org.HW_280923.hw_1.autos.Auto;
import org.HW_280923.hw_1.factory.Factory;

public class Main {


    //    Создайте Package (щелчок правой кнопкой мыши на папке src -> New -> Package).
//    1 В созданном пакете создайте класс Автомобиль. Создайте поля для типа автомобиля – грузовик, спорткар,
//    легковой (можно сделать перечисление), мощность двигателя (сколько лошадиных сил),
//    поля для марки и модели автомобиля. Одно из полей сделайте публичным, второе – без модификатора доступа,
//    остальные – приватными. Создайте объект этого класса в программе и попробуйте установить значения для полей.
//    Какие поля возможно установить? Для приватных полей напишите геттеры и сеттеры.
//    2 Создайте класс Завод. Класс будет производить три вида автомобилей (иметь 3 метода) – спорткар, грузовик,
//    легковой. В основной программе создайте несколько автомобилей с помощью класса Завод.
    public static void main(String[] args) {
        Factory factory = new Factory();

        Auto truckAuto = factory.makeTruck(23, "Volvo", "Y4");
        Auto sportCarAuto = factory.makeSportCar(56, "Ferrarri", "Bomb");
        Auto familyAuto = factory.makePrivateCar(12, "Volga", "Gazel");


        System.out.println(truckAuto);
        System.out.println(sportCarAuto);
        System.out.println(familyAuto);
    }
}
