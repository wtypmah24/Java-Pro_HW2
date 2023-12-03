package org.HW_301123.task_1;

import org.HW_301123.task_1.appartment.Apartment;
import org.HW_301123.task_1.home.House;
import org.HW_301123.task_1.room.Room;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {
        /*
         * 1. Создайте класс Дом, содержащий список Квартир.
         * Каждая квартира содержит список комнат.
         * Каждая комната содержит площадь.
         * Посчитайте суммарную жилую площадь дома.*/

        House house = new House(20, 3, 50.5);

        double totalArea = house.getApartments().stream()
                .flatMap(apartment -> apartment.getRooms().stream())
                .mapToDouble(Room::getArea)
                .sum();
        System.out.println(totalArea);

        /*
         * 2. Среди всех квартир найдите квартиру, площадь которой больше 100 кв. м.
         * Если такая квартира найдена, то выведите её площадь.
         * В противном случае выведите сообщение, что такой квартиры нет.*/

        house.setApartments(List.of
                (new Apartment(List.of(
                        new Room(120),
                        new Room(50),
                        new Room(99)))));

        house.getApartments()
                .stream()
                .flatMap(apartment -> apartment.getRooms().stream())
                .filter(room -> room.getArea() > 100)
                .findFirst()
                .ifPresentOrElse(
                        room -> System.out.println("Площадь квартиры: " + room.getArea() + " кв. м"),
                        () -> System.out.println("Такой квартиры не существует.")
                );

        /*
        * 3. Старый дом расселяют. В новом доме жильцы должны получить
        * квартиры большей площади. Создайте новый список квартир дома,
        * увеличив площадь каждой комнаты на 30%.*/

        List<Room> newRooms = house.getApartments().stream()
                .flatMap(apartment -> apartment.getRooms().stream())
                .map(room -> new Room(room.getArea() * 1.3))
                .toList();

        System.out.println(newRooms);

        /*
        * Дан список, каждый элемент которого – это мапа площадей комнат (комната - площадь).
        * Создайте новые квартиры с комнатами заданных площадей.*/

        Map<Room, Double> roomToArea = newRooms.stream()
                .collect(Collectors.toMap(
                room -> room,
                Room::getArea
        ));

        System.out.println(roomToArea);


    }
}