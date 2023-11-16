package org.HW_141123.task_3.points;

import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
public class WayPoint {
    private Map<String, Integer> wayPoints;

    public WayPoint() {
        this.wayPoints = new LinkedHashMap<>();
    }

    public void addWayPoint(String cityName, int distance) {
        wayPoints.put(cityName, distance);
    }
}