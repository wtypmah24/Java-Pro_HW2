package org.HW_280923.hw_1.factory;


import org.HW_280923.hw_1.autos.Auto;
import org.HW_280923.hw_1.autos.AutosType;

public class Factory {
    //    Создайте Package (щелчок правой кнопкой мыши на папке src -> New -> Package).
//    1 В созданном пакете создайте класс Автомобиль. Создайте поля для типа автомобиля – грузовик, спорткар,
//    легковой (можно сделать перечисление), мощность двигателя (сколько лошадиных сил),
//    поля для марки и модели автомобиля. Одно из полей сделайте публичным, второе – без модификатора доступа,
//    остальные – приватными. Создайте объект этого класса в программе и попробуйте установить значения для полей.
//    Какие поля возможно установить? Для приватных полей напишите геттеры и сеттеры.
//    2 Создайте класс Завод. Класс будет производить три вида автомобилей (иметь 3 метода) – спорткар, грузовик,
//    легковой. В основной программе создайте несколько автомобилей с помощью класса Завод.

    public Auto makeTruck(int power, String model, String brand){
        Auto truck = new Auto();
        truck.setAutosType(AutosType.TRUCK);
        truck.power = power;
        truck.setBrand(brand);
        truck.setModel(model);
        return truck;
    }
    public Auto makeSportCar(int power, String model, String brand){
        Auto sportCar = new Auto();
        sportCar.setAutosType(AutosType.SPORTCAR);
        sportCar.setBrand(brand);
        sportCar.setModel(model);
        sportCar.power = power;
        return sportCar;
    }
    public Auto makePrivateCar(int power, String model, String brand){
        Auto privateCar = new Auto();
        privateCar.setAutosType(AutosType.FAMILYCAR);
        privateCar.setBrand(brand);
        privateCar.setModel(model);
        privateCar.power = power;
        return privateCar;
    }
}
