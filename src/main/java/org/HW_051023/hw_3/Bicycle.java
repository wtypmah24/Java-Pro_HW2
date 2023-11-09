package org.HW_051023.hw_3;

public class Bicycle {
//    Напишите класс Велосипед  с минимум пятью полями. В программе создайте 3 разных велосипеда
//    (например, шоссейный, горный, детский) и выведите каждый из них в консоль.
//    Создайте массив из этих велосипедов. С помощью Arrays.toString() превратите массив в строку и выведите в консоль.
//    Запустите программу.
//    Вернитесь в объявление класса велосипед. Переопределите метод toString,
//    чтобы он выводил полное описание велосипеда по его полям.
//    Перейдите в код метода Arrays.toString() и посмотрите на его реализацию.
//    В какой момент автомобиль становится строкой внутри этого метода?

    private int numberOfWheels;
    private int numberOfSpeeds;
    private String manufactureName;
    private BikeType bikeType;

    @Override
    public String toString() {
        return "Bicycle{" +
                "numberOfWheels=" + numberOfWheels +
                ", numberOfSpeeds=" + numberOfSpeeds +
                ", manufactureName='" + manufactureName + '\'' +
                ", bikeType=" + bikeType +
                '}';
    }

    public Bicycle(int numberOfWheels, int numberOfSpeeds, String manufactureName, BikeType bikeType) {
        this.numberOfWheels = numberOfWheels;
        this.numberOfSpeeds = numberOfSpeeds;
        this.manufactureName = manufactureName;
        this.bikeType = bikeType;
    }
}
