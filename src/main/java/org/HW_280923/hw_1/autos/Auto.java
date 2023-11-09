package org.HW_280923.hw_1.autos;

public class Auto {
    @Override
    public String toString() {
        return "Auto{" +
                "Auto type='" + autosType +
                ", power=" + power +
                ", brand= " + brand +
                ", model= " + model+
                '}';
    }
//    Создайте Package (щелчок правой кнопкой мыши на папке src -> New -> Package).
//    1 В созданном пакете создайте класс Автомобиль. Создайте поля для типа автомобиля – грузовик, спорткар,
//    легковой (можно сделать перечисление), мощность двигателя (сколько лошадиных сил),
//    поля для марки и модели автомобиля. Одно из полей сделайте публичным, второе – без модификатора доступа,
//    остальные – приватными. Создайте объект этого класса в программе и попробуйте установить значения для полей.
//    Какие поля возможно установить? Для приватных полей напишите геттеры и сеттеры.
//    2 Создайте класс Завод. Класс будет производить три вида автомобилей (иметь 3 метода) – спорткар, грузовик,
//    легковой. В основной программе создайте несколько автомобилей с помощью класса Завод.
    AutosType autosType;
    public int power;
    private String model;
    private String brand;

    public AutosType getAutosType() {
        return autosType;
    }

    public void setAutosType(AutosType autosType) {
        this.autosType = autosType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
