package org.HW_141123.task_3;

import org.HW_141123.task_3.calculator.Calculator;
import org.HW_141123.task_3.points.WayPoint;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        WayPoint newTravel = new WayPoint();
        newTravel.addWayPoint("Istanbul", 0);
        newTravel.addWayPoint("Athena", 250);
        newTravel.addWayPoint("Sofia", 300);
        newTravel.addWayPoint("Budapest", 150);
        newTravel.addWayPoint("Vien", 500);
        newTravel.addWayPoint("München", 100);
        newTravel.addWayPoint("Berlin", 700);
        LocalDateTime departureTime = LocalDateTime.of(2023, 11, 17, 7, 0);
        System.out.println(Calculator.getSchedule(newTravel.getWayPoints(), departureTime, 70));
    }
}
