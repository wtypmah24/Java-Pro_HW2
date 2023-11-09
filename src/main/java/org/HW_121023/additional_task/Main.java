package org.HW_121023.additional_task;

public class Main {
    /* 1 Создайте класс Контейнер, который имеет внутренние габариты и максимальную
массу хранимого груза, а также хранит набор грузов (HeavyBox). Пусть все грузы имеют
одинаковый размер и массу. Создайте метод в классе Контейнер, который будет
принимать груз до тех пор, пока внутренне пространство контейнера не будет заполнено
или не будет достигнута максимальная масса груза, допустимого для контейнера.
2 В main создайте несколько контейнеров разного размера. Затем создавайте грузы и
заполняйте контейнеры, пока все контейнеры не будут максимально загружены.
3 Выведите в консоль, сколько грузов с какими идентификаторами были загружены в
какой каждый контейнер*/
    public static void main(String[] args) {
        HeavyBox box1 = new HeavyBox(1, 103, 25);
        HeavyBox box2 = new HeavyBox(2, 77, 18);

        Container container = new Container(102, 500);

        container.addCargo(box1);
        container.addCargo(box1);
        container.addCargo(box2);
        container.addCargo(box2);
        container.addCargo(box2);
        container.addCargo(box2);
        container.addCargo(box2);
        container.addCargo(box2);

        container.printInfo();

    }
}
