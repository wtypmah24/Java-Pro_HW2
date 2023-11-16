package org.HW_141123.task_3.calculator;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class Calculator {
    private static final int MINUTES_IN_HOUR = 60;
    public static int getDistanceBetweenCities(Map<String, Integer> wayPoints, String departure, String destination) {
        if (!wayPoints.containsKey(departure) || !wayPoints.containsKey(destination)) {
            throw new IllegalArgumentException("Invalid departure or destination city");
        }
        int wayToGoDestination = wayPoints.get(destination);
        int wayToGoDeparture = wayPoints.get(departure);

        return wayToGoDestination - wayToGoDeparture;
    }
    private static int travelDuration(int distance, int speed){
        return (distance / speed) * MINUTES_IN_HOUR;
    }

    //ETA - Estimated time of arrival
    public static LocalDateTime getETAtoCiy(Map<String, Integer> wayPoints,
                                            String departure,
                                            String destination,
                                            LocalDateTime departureTime,
                                            int speed) {
        int distanceToGo = getDistanceBetweenCities(wayPoints, departure, destination);
        int travelDurationInMinutes = travelDuration(distanceToGo, speed);
        return departureTime.plusMinutes(travelDurationInMinutes);
    }

    public static Map<String, LocalDateTime> getSchedule(Map<String, Integer> wayPoints,
                                                         LocalDateTime departureTime,
                                                         int speed){
        Map<String, LocalDateTime> schedule = new LinkedHashMap<>();

        for (Map.Entry<String, Integer> entry : wayPoints.entrySet()) {
            String wayPoint = entry.getKey();
            int distance = entry.getValue();
            int travelDuration = travelDuration(distance,speed);
            LocalDateTime eta = departureTime.plusMinutes(travelDuration);
            schedule.put(wayPoint, eta);
        }
        return schedule;
    }
}
